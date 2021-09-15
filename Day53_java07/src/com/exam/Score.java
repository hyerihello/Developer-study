package com.exam;

// 3������ ����, ���, ������ ������.
// main ���� ���� �ٰž�

public class Score {

		private int kor; 
		private int eng;
		private int mat;
				
		public Score() {
			super();			
		}
		
		public Score(int kor, int eng, int mat) {
			super();
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
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
		//switch case : if���� ��������� �� �� ����ȭ�� ���
		
		public String Getgrade() {
			String grade = null; //�޼���ȿ� �ʱ⺯���� �ָ� ��������?
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
			String str = String.format("%5d %5d %5d %5d %3.1f %3s\n", 
					this.getKor(), this.getEng(), this.getMat(), this.getTot(),this.getAvg(),this.Getgrade());
			return str;
		}
		// �������� -> �� ���� -> ���� -> ���
		// ����������� -> �����ڼ��� -> getter&setter -> ����޼ҵ� -> ��¸޼ҵ�
		
	public static void main(String[] args) {
//		Score s1 = new Score (90,80,60);
//		Score s2 = new Score (100,80,60);
//		Score s3 = new Score (90,80,50);
		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
//		
//		//s1�� ���������� 100 ��ȯ �� �������.
//		s1.setKor(100); // �� ���� �� ����
//		System.out.println(s1);
//		
//		//s3�� ���������� 0���� ��ȯ �� �������.
//		s3.setKor(0);
//		System.out.println(s3);
//		System.out.println(s3.getKor());


		
//		// Object Array 1
//		Score[] sm = new Score[3];
//		sm[0] = new Score (90,80,60);
//		sm[1] = new Score (100,80,60);
//		sm[2] = new Score (90,80,50);
		
		
		// Object Array 2
		Score[] sm = new Score[] {
									new Score (90,80,60),
									new Score (100,80,60),
									new Score (90,80,50)};
	
		my_print(sm);
		}
	
	
//		for(Score res : sm) {
//			System.out.println(res);
//		}
//		sm[1].setKor(0);
//		System.out.println(sm); // �ּҹ�������
//		System.out.println(sm[1]);
	
	
	public static void my_print(Score[] sm) {
		for(Score res:sm) {
			System.out.println(res);
		}
	}}



	
