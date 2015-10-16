package org.kdea.spring.springdb;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
 
@Service
public class SpringdbDAO {
 
    @Autowired
    private DataSource dataSource; // 혹은 아래처럼
 
    //@Resource(name="dataSource")
    //private DataSource dataSource;
 
    public List<Emp> getEmpList() {  
        List<Emp> list = new ArrayList<Emp>();  
        String sql = "select * from emp2";  
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
        list = jdbcTemplate.query(sql, new EmpRowMapper());  
        return list;  
    }
     
    public boolean insertEmp(Emp emp) {  
           
        String sql = "INSERT INTO emp2 "+
            "(empno,ename,deptno,sal,job ) VALUES (?,?,?,?,?)";  
           
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
           
        int rows = jdbcTemplate.update(  
            sql,  
            new Object[] { emp.getEmpno(),emp.getEname(),emp.getDeptno(),
                emp.getSal(),emp.getJob()}
        );
         
        return rows>0 ? true : false;
    }
     
    public boolean deleteEmp(int empno) {  
        String sql = "delete from emp2 where empno=?";  
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
        int rows = jdbcTemplate.update(sql,empno);
        return rows>0 ? true : false;
    }
 
    public boolean updateEmp(Emp emp) {  
           
        String sql = "UPDATE emp2 set deptno=?, sal=? where empno=?";  
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
           
        int rows = jdbcTemplate.update(  
            sql,emp.getDeptno(), emp.getSal(), emp.getEmpno());  
        return rows>0 ? true : false; 
    }
     
    public Emp getEmp(int empno) {  
        String sql = "select * from emp2 where empno=?";  
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
        Emp emp = jdbcTemplate.queryForObject(sql, new Object[]{empno}, new EmpRowMapper());  
        return emp;  
    }  
 
}