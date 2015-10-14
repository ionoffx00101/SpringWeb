package org.kdea.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;



import org.kdea.spring.service.EmpService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {

	@Autowired
	private EmpService empservice;

	@RequestMapping(value = "/emplist", method = RequestMethod.GET)
	public String orderGet(Locale locale, Model model) {
		List<EmpVO> list = empservice.getList();

		model.addAttribute("list", list);
		
		
      
		return "EmpList2";
	}

	@RequestMapping(value = "/empInfo", method = RequestMethod.GET)
	public String getInfo(@RequestParam("empno") int empno, Locale locale,
			Model model) {
		EmpVO ev = empservice.getEmp(empno);

		model.addAttribute("emp", ev);

		return "empInfo";
	}

	@RequestMapping(value = "/empInfo/delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(@RequestParam("empno") int empno, Model model) {
		System.out.println("삭제대상사번:"+empno);
		boolean delOk = empservice.delete(empno);

		return "{\"ok\":"+delOk+"}";
	}

	@RequestMapping(value = "/empInput", method = RequestMethod.GET)
	public String Inputform(Locale locale, Model model) {

		return "empInput";
	}

	@RequestMapping(value = "/empInput", method = RequestMethod.POST)
	@ResponseBody
	public EmpVO Input(EmpVO ev,Locale locale, Model model) {
		boolean Ok = empservice.empInput(ev);

		ev.setOk(Ok);
		
		
		return ev;
	}

	@RequestMapping(value = "/empEdit", method = RequestMethod.GET)
	public String InfoEdit(Locale locale, Model model,
			@RequestParam("empno") int empno) {
		EmpVO ev = empservice.getEmp(empno);
		model.addAttribute("emp", ev);

		return "empEdit";
	}

	@RequestMapping(value = "/empEdit", method = RequestMethod.POST)
	@ResponseBody
	public EmpVO Edit(EmpVO ev, Locale locale, Model model) {

		boolean Ok = empservice.empEdit(ev);

		ev.setOk(Ok);

		return ev;
	}

	public EmpService getMyservice() {
		return empservice;
	}

	public void setMyservice(EmpService empservice) {
		this.empservice = empservice;
	}
}