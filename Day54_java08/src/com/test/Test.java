//Test07(7.1)���� Address, Score java���� ��������. ������ ����

package com.test;
import java.util.*;

//import javax.swing.text.html.HTMLDocument.Iterator;
import com.exam.*;

public class Test {
	
	public static void Prn01() {
		//1.
		List<Score> li = new ArrayList<Score>(); // Array List�� Score(������Ʈ���)�� �����ϰڴ�.
		//List<Score> li = new ArrayList<>(); ������ Score ��ü�� �����ϰڴٰ� ������ ������ü�ȿ� Score�� ��� ������.
		
		li.add(new Score("ȫ�浿", 90, 70, 60));
		li.add(new Score("ȫ�浿1", 90, 70, 60));
		li.add(new Score("ȫ�浿2", 90, 70, 60));
		li.add(new Score("ȫ�浿3", 90, 70, 60)); //li ��ü�� list_print�� �߰��ϰڴ�. (add)�̿�
		
		list_print03(li); // ���� �������
		
		
		
		//2.
		List<Score> rm = list_print02(li); // list_print02() �޼ҵ带 ���ؼ� �� ���� �� ���Ϲ޴´�.
		list_print03(rm); // ����� ���� ��ü ��� �غ���.
		
	}
	
	
	public static List<Score> list_print02(List<Score> all){
		// ���������� ��� 100������ ��������.
		for(Score s : all) {
			s.setKor(100);
		}
		return all; // void�� ���� �׷��� return 
	}
	
	
//	public static void list_print (List<Score> listall) {
//		System.out.println("================================");
//		for(Score res : listall) {
//			System.out.println(res); // res.toString() �� ����
//		}
		
		
		
	public static void list_print03 (List<Score> listall) { // import javax.swing.text.html.HTMLDocument.Iterator; ���� import�ּ�ó�� �� ����
		// ���� list_print02�� ��� ����, ������ 02�� ���̻��
		
		System.out.println("================================");
		
		Iterator<Score> ir = listall.iterator(); //Interator -> next() hasNext()
				while(ir.hasNext()) {
			System.out.println(ir.next());
		
		}	
	}
	
	public static void main(String[] args) {
		Prn01();
	}}

