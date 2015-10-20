package org.kdea.spring.simpleboard;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService svc;
	 
	@RequestMapping("list")
	public String getList(Model model,@RequestParam int pnum) {
		/*BoardDAO dao = sqlSessionTemplate.getMapper(BoardDAO.class);
		List<BoardVO> list = dao.list();
		NaviVO navi = svc.getNaviVO();
		model.addAttribute("list", list);
		model.addAttribute("navi", navi);
		return "simpleboard/boardList";*/
		
	
		List<BoardVO> list = svc.svclist(pnum);
		NaviVO navi = svc.getNaviVO(pnum);
		navi.setLinknum(navi.getLinks().length);
		System.out.println(navi.getLinks().length+"컨트롤러");
		System.out.println(navi.isRightMore()+"오른쪽 트롤러");
		model.addAttribute("list", list);
		model.addAttribute("navi", navi);
		return "simpleboard/boardList";
		
	}

    @RequestMapping("info")
	public String getEmp(Model model, @RequestParam int bnum) {
    	
    	BoardVO vo = svc.svcinfo(bnum);
		model.addAttribute("Info", vo);
		return "simpleboard/boardInfo";
	}
	
	@RequestMapping(value="input", method=RequestMethod.GET)
	public String InputForm(BoardVO board,Model model) {
		model.addAttribute("BoardVO", board);
		return "simpleboard/boardInput";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	@ResponseBody
	public String Insert(BoardVO board,Model model,HttpServletRequest request) {
		

	boolean check = svc.svcinsert(board);
		return "{\"check\":"+check+"}";
	}
	
	
	@RequestMapping("edit")
	public String Edit(Model model, @RequestParam int bnum) {
		BoardVO vo = svc.svcinfo(bnum);
		model.addAttribute("bnum", bnum);
		model.addAttribute("Info",vo);
		return "simpleboard/boardEdit";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@ResponseBody
	public String Update(Model model, BoardVO vo,HttpServletRequest request) {

		model.addAttribute("bnum", vo.getBnum());
		boolean check= svc.svcupdate(vo);
		return "{\"check\":"+check+",\"bnum\":"+vo.getBnum()+"}";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	@ResponseBody
	public String Delete(Model model, BoardVO vo,HttpServletRequest request) {
		int i = Integer.parseInt( request.getParameter("bnum")) ;

		boolean check= svc.svcdelete(i);
		//이것도 제이슨으로 보내지낟
		return "{\"check\":"+check+"}";
	}
	
	@RequestMapping(value="search", method=RequestMethod.GET)
	public String search(Model model, BoardVO vo,HttpServletRequest request,@RequestParam("word") String word,@RequestParam("cate") String cate) {
		

		
		List<BoardVO> list = svc.svcsearch(word,cate);
		
		model.addAttribute("list",list);
		
    	return "simpleboard/boardList"; 
	}

	public BoardService getSvc() {
		return svc;
	}

	public void setSvc(BoardService svc) {
		this.svc = svc;
	}
}
