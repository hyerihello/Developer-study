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


	
