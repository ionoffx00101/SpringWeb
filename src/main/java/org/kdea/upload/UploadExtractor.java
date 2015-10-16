package org.kdea.upload;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.ResultSetExtractor;  
   
public class UploadExtractor implements ResultSetExtractor<UploadVO> {  
   
 public UploadVO extractData(ResultSet rs) throws SQLException,  
   DataAccessException {  
     
  UploadVO vo = new UploadVO();  
     
  vo.setFnum(rs.getInt("FNUM"));
  vo.setOrginfname(rs.getString("ORGINFNAME"));
  vo.setChangefname(rs.getString("CHANGEFNAME"));
  vo.setFdesc(rs.getString("FDESC"));
  vo.setFdate(rs.getDate("FDATE"));
  
  return vo;  
 }  
   
}
