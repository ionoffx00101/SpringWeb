package org.kdea.spring.service;




import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.kdea.spring.controller.EmpVO;
import org.springframework.stereotype.Service;
@Service
public class EmpService {

	HttpServletRequest request;

	public List<EmpVO> getList() {
		
		return new EmpDAO().getEmpList();
	}

	public EmpVO getEmp(int empno) {
		
		return  new EmpDAO().getEmp(empno);
	}

	public boolean empInput(EmpVO ev) {
		System.out.println("서비스구동확인");
		System.out.println(ev.getEmpno());
		
        try {
        	java.util.Date tmpDate= new java.util.Date();
        	java.sql.Date hireDate= new java.sql.Date(tmpDate.getTime());
        	ev.setHiredate(hireDate);
		} catch (Exception e) {
			System.out.println("시간 구형 실패");
			return false;
		}
        EmpDAO dao= new EmpDAO();
        boolean empAdded = dao.getInput(ev);
        
		
		return empAdded;
	}

	public boolean empEdit(EmpVO ev) {
		
		return  new EmpDAO().update(ev);
	}

	public boolean delete(int empno) {
		
		return new EmpDAO().delete(empno);
	}

	

	


}
