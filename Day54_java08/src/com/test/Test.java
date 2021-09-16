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

