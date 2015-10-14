package org.kdea.spring.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.kdea.spring.controller.EmpVO;

public class EmpDAO extends AbstractDAO {

	public boolean log(int num, String name) {
		conn = getConn();
		String sql = "SELECT * FROM emp2 where ename=? and empno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return false;
	}

	public List<EmpVO> getEmpList() {
		conn = getConn();
		String sql = "SELECT * FROM emp2";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<EmpVO> list = new ArrayList<>();
			while (rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmpno(rs.getInt("EMPNO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setHiredate(rs.getDate("HIREDATE"));
				emp.setSal(rs.getInt("SAL"));
				emp.setDeptno(rs.getInt("DEPTNO"));
				list.add(emp);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return null;
	}

	public EmpVO getEmp(int empno) {
		conn = getConn();
		String sql = "select * from emp2 where empno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			EmpVO emp = new EmpVO();
			while (rs.next()) {
				emp.setEmpno(rs.getInt("EMPNO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setHiredate(rs.getDate("HIREDATE"));
				emp.setSal(rs.getInt("SAL"));
				emp.setDeptno(rs.getInt("DEPTNO"));
			}
			return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return null;
	}

	public boolean getInput(EmpVO ev) {
		System.out.println("DAO구동확인");
		System.out.println(ev.getEmpno());

		conn = getConn();
		String sql = "insert into emp2(empno,ename,deptno,sal,hiredate,job,mgr) values(?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ev.getEmpno());
			pstmt.setString(2, ev.getEname());
			pstmt.setInt(3, ev.getDeptno());
			pstmt.setInt(4, ev.getSal());
			pstmt.setDate(5, ev.getHiredate());
			pstmt.setString(6, "PARTTIME");
			pstmt.setInt(7, 7839);
			pstmt.executeUpdate();

			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			closeAll();

		}
		return false;
	}

	public boolean delete(int empno) {
		conn = getConn();

		String sql = "delete from emp2 where empno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.executeUpdate();

			// FreeboardVO FreeData=new FreeboardVO();
			// FreeData.setHitcnt(rs.getInt("f_hitcnt"));
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			closeAll();

		}
		return false;
	}

	public boolean update(EmpVO ev) {
		conn = getConn();
		String sql = "update emp2 set deptno=?, sal=? where empno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ev.getDeptno());
			pstmt.setInt(2, ev.getSal());
			pstmt.setInt(3, ev.getEmpno());
			pstmt.executeUpdate();

			// FreeboardVO FreeData=new FreeboardVO();
			// FreeData.setHitcnt(rs.getInt("f_hitcnt"));
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			closeAll();

		}
		return false;

	}

}
