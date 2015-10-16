package org.kdea.upload;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadService{
	
	 @Autowired
	 private UploadDAO dao;
	 
/*	 public boolean overlapfname(String orginfname){
		 
		 System.out.println("서비스파일이름1"+orginfname);
		 UploadVO vo =dao.overlapfnameDAO(orginfname);
		 System.out.println("서비스파일이름2"+orginfname);
		 
		 if(vo.getOrginfname()!=null){
			 // 기존에 그 이름이 있으면 
			 return true;
		 }
		 //return에 다오를 바로 넣어주자
		return false;
	 }
	 //파일 이름 검색해서 중복되는게 있는지 확인 해야함
*/
	public boolean insertFileinfo(UploadVO vo) {
		// TODO Auto-generated method stub
		return dao.insertFileinfoDAO(vo);
	}
	
	public UploadVO getrealfname(String changename){
		
		return dao.getrealfilename(changename);
	}
	 
	 //원래 파일이름 새 파일이름 주석 넣어서 추가
	 
	 //다운로드할때는 새파일 이름으로 검색해서 원래 파일 이름을 가져와 그걸로 뿌려주면서 파일 내용은 새파일 ^^ 힘내
	 //새파일이름이 없을수도 있어 그 번호를 가져가서 원래 파일이름ㄷ과 바뀐이름 둘다 가져와야할거야
	 
}
