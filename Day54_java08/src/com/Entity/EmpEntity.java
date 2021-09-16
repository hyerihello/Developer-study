package com.Entity;
// 데이터 베이스 테이블의 속성을 가진 클래스
public class EmpEntity {

	
private int empno;
private String ename;
private String job;
private int mgr;
private String hiredate;
private double sal;
private double comm;
private int deptno;




public EmpEntity() {
	super();
	
}




public EmpEntity(int empno, String ename, String job, int mgr, String hiredate, double sal, double comm, int deptno) {
	super();
	this.empno = empno;
	this.ename = ename;
	this.job = job;
	this.mgr = mgr;
	this.hiredate = hiredate;
	this.sal = sal;
	this.comm = comm;
	this.deptno = deptno;
}




public int getEmpno() {
	return empno;
}

public void setEmpno(int empno) {
	this.empno = empno;
}

public String getEname() {
	return ename;
}

public void setEname(String ename) {
	this.ename = ename;
}

public String getJob() {
	return job;
}

public void setJob(String job) {
	this.job = job;
}

public int getMgr() {
	return mgr;
}

public void setMgr(int mgr) {
	this.mgr = mgr;
}

public String getHiredate() {
	return hiredate;
}


public void setHiredate(String hiredate) {
	this.hiredate = hiredate;
}


public double getSal() {
	return sal;
}


public void setSal(double sal) {
	this.sal = sal;
}



public double getComm() {
	return comm;
}


public void setComm(double comm) {
	this.comm = comm;
}


public int getDeptno() {
	return deptno;
}


public void setDeptno(int deptno) {
	this.deptno = deptno;
}


@Override
public String toString() {
	return String.format("EmpEntity [empno=%s, ename=%s, job=%s, mgr=%s, hiredate=%s, sal=%s, comm=%s, deptno=%s]",
			empno, ename, job, mgr, hiredate, sal, comm, deptno);
}





}
