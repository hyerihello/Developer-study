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
	
