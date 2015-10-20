package org.kdea.mybatis;

import java.util.List;

public interface EmpDAO {

	public List<EmpVO> list();
    public EmpVO info(int empno);
	public int insert(EmpVO emp);
	public int update(EmpVO emp);
	public int delete(int empno);
}