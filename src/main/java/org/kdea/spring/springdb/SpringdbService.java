package org.kdea.spring.springdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class SpringdbService {
 
    @Autowired
    private SpringdbDAO empDao;
 
    public List<Emp> getEmpList(){
        return empDao.getEmpList();
    }
     
    public Emp getEmp(int empno) {
        return empDao.getEmp(empno);
    }
     
    public boolean insertEmp(Emp emp) {
        return empDao.insertEmp(emp);
    }
     
    public boolean updateEmp(Emp emp) {
        return empDao.updateEmp(emp);
    }
     
    public boolean deleteEmp(int empno) {
        return empDao.deleteEmp(empno);
    }
}