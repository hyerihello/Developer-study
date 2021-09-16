## **Class Collections**

\- java의 데이터 자료관리

Collection 인터페이스를 구현한 클래스에 대한 객체생성, 정렬(sort), 병합(merge), 검색(Serch)등 기능을 안정적으로 수행하도록 도와주는 util. class 이다.

  ※ java의 util package는 CRUD 방법과, list, value, key를 다루는 것만 정리하면 된다.

**Interface**

List : 자료의 데이터를 인덱스로 관리한다. 중복 데이터 허용가능, null 허용 (ArrayList, Vector)  
Set : 값으로 데이터를 관리한다. 중복데이터 허용 불가능 (HashSet, Tree Set)  
Map : 키와 값 (key, value)으로 데이터가 저장되고 키로 데이터를 관리한다. key는 중복 값 불가능 /Hashmap

 **collection 객체의 특징**

  
 원하는 객체를 CRUD 할 수 있다.  
 동적으로 데이터를 관리한다.  
 정해진 크기가 없다

## **jdbc**

javadb : java와 oracle연결하기

  
 - java.sql , javax.sql 두 개의 package를 참고 하자.

  
 **- jdbc 연동하기**

  
    탐색기 → C:\\oraclexe\\app\\oracle\\product\\11.2.0\\server\\jdbc\\lib → .jar파일 3개  
    → C:\\Program Files\\Java\\jdk1.8.0\_291\\jre\\lib\\ext에 복붙한다.  
    → 이클립스  jre system library 의 ojdbc 확인하면 oracle 파일이 올라오는 것을 볼 수 있다.

**\- db, 이클립스 연결하기** 

    화면오른쪽 아이콘 javaee 클릭 → data source explorer → database connection 오마클 → new → oracle  
    → 오른쪽 풍차모양 → 상단탭을 확인해보자  name/type → oracle thin driver 11 클릭 → 상단 탭 jarlist →    
    기존 jar지우기 → edit jar/zip → C:\\oraclexe\\app\\oracle\\product\\11.2.0\\server\\jdbc\\lib   
    → object6jar 클릭 → 상단 탭 properties 에서 계정 셋팅 → 셋팅은 맨 아래 이미지파일 참고해서 맞춤 →

     ok 후에 testconnection 누른 후 성공 나오면 finish

[##_Image|kage@llTML/btq9eNfeC0f/YKSl64jxiMDi16VTEogkwK/img.png|alignCenter|data-origin-width="777" data-origin-height="783" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@bQQQw0/btq9gX8xC9A/6WHxoknwlVk03HcfhsVkV0/img.png|alignCenter|data-origin-width="511" data-origin-height="621" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@qM0o1/btq9f41qrkl/6KADakA139C6WpafMrfsB0/img.png|alignCenter|data-origin-width="614" data-origin-height="575" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@8gmQQ/btq9hAec4vO/7SZSJySSuBkTYckEK1AYzk/img.png|alignCenter|data-origin-width="614" data-origin-height="575" data-ke-mobilestyle="widthOrigin"|||_##][##_Image|kage@WCaR4/btq9jGkHP83/3Xbgws2Sk6FsbC35woGtMK/img.png|alignCenter|data-origin-width="887" data-origin-height="758" data-ke-mobilestyle="widthOrigin"|||_##]

[##_Image|kage@UQmYr/btq9gQVExrh/fZMzzLnmJ3JH7ulratTCGk/img.png|alignCenter|data-origin-width="1173" data-origin-height="624" data-ke-mobilestyle="widthOrigin"|||_##]

즉 ,

 (1) 드라이버 설치 : 원하는 데이터 베이스 서버에서 제공하는 드라이버를 다운로드 받아서 (ojdbc6.jar)   
     자바 프로젝트가 참조할 수 있도록 설치한다.  
  (2) ojdbc6.jar 의 클래스를 참조해서 코드를 작성한다.  
  (3) 프로그램의 작성 순서는 클라이언트 접속 상태처럼 순서를 따른다.  
    
      →  데이터 베이스 서버에 접속   
        Connection getConnection (String url, String user, String password)  
      →  명령을 입력   
        statement createStatement()  
        boolean execute(String sql)/int \[\] executeBatch()/  
        ResultSet executeQuery(String sql) : SELECT /  
        int executeUpdate(String sql) : INSERT, UPDATE, DELETE/       
      →   결과를 리턴   
         ResultSet : next() = row단위 또는 컬럼명 또는 인덱스로 컬럼을 추출할 수 있다.  
      →   종료   
         close()

## **웹,어플리케이션 로직** 

  
                                     ↓ jdbc 템플릿은 여기에 연결됨(DAO 와 DB사이) , dao : Data Access Object   
M (model) →  3. 연산, DAO 후에 DB 또는 output  
V  (view) - 클라이언트만 접근(회원가입) → 1. controler  
C  (control) - 페이지 제어, 유효성 검증 → 2. 데이터 송신 여부 확인 후 model로 이동함  
  
 - VO(value object) : get,set   
 - Entity  : 연산의 값을 가지고 있음   
 

  
  **\* 프로젝트 만들때**  
  

  1. MVC를 나눠야한다.  
  2. Template을 짜야한다.  
 

```
// [Score table]

 name kor eng mat tot avg grade
  1   90  80  70  -   -   -
```

```
//[VO]
 
 Class Score_VO{ // 순하게 값을 받는
 	
 	String name;
 	int kor, eng, mat;
 	생성자 + getter & setter
 	
 }
```

```
 // [Score_Calc, 계산]
 
 Class Score_Calc{ // 비즈니스 로직
  	ScoreVO -> 총점, 평균, 학점
  	계산된 결과를 ScoreEntity의 setter전달
 }
```

```
// [Score Entity]

Class ScoreEntity{
 	String name;
 	int kor, ent, mat;
 	int tot;
 	double avg;
 	String grade;
 	getter & setter
 	}
    
 	public int getTot(){
 	tot = new Score_calc(), getTot();
 	return tot;
 	}
 
	public void setTot(int tot){
		this.tot = tot;
	}
```

```
package com.exam;

import java.io.Serializable;

public class Address implements Serializable{ //역 직렬화가 꼭 필요하다.

		
		private String addr;
		private String tel;
		
	
		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public Address() {
			
		}		
		public Address( String addr, String tel) {
			
			this.addr = addr;
			this.tel = tel;
		}
		
		@Override
		public String toString() {
			String str = String.format("%5s %5s \n", this.getAddr(),this.getTel());
			return str;
		}


	}
```

```
package com.exam;

// 3과목 총점 평균 학점
public class Score {

		private String name;
		private int kor; 
		private int eng;
		private int mat;
				
		public Score() {
			super();			
		}
		
		public Score(String name, int kor, int eng, int mat) {
			super();
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
		}
		
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getKor() {
			return kor;
		}
		public void setKor(int kor) {
			this.kor = kor;
		}
		public int getEng() {
			return eng;
		}
		public void setEng(int eng) {
			this.eng = eng;
		}
		public int getMat() {
			return mat;
		}
		public void setMat(int mat) {
			this.mat = mat;
		}
		
		public int getTot() {
			int tot = 0;
			tot = this.getKor() + this.getEng() + this.getMat();
			return tot;
		}
		
		
		public double getAvg() {
			double avg =0;
			avg = this.getTot()/3.0;
			return avg;
			
		}

		public String Getgrade() {
			String grade = null; //메서드안에 초기변수를 주면 지역변수?
			switch((int)getAvg()/10) { //98.0 --> 9.8 -> 9 / 100.0 -> 10.0 -> 10
			case 10:
			case 9 : grade = "A";
					 break;
			case 8 : grade = "B";
					 break;
			case 7 : grade = "C";
					 break;
			case 6 : grade = "D";
					 break;
		    default : 
		    		grade = "F";
			}
			return grade;
			}
		
		@Override
		public String toString() {
			String str = String.format("%10s %5d %5d %5d %5d %3.1f %3s\n", 
					this.getName(), this.getKor(), this.getEng(), this.getMat(), this.getTot(),this.getAvg(),this.Getgrade());
			return str;
		}

	}
```

Test01

```
//Test07(7.1)에서 Address, Score java파일 가져오자. 가져온 파일

package com.test;
import java.util.*;

//import javax.swing.text.html.HTMLDocument.Iterator;
import com.exam.*;

public class Test {
	
	public static void Prn01() {
		//1.
		List<Score> li = new ArrayList<Score>(); // Array List는 Score(엘리먼트요소)만 관리하겠다.
		//List<Score> li = new ArrayList<>(); 선조가 Score 객체만 관리하겠다고 했으니 생성객체안에 Score가 없어도 괜찮다.
		
		li.add(new Score("홍길동", 90, 70, 60));
		li.add(new Score("홍길동1", 90, 70, 60));
		li.add(new Score("홍길동2", 90, 70, 60));
		li.add(new Score("홍길동3", 90, 70, 60)); //li 객체를 list_print에 추가하겠다. (add)이용
		
		list_print03(li); // 값을 출력하자
		
		
		
		//2.
		List<Score> rm = list_print02(li); // list_print02() 메소드를 통해서 값 변경 후 리턴받는다.
		list_print03(rm); // 변경된 값을 전체 출력 해보자.
		
	}
	
	
	public static List<Score> list_print02(List<Score> all){
		// 국어점수를 모두 100점으로 변경하자.
		for(Score s : all) {
			s.setKor(100);
		}
		return all; // void가 없다 그래서 return 
	}
	
	
//	public static void list_print (List<Score> listall) {
//		System.out.println("================================");
//		for(Score res : listall) {
//			System.out.println(res); // res.toString() 과 같음
//		}
		
		
		
	public static void list_print03 (List<Score> listall) { // import javax.swing.text.html.HTMLDocument.Iterator; 위에 import주석처리 후 실행
		// 위에 list_print02와 결과 같음, 요즘은 02를 많이사용
		
		System.out.println("================================");
		
		Iterator<Score> ir = listall.iterator(); //Interator -> next() hasNext()
				while(ir.hasNext()) {
			System.out.println(ir.next());
		
		}	
	}
	
	public static void main(String[] args) {
		Prn01();
	}}

  ==========================================================================
  
  ================================
       홍길동    90    70    60   220 73.3   C

      홍길동1    90    70    60   220 73.3   C

      홍길동2    90    70    60   220 73.3   C

      홍길동3    90    70    60   220 73.3   C

================================
       홍길동   100    70    60   230 76.7   C

      홍길동1   100    70    60   230 76.7   C

      홍길동2   100    70    60   230 76.7   C

      홍길동3   100    70    60   230 76.7   C
```

Test02

```
package com.test;

import java.util.*;
import com.exam.*;

public class Test02 {
	public static void Prn() {
		
		Set<Score> si = new HashSet<>(); //set은 중복데이터를 허용하지 않는다.
		
		si.add(new Score("홍길동", 90, 70, 60));
		si.add(new Score("홍길동1", 90, 70, 60));
		si.add(new Score("홍길동2", 90, 70, 60));
		
		
		Score score = new Score("홍길동3", 90, 70, 60);
		
		si.add(score);
		si.add(score);
		si.add(score);
		
		for(Score sm : si) {
			System.out.println(sm);
		}
	}
	
	public static void Prn02() {
		Set<String> si02 = new HashSet<>();
		si02.add("abc");
		si02.add("abc");
		si02.add(new String("abcd"));
		si02.add(new String("abcd"));
		
		for(String sm : si02) {
			System.out.println(sm);
		}
	}
	public static void main(String[] args) {
		Prn02();
	}
}
```

```
package com.test;
import java.util.*;

import com.exam.Score;
import com.test.*;
//Map을 이용해보자.

public class Test03 {
	
	public static void Prn() {
		// T(type),E(element), K(key),V(value) 올수있다. <>안에
		Map<Integer, String> m1 = new HashMap<>(); // Interface Map < key, value>, key는 중복불가
		m1.put(1,"1");
		m1.put(2,"2");
		m1.put(3,"3");
		
		System.out.println(m1);
		System.out.println(m1.get(1)); // value '1' 리턴
	}
	
	public static void Prn02() {
		
		Map<Integer,Score> si = new HashMap<>(); //set은 중복데이터를 허용하지 않는다.
		
		si.put(1,new Score("홍길동", 90, 70, 60));
		si.put(2,new Score("홍길동1", 90, 70, 60));
		si.put(3,new Score("홍길동2", 90, 70, 60));
		
		System.out.println(((Object)si).getClass()); // class java.util.HashMap, class를 보고싶어
		System.out.println(si);
		System.out.println(si.values()); //values 값만 리턴
		Set<Map.Entry<Integer, Score>> res = si.entrySet(); // key,value를 관리하는것 Map.Entry<K,V> //key값만 보고싶어
		System.out.println(res);
		
		System.out.println("=====================");
		for(Map.Entry<Integer, Score> r: res) {
			System.out.println(r.getKey() +":"+r.getValue()); //entry set으로 리턴을 받아서 key value 각각 값을 리턴받는다.
		}
	}
	
	
	public static void main(String[] args) {
		//Prn(); // 딕셔너리 {1=1, 2=2, 3=3} 리턴
		Prn02();
	}
}
```

## **Multi-Chatting** 

**#1. COM.BIZ**

 biz : UI 에서 전달된 정보를(commend 객체 등) 파라미터로 받는다.   
 UI에서 전달된 정보를 기반으로 비즈니스로직을 처리하고, db에 대한 CRUD가 필요할 경우 DAO객체를 호출하여 처리한다.

```
package com.biz;
// biz : UI 에서 전달된 정보를(commend 객체 등) 파라미터로 받는다. 
// UI에서 전달된 정보를 기반으로 비즈니스로직을 처리하고, db에 대한 CRUD가 필요할 경우 DAO객체를 호출하여 처리한다.
import java.sql.Connection;
import java.util.List;
import com.Entity.EmpEntity;
import com.dao.EmpDao;

import static com.myjdbc.JDBCTemplate.*; //import static을 주면 .하면 class + 메서드가 올라온다. 

// controller 로 부터 유효성 검증이 끝나면 vo를 받아 연산할 거면 연산 클래스를 호출한 결과를 리턴하고
// 또는 바로 연산없이 데이터 베이스에 저장하려면 dao를 부른다. 
// JDBCTemplate를 이용해서 C&C만 호출한다. 

public class EmpBiz {

	public List<EmpEntity> getSelectAll(){
		// 계산용 코드를 호출해서 데이터 베이스 연결 ...
		// vo를 받아서 계산용 클래스로 한 다음 entity에 담아서 dao로 넘겨서 리턴받는다
		Connection con = getConnection();
		List<EmpEntity> res = new EmpDao(con).getselectAll();// biz에서 dao를 부름 , 생성자를 통해 넘겨준당 그럼 dao로가야지
		Close(con);
		return res;
	}
	public int getEmpInsert(EmpEntity entity) {
		Connection con = getConnection();
		int res = new EmpDao(con).getEmpInsert(entity);
		Close(con);
		return res;
		}
	
	public int getEmpUpdate(EmpEntity entity) {
		Connection con = getConnection();
		int res = new EmpDao(con).getEmpUpdate(entity);
		Close(con);
		return res;
		}
	
	public int getEmpDelete(EmpEntity entity) {
		Connection con = getConnection();
		int res = new EmpDao(con).getEmpDelete(entity);
		Close(con);
		return res;
		}
	
	}
```

**#2. COM.DAO,DAOIM**

dao : Data Access Object의 약자로 데이터베이스의 data에 접근하기 위한 객체

        database 접근을 하기위한 로직과 비즈니스 로직을 분리하기 위해 사용함

```
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Entity.EmpEntity;
import static com.myjdbc.JDBCTemplate.*;

//CRUD만 하겠다. = commit/rollback 
public class EmpDao implements EmpDaoIm{
	Connection con;
	public EmpDao(Connection con) {
		this.con = con;
	}




	//1. select
	public List<EmpEntity> getselectAll(){
		String all = "select * from emp";
		//레코드 한줄씩 EmpEntity 로 담아서 list객체에 추가한 다음 리턴
		List<EmpEntity> Listall = new ArrayList<>();
		EmpEntity entity = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			 stmt = con.createStatement();
			 rs = stmt.executeQuery(select_all);
			 while(rs.next()) {
				 entity = new EmpEntity(rs.getInt(1), 
						  rs.getString("ename"),
						  rs.getString(3),
						  rs.getInt(4),
						  rs.getString(5),
						  rs.getDouble(6),
						  rs.getDouble(7),
						  rs.getInt(8));
				 
				 Listall.add(entity);
			 }//while add
			 
		}catch(Exception e) {
				
		
	} finally {
		Close(rs);
		Close(stmt);
	}//try end
		return Listall; // return하면 jdbctemplate로간닫
	}

	//2. insert
	public int getEmpInsert(EmpEntity entity) {

		PreparedStatement pstm = null;
		int res =0;
		try {
			pstm = con.prepareStatement(insert_emp);
			pstm.setInt(1, entity.getEmpno());
			pstm.setString(2, entity.getEname());
			pstm.setString(3, entity.getJob());
			pstm.setInt(4, entity.getMgr());
			pstm.setString(5, entity.getHiredate());
			pstm.setDouble(6, entity.getSal());
			pstm.setDouble(7, entity.getComm());
			pstm.setInt(8, entity.getDeptno());
			
			res = pstm.executeUpdate(); // insert 실행
			if (res >0) {
				Commit(con);
			}
		}catch(Exception e) {
			//System.out.println(e.toString());
			Rollback(con);
		}finally {
			Close(pstm);
		}
		return res;
	}
	
	
	//3. update
	public int getEmpUpdate(EmpEntity entity) {

		PreparedStatement pstm = null;
		int res =0;
		try {
			pstm = con.prepareStatement(update_emp);
			pstm.setDouble(1, entity.getSal());
			pstm.setInt(2, entity.getEmpno());

			
			res = pstm.executeUpdate(); // insert 실행
			if (res >0) {
				Commit(con);
			}
		}catch(Exception e) {
			//System.out.println(e.toString());
			Rollback(con);
		}finally {
			Close(pstm);
		}
		return res;
	}
	
	
	
	//4. delete
	public int getEmpDelete(EmpEntity entity) {

		PreparedStatement pstm = null;
		int res =0;
		try {
			pstm = con.prepareStatement(delect_emp);
			
			pstm.setInt(1, entity.getEmpno());

			
			res = pstm.executeUpdate(); // insert 실행
			if (res >0) {
				Commit(con);
			}
		}catch(Exception e) {
			
			Rollback(con);
		}finally {
			Close(pstm);
		}
		return res;
	}
	}
```

**Daoim :** 추상메서드로 정의해 db 문을 작성한다.

```
package com.dao;

public interface EmpDaoIm {
	String select_all = "select * from emp";
	String insert_emp = "Insert into Emp values(?,?,?,?,?,?,?,?)";
	String delect_emp = "Delete from emp where empno =?";
	String update_emp = "Update emp set sal =? where empno =?";
```

**#3. COM.EmpEntity**

 : 실제 DB테이블과 매칭될 클래스, 링크될 클래스

  getter & setter

```
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
```

**#4. COM.jdbc**

  **:** DB연결

```
package com.myjdbc;

import com.Entity.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


 // 매번 db코드 열고닫기 힘드니까 하나 만들어 놓자.
 // 하나의 테이블당 하나씩 템플릿 (ex, 하나의 emp table당 하나의 템플릿)
 // Emp -> Entity / CRUD -> static
 //	Emp -> VO
 // 모든 db는 static -> 한번만 insert하게끔, 또한 static이어야만 동시제어가 된다. 각각의 소멸시점때문에 static으로 한다.
 // Emp -> db에서는 객체화 시켰을때 Entity 라고 부른다. (테이블이 객체화 되어있는걸 엔티티라고 부른다)
 // 또한 CRUD가 들어있어야야 한다. CRUD -> static


// 연결, 클로즈 = Connection 
// 롤백, 커밋만 하겠다.  = Statement


public class JDBCTemplate {
	
	public static Connection getConnection() {
		Connection con = null;
		
		//1. 연결	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","SCOTT","TIGER");
		if(!con.isClosed()) {
			System.out.println("연결했어 ");
		}
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void Close(Connection con) {
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void Close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void Close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
	
	
	public static void Rollback(Connection con) {
		if(con != null) {
			try {
				con.rollback();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	public static void Commit(Connection con) {
		if(con != null) {
			try {
				con.commit();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}	
	public static boolean isConnection(Connection con) {
		try {
			if(con != null && !con.isClosed()) { 
				// &비트연산, (a>b)&&(a<b++) 논리연산 -> 앞의 결과가 false 면 뒤에 연산 수행안하고 결과를 false로 리턴
				// (a>b)||(a<b++)  -> 앞의 결과가 true 면 뒤에 연산 수행안하고 결과를 true로 리턴
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
```

**#5. COM.VC , Controller** 

  : 유효성 검사 및 페이지 이동

```
package com.vc; // view + controller 만들기
import java.util.Scanner;
import com.biz.*;
import com.dao.*;
import com.Entity.*;
import java.sql.*;
import java.util.*;

// view + controller
// 1. view (값 입력과 출력 레이아웃) <-> controller(유효성검사 및 페이지 이동) 			    ↓ close & connection
// <-> biz(계산, 파일, 디비->디비로갈거같으면 dao로 넘김) <-> dao(CRUD담당) -> JDBCTemplate(C&C, commit, rollback) -> database_Server

// model로 갔는데 계산할게있으면 biz(모든 기능수행)로 갔다가 controller
// model에서 정보를처리해야되면 dao, jdbctemplete,

public class myController {
	
	Scanner sc = new Scanner(System.in);
		int menu_view(){
		int no = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("1.Select All \n");
		sb.append("2.Insert  \n");
		sb.append("3.Delete  \n");
		sb.append("4.Update  \n");
		sb.append("5.exit  \n");
		System.out.println(sb.toString());
		System.out.println("input no : ");
		
		
		no = sc.nextInt();
		return no;
	}
	public static void main(String[] args) {
		//Controller
		List<EmpEntity>all = new ArrayList<>();
		EmpBiz biz = new EmpBiz();
		EmpEntity entity = null;
		
			int no = 0;
			int res = 0;
			
			do {
			no = new myController().menu_view();
			switch(no) {
			case 1:		
				all = biz.getSelectAll();
				for(EmpEntity emp : all) {
					System.out.println(emp); // 1을 누르면 줄줄줄 나온당.............EmpEntity [empno=7369, ename=SMITH, job=CLERK, mgr=7902, hiredate=1980-12-17 00:00:00, sal=800.0, comm=0.0, deptno=20]
				}
						break;
			case 2:		
				entity = new EmpEntity(111, "111", "111", 111, "2021-07-20", 111, 111, 20);
				res = biz.getEmpInsert(entity);
				if (res >0) {
					System.out.println("입력했어 ");
				}
				
						break;
			case 3:		
				entity = new EmpEntity();
				entity.setEmpno(111);
				res = biz.getEmpDelete(entity);
				if (res > 0) {
					System.out.println("삭제 했어");
				}
						break;
						
						
			case 4:		
				entity = new EmpEntity();
				entity.setEmpno(111);
				entity.setSal(10000);
				res = biz.getEmpUpdate(entity);
				if (res > 0) {
					System.out.println("수정 했어");
				}
						break;
						
			case 5:		System.exit(0);
			
			}
		} while (no != 6);
	}
}
```

```
1.Select All 
2.Insert  
3.Delete  
4.Update  
5.exit  

input no : 
1

연결했어 
EmpEntity [empno=7369, ename=SMITH, job=CLERK, mgr=7902, hiredate=1980-12-17 00:00:00, sal=800.0, comm=0.0, deptno=20]
EmpEntity [empno=7499, ename=ALLEN, job=SALESMAN, mgr=7698, hiredate=1981-02-20 00:00:00, sal=1600.0, comm=300.0, deptno=30]
EmpEntity [empno=7521, ename=WARD, job=SALESMAN, mgr=7698, hiredate=1981-02-22 00:00:00, sal=1250.0, comm=500.0, deptno=30]
EmpEntity [empno=7566, ename=JONES, job=MANAGER, mgr=7839, hiredate=1981-04-02 00:00:00, sal=2975.0, comm=0.0, deptno=20]
EmpEntity [empno=7654, ename=MARTIN, job=SALESMAN, mgr=7698, hiredate=1981-09-28 00:00:00, sal=1250.0, comm=1400.0, deptno=30]
EmpEntity [empno=7698, ename=BLAKE, job=MANAGER, mgr=7839, hiredate=1981-05-01 00:00:00, sal=2850.0, comm=0.0, deptno=30]
EmpEntity [empno=7782, ename=CLARK, job=MANAGER, mgr=7839, hiredate=1981-06-09 00:00:00, sal=2450.0, comm=0.0, deptno=10]
EmpEntity [empno=7839, ename=KING, job=PRESIDENT, mgr=0, hiredate=1981-11-17 00:00:00, sal=5000.0, comm=0.0, deptno=10]
EmpEntity [empno=7844, ename=TURNER, job=SALESMAN, mgr=7698, hiredate=1981-09-08 00:00:00, sal=1500.0, comm=0.0, deptno=30]
EmpEntity [empno=7900, ename=JAMES, job=CLERK, mgr=7698, hiredate=1981-12-03 00:00:00, sal=950.0, comm=0.0, deptno=30]
EmpEntity [empno=7902, ename=FORD, job=ANALYST, mgr=7566, hiredate=1981-12-03 00:00:00, sal=3000.0, comm=0.0, deptno=20]
EmpEntity [empno=7934, ename=MILLER, job=CLERK, mgr=7782, hiredate=1982-01-23 00:00:00, sal=1300.0, comm=0.0, deptno=10]
EmpEntity [empno=111, ename=111, job=111, mgr=111, hiredate=2021-07-20 00:00:00, sal=111.0, comm=111.0, deptno=20]
1.Select All 
2.Insert  
3.Delete  
4.Update  
5.exit  

input no : 
2
연결했어 
1.Select All 
2.Insert  
3.Delete  
4.Update  
5.exit  

input no : 
1
연결했어 
EmpEntity [empno=7369, ename=SMITH, job=CLERK, mgr=7902, hiredate=1980-12-17 00:00:00, sal=800.0, comm=0.0, deptno=20]
EmpEntity [empno=7499, ename=ALLEN, job=SALESMAN, mgr=7698, hiredate=1981-02-20 00:00:00, sal=1600.0, comm=300.0, deptno=30]
EmpEntity [empno=7521, ename=WARD, job=SALESMAN, mgr=7698, hiredate=1981-02-22 00:00:00, sal=1250.0, comm=500.0, deptno=30]
EmpEntity [empno=7566, ename=JONES, job=MANAGER, mgr=7839, hiredate=1981-04-02 00:00:00, sal=2975.0, comm=0.0, deptno=20]
EmpEntity [empno=7654, ename=MARTIN, job=SALESMAN, mgr=7698, hiredate=1981-09-28 00:00:00, sal=1250.0, comm=1400.0, deptno=30]
EmpEntity [empno=7698, ename=BLAKE, job=MANAGER, mgr=7839, hiredate=1981-05-01 00:00:00, sal=2850.0, comm=0.0, deptno=30]
EmpEntity [empno=7782, ename=CLARK, job=MANAGER, mgr=7839, hiredate=1981-06-09 00:00:00, sal=2450.0, comm=0.0, deptno=10]
EmpEntity [empno=7839, ename=KING, job=PRESIDENT, mgr=0, hiredate=1981-11-17 00:00:00, sal=5000.0, comm=0.0, deptno=10]
EmpEntity [empno=7844, ename=TURNER, job=SALESMAN, mgr=7698, hiredate=1981-09-08 00:00:00, sal=1500.0, comm=0.0, deptno=30]
EmpEntity [empno=7900, ename=JAMES, job=CLERK, mgr=7698, hiredate=1981-12-03 00:00:00, sal=950.0, comm=0.0, deptno=30]
EmpEntity [empno=7902, ename=FORD, job=ANALYST, mgr=7566, hiredate=1981-12-03 00:00:00, sal=3000.0, comm=0.0, deptno=20]
EmpEntity [empno=7934, ename=MILLER, job=CLERK, mgr=7782, hiredate=1982-01-23 00:00:00, sal=1300.0, comm=0.0, deptno=10]
EmpEntity [empno=111, ename=111, job=111, mgr=111, hiredate=2021-07-20 00:00:00, sal=111.0, comm=111.0, deptno=20]
1.Select All 
2.Insert  
3.Delete  
4.Update  
5.exit  

input no : 
3
연결했어 
삭제 했어
1.Select All 
2.Insert  
3.Delete  
4.Update  
5.exit  

input no : 
1
연결했어 
EmpEntity [empno=7369, ename=SMITH, job=CLERK, mgr=7902, hiredate=1980-12-17 00:00:00, sal=800.0, comm=0.0, deptno=20]
EmpEntity [empno=7499, ename=ALLEN, job=SALESMAN, mgr=7698, hiredate=1981-02-20 00:00:00, sal=1600.0, comm=300.0, deptno=30]
EmpEntity [empno=7521, ename=WARD, job=SALESMAN, mgr=7698, hiredate=1981-02-22 00:00:00, sal=1250.0, comm=500.0, deptno=30]
EmpEntity [empno=7566, ename=JONES, job=MANAGER, mgr=7839, hiredate=1981-04-02 00:00:00, sal=2975.0, comm=0.0, deptno=20]
EmpEntity [empno=7654, ename=MARTIN, job=SALESMAN, mgr=7698, hiredate=1981-09-28 00:00:00, sal=1250.0, comm=1400.0, deptno=30]
EmpEntity [empno=7698, ename=BLAKE, job=MANAGER, mgr=7839, hiredate=1981-05-01 00:00:00, sal=2850.0, comm=0.0, deptno=30]
EmpEntity [empno=7782, ename=CLARK, job=MANAGER, mgr=7839, hiredate=1981-06-09 00:00:00, sal=2450.0, comm=0.0, deptno=10]
EmpEntity [empno=7839, ename=KING, job=PRESIDENT, mgr=0, hiredate=1981-11-17 00:00:00, sal=5000.0, comm=0.0, deptno=10]
EmpEntity [empno=7844, ename=TURNER, job=SALESMAN, mgr=7698, hiredate=1981-09-08 00:00:00, sal=1500.0, comm=0.0, deptno=30]
EmpEntity [empno=7900, ename=JAMES, job=CLERK, mgr=7698, hiredate=1981-12-03 00:00:00, sal=950.0, comm=0.0, deptno=30]
EmpEntity [empno=7902, ename=FORD, job=ANALYST, mgr=7566, hiredate=1981-12-03 00:00:00, sal=3000.0, comm=0.0, deptno=20]
EmpEntity [empno=7934, ename=MILLER, job=CLERK, mgr=7782, hiredate=1982-01-23 00:00:00, sal=1300.0, comm=0.0, deptno=10]
1.Select All 
2.Insert  
3.Delete  
4.Update  
5.exit  

input no : 
4
연결했어 
1.Select All 
2.Insert  
3.Delete  
4.Update  
5.exit  

input no : 
1
연결했어 
EmpEntity [empno=7369, ename=SMITH, job=CLERK, mgr=7902, hiredate=1980-12-17 00:00:00, sal=800.0, comm=0.0, deptno=20]
EmpEntity [empno=7499, ename=ALLEN, job=SALESMAN, mgr=7698, hiredate=1981-02-20 00:00:00, sal=1600.0, comm=300.0, deptno=30]
EmpEntity [empno=7521, ename=WARD, job=SALESMAN, mgr=7698, hiredate=1981-02-22 00:00:00, sal=1250.0, comm=500.0, deptno=30]
EmpEntity [empno=7566, ename=JONES, job=MANAGER, mgr=7839, hiredate=1981-04-02 00:00:00, sal=2975.0, comm=0.0, deptno=20]
EmpEntity [empno=7654, ename=MARTIN, job=SALESMAN, mgr=7698, hiredate=1981-09-28 00:00:00, sal=1250.0, comm=1400.0, deptno=30]
EmpEntity [empno=7698, ename=BLAKE, job=MANAGER, mgr=7839, hiredate=1981-05-01 00:00:00, sal=2850.0, comm=0.0, deptno=30]
EmpEntity [empno=7782, ename=CLARK, job=MANAGER, mgr=7839, hiredate=1981-06-09 00:00:00, sal=2450.0, comm=0.0, deptno=10]
EmpEntity [empno=7839, ename=KING, job=PRESIDENT, mgr=0, hiredate=1981-11-17 00:00:00, sal=5000.0, comm=0.0, deptno=10]
EmpEntity [empno=7844, ename=TURNER, job=SALESMAN, mgr=7698, hiredate=1981-09-08 00:00:00, sal=1500.0, comm=0.0, deptno=30]
EmpEntity [empno=7900, ename=JAMES, job=CLERK, mgr=7698, hiredate=1981-12-03 00:00:00, sal=950.0, comm=0.0, deptno=30]
EmpEntity [empno=7902, ename=FORD, job=ANALYST, mgr=7566, hiredate=1981-12-03 00:00:00, sal=3000.0, comm=0.0, deptno=20]
EmpEntity [empno=7934, ename=MILLER, job=CLERK, mgr=7782, hiredate=1982-01-23 00:00:00, sal=1300.0, comm=0.0, deptno=10]
1.Select All 
2.Insert  
3.Delete  
4.Update  
5.exit  

input no : 
5
```
