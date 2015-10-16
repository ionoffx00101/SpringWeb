package org.kdea.spring.register;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegisterDAO {
	
	@Autowired
    private DataSource dataSource; // 혹은 아래처럼
	
	public boolean addmemberdao(MemberVO vo) {  
        
        String sql = "INSERT INTO Member (memberno,email,mid,pw,mname) VALUES (MEMBER_SEQ.NEXTVAL,?,?,?,?)";  
           
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
           
        int rows = jdbcTemplate.update(  
            sql,  
            new Object[] {vo.getEmail(),vo.getId(),vo.getPw(),vo.getName()}
        );
        
        
        return rows>0 ? true : false;
    }

	public List<MemberVO> getallListdao() {
		List<MemberVO> list = new ArrayList<MemberVO>();  
        String sql = "select * from Member ORDER BY MEMBERNO";  
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
        list = jdbcTemplate.query(sql, new RegisterRowMapper());  
        return list;  
	}
}
