package org.kdea.mybatis;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mb/")
public class EmpMBController {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; // 설정파일에 빈으로 등록되었기 때문에 생성자나 Setter 없이 자동으로 주입

	@RequestMapping("empList")
	public String getEmpList(Model model) {
		EmpDAO dao = sqlSessionTemplate.getMapper(EmpDAO.class);
		List<EmpVO> list = dao.list();
		model.addAttribute("empList", list);
		return "mb/empList";
	}

        @RequestMapping("empInfo")
	public String getEmp(Model model, @RequestParam int empno) {
		EmpDAO dao = sqlSessionTemplate.getMapper(EmpDAO.class);
		EmpVO emp = dao.info(empno);
		model.addAttribute("empInfo", emp);
		return "mb/empInfo";
	}
	
	@RequestMapping(value="empInputForm", method=RequestMethod.GET)
	public String empInputForm(EmpVO emp) {
		return "/mb/empInputForm";
	}
	
	@RequestMapping(value="empInsert", method=RequestMethod.POST)
	public String empInsert(EmpVO emp) {
		EmpDAO dao = sqlSessionTemplate.getMapper(EmpDAO.class);
		int n = dao.insert(emp);
		return "redirect:/mb/empList";
	}
	
	@RequestMapping("empEdit")
	public String empEdit(Model model, @RequestParam int empno) {
		EmpDAO dao = sqlSessionTemplate.getMapper(EmpDAO.class);
		EmpVO emp = dao.info(empno);
		model.addAttribute("empInfo", emp);
		return "/mb/empEdit";
	}
	
	@RequestMapping("empUpdate")
	public String empUpdate(Model model, EmpVO emp) {
		EmpDAO dao = sqlSessionTemplate.getMapper(EmpDAO.class);
		int n = dao.update(emp);
		model.addAttribute("empno", emp.getEmpno());
		return "redirect:/mb/empInfo";
	}
	
	@RequestMapping("empDelete")
	public String empDelete(@RequestParam int empno) {
		EmpDAO dao = sqlSessionTemplate.getMapper(EmpDAO.class);
		int n = dao.delete(empno);
		return "redirect:/mb/empList";
	}
}