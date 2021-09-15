package com.exam;

// 3과목의 총점, 평균, 학점을 구하자.
// main 에서 값을 줄거야

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
		//switch case : if문과 비슷하지만 좀 더 정형화된 제어문
		
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
			String str = String.format("%5d %5d %5d %5d %3.1f %3s\n", 
					this.getKor(), this.getEng(), this.getMat(), this.getTot(),this.getAvg(),this.Getgrade());
			return str;
		}
		// 변수선언 -> 값 대입 -> 연산 -> 출력
		// 멤버변수선언 -> 생성자선언 -> getter&setter -> 연산메소드 -> 출력메소드
		
	public static void main(String[] args) {
//		Score s1 = new Score (90,80,60);
//		Score s2 = new Score (100,80,60);
//		Score s3 = new Score (90,80,50);
		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
//		
//		//s1의 국어점수를 100 변환 후 출력하자.
//		s1.setKor(100); // 값 전달 및 변경
//		System.out.println(s1);
//		
//		//s3의 국어점수를 0으로 변환 후 출력하자.
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
//		System.out.println(sm); // 주소번지리턴
//		System.out.println(sm[1]);
	
	
	public static void my_print(Score[] sm) {
		for(Score res:sm) {
			System.out.println(res);
		}
	}}



	
