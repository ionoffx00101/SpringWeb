package org.kdea.spring.simpleboard;

import java.util.List;

public interface BoardDAO {
	
	public List<BoardVO> list();
	public BoardVO info(int bnum);
	public int insert(BoardVO board);
	public int update(BoardVO board);
	public int delete(int bnum);
	public List<BoardVO> search(String title);
	public List<BoardVO> searcha(String author);
	public List<BoardVO> getPagelist(int pg);
	public int getTotalRows();
}
