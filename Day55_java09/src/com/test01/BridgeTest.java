package com.test01;

public class BridgeTest {
 
	public static void main(String[] args) {
		System.out.println(" 시뮬레이션을 시작해 보자. ");
		Bridge br = new Bridge();
		new Knight(br, "홍길동", "홍천").start();
		new Knight(br, "정길동", "일산").start();
		new Knight(br, "일지매", "부산").start();
		new Knight(br, "장보고", "장흥").start();
		new Knight(br, "이순신", "이천").start();
	}
}

/*  
  Thread Safe 되지 않았다. 
  "홍길동", " 홍천" 이 되어야 하는데 "홍길동", "일산"이 되면서 오류 판별이 난 경우를 찾아 볼 수 있다.
  "일지매", "일산" 등은 오류가 아닌데 오류 판정이 난 경우를 찾아 볼 수 있다.
  
  하나의 스레드가 check()메소드를 수행하는 동안 다른 스레드가 끼어들어서 across()를 실행하게 된다.
   across()를 실행하면서 name 또는 address 고칠 수 있는 상태가 되버리기 때문이다.
   
   만약에 while(true) 가 아닌 100번 또는 20000번 내의 작은 루프를 돌렸다면 발생하지 않을 문제이다.
    문제가 발생까지의 상황을 살펴보자.
     기사 홍길동 ,     기사 정길동 ,    name ,  address
    this.count++, this.count++; ,  (이전값),  (이전값) 
    			  ths.name = name; , "정길동", (이전값)
    this.name = name,  -            , "홍길동 ", (이전값)
    this.address = address, -        , "홍길동", "홍천"
    -      , this.address=address; "홍길동", "일산"
    check(),   check(),   "홍길동" , "일산"
    오류발생!
   
    			  
    [그림설명]
    2개의 스레드가 하나의 객체를 공유하고  있다.
    홍길동 스레드가 across() 메소드를 호출하면 다리 객체에 있는 모니터링 락을 홍길동 스레드가 차지하고 객체는 잠긴다.
    이때 정길동 스레드가 다리객체의 across()	메소드를 다시 호출하게 되면 객체가 잠겨있어서 호출을 실행하지 못하고 다리객체의 모니터락이 풀리기를 기다려야한다.  
    
    synchronized는 어디다가 사용해야할까? //필드값을 전달하거나 구문을 수행하는 곳에만 사용한다.
    2개 이상의 스레드가 공유 객체를 접근해서 기능을 구현하는 곳에 선언한다.
    
 */
 