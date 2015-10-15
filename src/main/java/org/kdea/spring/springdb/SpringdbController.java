package org.kdea.spring.springdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@RequestMapping("/emp/")
public class SpringdbController {
 
    @Autowired
    private SpringdbService empService;
 
    @RequestMapping("list")
    public String getList(Model model){
        model.addAttribute("list",empService.getEmpList());
        return "emp/empList";
    }
     
    @RequestMapping("info")
    public String getEmp(Model model, @RequestParam int empno){
        model.addAttribute("empInfo",empService.getEmp(empno));
        return "emp/empInfo";
    }
     
    @RequestMapping("insert")  
    public String inserEmp(@ModelAttribute Emp emp) {
        if(emp.getEmpno()==0) {
            return "emp/inputForm";
        }else{
            empService.insertEmp(emp);  
            return "redirect:/emp/list";  
        }
    }  
     
    @RequestMapping("edit")  
    public ModelAndView editEmp(@RequestParam int empno,  
       @ModelAttribute Emp emp) {  
        emp = empService.getEmp(empno);  
        return new ModelAndView("/emp/empEdit", "empInfo", emp);
    }
     
    @RequestMapping("update")  
    public String updateEmp(@ModelAttribute Emp emp) {  
        empService.updateEmp(emp);  
        return "redirect:/emp/list";
    }
     
    @RequestMapping("delete")  
    public String deleteEmp(@RequestParam int empno) {  
        empService.deleteEmp(empno);  
        return "redirect:/emp/list";  
    }  
}