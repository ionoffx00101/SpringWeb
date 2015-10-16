package org.kdea.spring.register;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class RegisterExtractor implements ResultSetExtractor<MemberVO> {

	public MemberVO extractData(ResultSet rs) throws SQLException, DataAccessException {

		MemberVO vo = new MemberVO();

		vo.setMemberno(rs.getInt("MEMBERNO"));
		vo.setEmail(rs.getString("EMAIL"));
		vo.setPw(rs.getString("PW"));
		vo.setId(rs.getString("MID"));
		vo.setName(rs.getString("MNAME"));

		return vo;
	}

}
