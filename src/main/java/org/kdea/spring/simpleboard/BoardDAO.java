package org.kdea.spring.simpleboard;

import java.util.List;

public interface BoardDAO {
	
	public List<BoardVO> list();
	public BoardVO info(int bnum);
	public int insert(BoardVO board);
	public int update(BoardVO board);
	public int delete(int bnum);
	public List<BoardVO> search(BoardVO board);
	public List<BoardVO> searcha(BoardVO board);
	public List<BoardVO> getPagelist(int pg);
	public int getTotalRows();
	public int getsearchTotalRows(String title);
	public int getsearchaTotalRows(String author);
}
