package org.kdea.upload;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadService{
	
	 @Autowired
	 private UploadDAO dao;
	 
	public boolean insertFileinfo(UploadVO vo) {
		// TODO Auto-generated method stub
		return dao.insertFileinfoDAO(vo);
	}
	
	public UploadVO getrealfname(String changename){
		
		return dao.getrealfilename(changename);
	}
	 
}
