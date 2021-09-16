## **Class Thread**
​
 **Process** : Runtime시에 실행 되는 exe단위의 프로그램을 말한다.  
 **Thread** : Process 안에서 메소드 단위로 실행되는 것을 말한다.  
    - 동시에 같은 작업을 수행 할 수 있게 구성된 가벼운 프로세스이다. → 분산/병렬시스템  
      (web은 session , application 은 thread라는 용어를 쓴다)
​
  \* 하나의 Process는 여러개의 Thread를 동시에 실행 할 수 있다.
​
    - 스레드를 사용할 때 가장 중요한 점은 복수 개의 스레드가 하나의 공유자원 객체를 사용해서   
      데이터를 조작할 때 데이터를 안전하게 구성 해야 한다는 점이다.  
    - synchronized를 이용하여 데이터를 안전하게 구현한다. (메소드 전체 또는 블록으로 적용)  
    - 교착상태 : 동일한 자원을 공유하고 있는 2개의 컴퓨터 프로그램이 상대방이 자원에 접근하는 것을 
​
                    사실상 서로 방해함으로써 두 프로그램의 기능이 모두 중지되는 결과를 낳은 상황을 말한다.  
                    교착상태를 피하는 방법은 예방, 회피, 탐지, 회복을 통해서 가능하다.
​
      ex) 클래스의 기능을 추가 → 스레드 → 멀티쓰레드 → 공유자원 → synchronized(lock)  
          → 교착상태 → Object 
​
**\# Prosess**
​
```
package com.test;
​
import java.io.IOException;
// Class Runtime의 exec(String command) 메소드 확인
​
// cmd 창처럼 활용해 메모장을 실행시켜보자.
// cmd 창에 notepad쓰면 메모장실행됨 , 동일한 경우임
​
​
public class Test1 {
    
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        Process pre;
        try {
            pre = r.exec("notepad.exe");
            System.out.println(pre.toString());
            System.out.println(pre.isAlive());
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}
=======================================================
java.lang.ProcessImpl@33909752
true
```
​
[##_Image|kage@YrUaM/btq9gRnew06/Ea435Djae1PHOMRa21iFnk/img.png|alignCenter|data-origin-width="660" data-origin-height="503" data-ke-mobilestyle="widthOrigin"|||_##]
​
**✔ Thread 만드는 방법**
​
   1. Interface Runnable을 implements 하는 방법   
      : \_run() 코드를 작성 한 다음 Thread 객체로 만들어 start() 메소드로 실행  
​
```
package com.test;
​
​
public class Test01 implements Runnable{
​
    @Override
    
    public void run() {
        for (int i = 0; i <=10; i++) {
            System.out.println(Thread.currentThread().getName()+ ":" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }
    
    }
    public static void main(String[] args) {
        new Test01().run(); // 아직 Thread가 아님
        
        //Tread(Runnable target)
        Thread t1 = new Thread(new Test01(),"야옹이");     //Test01클래스가 메소드 단위로 exe되는 Thread로 생성
        t1.setPriority(Thread.MAX_PRIORITY); // 10
        t1.start(); //run()호출
        
        Thread t2 = new Thread(new Test01(),"멍멍이");
        //t2.start(); // main Thread가 t1, t2 thread를 실행 했다. 라고 본다
                    
        t1.setPriority(Thread.MIN_PRIORITY); // 1
        t2.start(); // run() 호출
        
        
        System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>>>>>"); // 총 3개의 스레들가 돌고있구나, main, t1, t2
        System.out.println("스레드의 우선 순위를 확인 하자. ");
        
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        
        System.out.println("thread의 상태  :" + t1.getState());
        
        
    }
}
​
 // Thread의 실행 상태 [alive / dead] 
 // alive 상태는 스레드가 cpu를 차지하고 코드를 수행하는 단계를 말한다.
 // Runnable pool : 실행 상태로 들어가기 위해서 스레드들이 모여 있는 곳
 
 ================================================================================
main:0
main:1
main:2
main:3
main:4
main:5
main:6
main:7
main:8
main:9
main:10
main>>>>>>>>>>>>>>>>
스레드의 우선 순위를 확인 하자. 
야옹이:0
1
5
멍멍이:0
thread의 상태  :TIMED_WAITING
멍멍이:1
야옹이:1
멍멍이:2
야옹이:2
멍멍이:3
야옹이:3
멍멍이:4
야옹이:4
멍멍이:5
야옹이:5
멍멍이:6
야옹이:6
멍멍이:7
야옹이:7
멍멍이:8
야옹이:8
멍멍이:9
야옹이:9
멍멍이:10
야옹이:10
```
​
```
package com.test;
​
// main thread가 실행되는 것을 알 수 있다.
// Process는 액티브 프로그램이라고 할 수 있다. 
// 하나의 프로세스는 자신만의 전용 공간과 자원을 할당받은 상태에서 독점적으로 일을 처리하는 구조를 가진다.
// Thread는 프로세스 내부에 존재하며 공간과 자원을 공유하면서 일을 처리한다.
// ex) Process는 자신의 집에 서재를 꾸미고 위인전집을 사놓은 구조이고 공공 도서관은 Thread라고 생각하면된다.
​
public class Test02 {
​
    public static void main(String[] args) {
        System.out.println(" 싱글 Thread 야");
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName()+ ":" + i);
        }
    }
}
​
============================================================================
​
 싱글 Thread 야
main:0
main:1
main:2
main:3
main:4
main:5
main:6
main:7
main:8
main:9
main:10
main:11
main:12
main:13
main:14
main:15
main:16
main:17
main:18
main:19
main:20
main:21
main:22
main:23
main:24
main:25
main:26
main:27
main:28
main:29
main:30
​
,,,
​
main:81
main:82
main:83
main:84
main:85
main:86
main:87
main:88
main:89
main:90
main:91
main:92
main:93
main:94
main:95
main:96
main:97
main:98
main:99
main:100
```
​
   2. Thread class를 상속받는 방법   
      : \_run() 메소드에 코드를 작성 후 (본인이 Thread, 코드만 작성하면됨) start()메소드로실행
​
```
package com.test;
​
// 2. Thread를 상속받아 start()로 실행
​
public class Test03 extends Thread{
​
    
    public Test03(String name) {
        super(name);
    }
​
    @Override
    
    public void run() {
        for (int i = 0; i <=10; i++) {
            System.out.println(Thread.currentThread().getName()+ ":" + i);
        }
    
    }
    
    public static void main(String[] args) {
        Test03 t1 = new Test03("야옹이"); //Thread(String name)
        Test03 t2 = new Test03("멍멍이");
//      try { // join도 해보자.
//          t1.join();
//      } catch (InterruptedException e) {
//          
//          e.printStackTrace();
//      }
        t1.start();
        t2.start();
        
    }
​
​
}
===============================================================
​
야옹이:0
야옹이:1
멍멍이:0
멍멍이:1
멍멍이:2
멍멍이:3
멍멍이:4
멍멍이:5
멍멍이:6
멍멍이:7
멍멍이:8
야옹이:2
야옹이:3
야옹이:4
야옹이:5
야옹이:6
야옹이:7
야옹이:8
야옹이:9
야옹이:10
멍멍이:9
멍멍이:10
```
​
**✔ 스레드 생명 주기와 관련된 메소드**
​
  **1. sleep(long millis) 메소드** 
​
     **:** 현재 실행 상태인 스레드를 sleep pool로 쫒아낸다.  
       시간이 지나면 Runnable pool로 들어간다.  
       다른 스레드에게 실행 기회를 양보하기 위한 목적을 가진다.  
      
    
  **2.  join()** 
​
       : 다른 스레드와 협동 작업을 요구할 때 사용하는 메소드이다.  
         "합류하기를 기다린다" 라고 해석한다.  
         현재 실행 중인 스레드는 join pool로 들어가서 대기 상태가 된다.  
         join() 메소드를 전달받은 스레드가 수행을 시작해서  모든 수행이 끝나고 종료 상태가 되면
​
         그 때 join pool에 있는 스레드가 Runnable pool로 들어간다.  
  
  **3. synchronized 메소드 호출**
​
       : 여러 개의 스레드가 공유 자원 객체에 접근할 때 필드를 모호하기 위해 선언된다. = 객체 잠금  
         synchronized { }
​
  **4. wait()** 
​
      : thread 대기, notify() : 실행상태로 가라,  notifyAll() : 전부 다 실행상태로 가라  → object class 참고  
​
 ex) 패턴을 적용하지 않은 상태  
      다섯명의 기사가 구름다리를 건너자.  
      다리 건너면서 방명록에 자기 이름을 적는 출입지를 만들자.
​
```
package com.test01;
​
public class Bridge {
 
    // int의 범위 -2147483648 ~ 2147483648 의 범위 숫자중 2147483648 이 되면 오버플로우가 되면서 -2147483648 이된다.
    private int count;
    private String name;
    private String address;
    
    
    public synchronized void across(String name, String address) {
        //객체 필드를 사용 즉 값 전달 및 변경 - synchronized 사용
        this.count++;
        this.name = name;
        this.address = address;
        check();
        
    }
​
    @Override
    public synchronized String toString() {
        // 객체 필드 값 호출 - synchronized 사용
        return String.format("Bridge[도전회수 = %s, 이름=%s, 출신지=%s]", count, name, address);
    }
    
    public void check() {
        if(name.charAt(0) != address.charAt(0)) {
            System.out.println("문제발생" + toString());
        }
    }
}
```
​
```
package com.test01;
​
// 멤버변수로 기사가 통과하는 다리를 나타내는 bridge와 자신의 이름을 가지고 있는 name변수
// 한번 지정하면 수정 못하게 final로 선언하자.
// run() 시작하는 문자열을 출력하고 루프를 통해서 다리를 건너게 하자.
​
public class Knight extends Thread{
    private final Bridge bridge; // Bridge를 bridge로 선언하고
    private final String name;
    private final String address;
    
    public Knight (Bridge bridge, String name, String address) {
        this.bridge = bridge;
        this.name = name;
        this.address = address;
    }
​
    @Override
    public void run() {
        
        System.out.println(name + " 기사가 도전한다. ");
        while(true) {
            bridge.across(name,address);
        }
    }
    
    
}
```
​
```
package com.test01;
​
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
​
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
    이때 정길동 스레드가 다리객체의 across()  메소드를 다시 호출하게 되면 객체가 잠겨있어서 호출을 실행하지 못하고 다리객체의 모니터락이 풀리기를 기다려야한다.  
    
    synchronized는 어디다가 사용해야할까? //필드값을 전달하거나 구문을 수행하는 곳에만 사용한다.
    2개 이상의 스레드가 공유 객체를 접근해서 기능을 구현하는 곳에 선언한다.
    
 */
```
​
\# 입출금 (java source)
​
```
// java에서 온 소스
// 해보자
​
package com.test03;
​
class Account {
    static private int account = 10000;
    private boolean available = false;
​
    public synchronized int get(int value) {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        available = false;
        if (account - value < 0) {
            System.out.println("인출할 수 없습니다. 현재금액: " + account + "요청금액: " + value);
            notify();
            return 0;
        }
        account -= value;
        System.out.println("현재금액: " + account);
        notify();
        return value;
    }
​
    public synchronized void save(int value) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("입금액 : " + value + ",  합계금액 : " + (account + value));
        account += value;
        available = true;
        notify();
    }
​
}
​
class UserIn extends Thread {
    private Account account;
    private String name;
​
    public UserIn(Account a, String name) {
        account = a;
        this.name = name;
    }
​
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.save(1000);
            System.out.println("고객#" + this.name + ", 입금액 : 1000");
        }
    }
}
​
class UserOut extends Thread {
    private Account account;
    private String name;
​
    public UserOut(Account a, String name) {
        account = a;
        this.name = name;
    }
​
    public void run() {
        int value = 0;
        for (int i = 0; i < 5; i++) {
            value = account.get((int) (Math.random() * 5 + 1000));
            System.out.println("고객# " + this.name + ", 출금액 :" + value);
        }
    }
}
```
​
## **Networking**
​
    네트워크(TCP/IP) 개념  
    Socket Programming    
​
   **Socket**
​
   - 소프트웨어로 작성된 통신 접속점이라고 할 수 있는데 네트웍 응용 프로그램은 소켓을 통하여 통신망으로 데이터를 송수신하게 된다.  
   - 응용프로그램에서 TCP/IP를 이용하는 창구 역할을 한다.   
​
   **java.net(package)**
​
    - Datagram : udp 만드는 서버프로그램  
    - Sorket : tcp/ip 만드는 프로그램     
​
\# url을 통해 java.net package 활용
​
```
package com.test04;
​
import java.net.*;
​
public class NetTest01 {
    public static void main(String[] args) {
        
    
    URI u;
    try{
        u = new URI("http://www.naver.com");
        
        System.out.println(u.getScheme());
        System.out.println(u.getUserInfo());
        System.out.println(u.getHost());
        System.out.println(u.getPort());
        System.out.println(u.getPath());
        System.out.println(u.getQuery());
        System.out.println(u.getFragment());
        System.out.println(u.toString());
        System.out.println(u.toURL());
    }catch(URISyntaxException | MalformedURLException e) {
e.printStackTrace();
    }
    }
    
 ====================================================
 
 http
null
www.naver.com
-1
​
null
null
http://www.naver.com
http://www.naver.com
```
​
\# URLConnection 을 이용하여 페이지를 리턴받자.
​
```
package com.test04;
import java.io.IOException;
import java.net.*;
import java.io.*;
​
//URLConnection 을 이용하여 페이지를 리턴받자.
public class NetTest02 {
    
    
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        try {
            URLConnection ucn = new URL("http://www.google.com").openConnection();
            InputStream is = ucn.getInputStream();
            
            bis = new BufferedInputStream(is);
            int res = 0;
            
            while((res = bis.read()) != -1) {
                System.out.println(res);
            }
                
        } catch (MalformedURLException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        } finally {
            try {
            bis.close();
        }catch (IOException e) {
            e.printStackTrace();
            }
        }
        
    }
}
==============================================================
60
33
100
111
99
116
121
112
101
32
104
116
109
108
62
60
104
116
109
108
32
105
116
101
109
115
99
111
112
101
61
34
34
32
105
116
101
109
116
121
112
101
61
34
104
116
116
112
58
47
47
115
99
```
​
\#  Class InetAddress
​
```
package com.test04;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
​
// Class InetAddress
​
public class NetTest03 {
​
    public static void main(String[] args) {
        // static InetAddress   getAllByName(String host) - Method (생성자없네? 메서드로 가져다쓰면 되나보다~~~)
        
        try {
            InetAddress[] iar = InetAddress.getAllByName("www.naver.com"); //-main server ip
            for(InetAddress res : iar) {
                System.out.println(res.getHostAddress());
                System.out.println(res.getHostName());
                
            }       
        } catch (UnknownHostException e) {
            
            e.printStackTrace();
        }
        
        
    }
}
​
====================================================
223.130.195.95
www.naver.com
125.209.222.141
www.naver.com
64:ff9b:0:0:0:0:7dd1:de8d
www.naver.com
64:ff9b:0:0:0:0:df82:c35f
www.naver.com
```
​
  **UDP: User Datagram Protocol**
​
  - 비연결지향적
​
  - 데이터의 신뢰성을 보장 하지 않는다.
​
  - TCP에 비해 전송 속도가 빠르다
​
  UDP Server
​
  : 상대방이 UDP방식으로 보낸 데이터를 받으려면 무조건 패킷에 담아야하고 그걸 socket의 receive 메서드 이용
​
```
package com.test05;
import java.net.*;
import java.io.*;
​
// DatagramSocket(int port) - port열면 Socket이된다.
​
public class UDPServer {
    public static void main(String[] args) {
        System.out.println("UDPServer 야");
        //1 ~ 65535 port , but  (80번대(localport) / 23, 21 /, 7000) - 8,2,7로 시작하는 포트는 지정하지 않는다
        
        
        DatagramSocket d_server = null;
        try {
            d_server = new DatagramSocket(8787); // 포트 8787을 사용하는 소켓 생성
            System.out.println(d_server.getLocalPort());
            //System.out.println(d_server.getInetAddress().getHostAddress()); //null이니까 주석처리했다가 포트실행할때
            System.out.println(d_server.getLocalAddress());
            
        } catch (SocketException e) {
            
            e.printStackTrace();
        }
    }
}
​
=============================================================
​
UDPServer 야
8787
0.0.0.0/0.0.0.0
```
​
UDP Client
​
```
package com.test05;
​
import java.net.DatagramSocket;
import java.net.InetAddress;
​
public class UDPClient { //열려져있는 로컬호스트에 포트만 연결되면 붙는다. udpserver꺼져도 돌아간다.
    
    public static void main(String[] args) {
        System.out.println("UDPClient 야");
        DatagramSocket d_client = null;
        try {
            d_client = new DatagramSocket();
            d_client.connect(InetAddress.getByName("127.0.0.1"),8787); //지정된 ip에 port만 살아있으면 붙고 port 번호 상관없음
            System.out.println(d_client.isBound());
            if(d_client.isConnected()) {
                System.out.println("연결했어");
            }else{
                System.out.println("아니잖아");
            }
        } catch (Exception e) {
            
        }
    }
}
```
​
**\# UDP를 이용하여 Client가 보내는 Data(날짜)를 출력해보자 (UDP는 각자실행)**
​
```
package com.test06;
import java.net.*;
import java.io.*;
import java.util.*;
​
//UDP를 이용하여 Client가 보내는 Data(날짜)를 출력해보자.. (UDP는 각자실행)
​
public class UDPServer {
    private UDPServer() {} // 추상 class 안에 기본 초기값을 주고싶어서 이 클래스를만든다
    public static UDPServer getInstance() {
        return new UDPServer();
    }
    
    
    public static void main(String[] args) {
        //new UDPServer().service();
        UDPServer ser = UDPServer.getInstance();
        ser.service();
    }
    public void service() { 
        Calendar cal = Calendar.getInstance(); // 초기값을 가진 싱글톤 메서드 , 추상클래스가 생성자로 뉴연산자 사용못하면, 스스로를 생성해서 리턴하는게 싱글톤
        DatagramSocket ds = null;
        try {
            
            ds = new DatagramSocket(9999);
            
            byte [] buff = new byte[1024]; //byte계열의 저장소를 만들자 1024 or 2048
            DatagramPacket dp = new DatagramPacket(buff, buff.length); // UDP로 데이터를 받을 객체를 1024크기로 생성 (현재 서버 비생성상태) ->datagramsorket만듬
            //datagrampacket : 클라이언트(datagramsocket으로 만듬) 와 서버(datagramsocket으로 만듬)간의 stream이 지나다니는 통로! (udp만)
            
            
            // 데이터 받아보자
            ds.receive(dp); // dp를지정
            String str = new String(dp.getData()); // 반대는 setdata
            String s = String.format("받을날짜 : %1$tm %1$te,%1$tY", cal); //연월일을 나타낼때 data 서식임
            System.out.println(s + " : " + str.trim());
            
                    
                    
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
===========================================================================
​
받을날짜 : 07 11,2021 : Locak time 22:40:31
```
​
```
package com.test06;
​
import java.net.*;
import java.io.*;
import java.util.*;
​
public class UDPClient {
    public static void main(String[] args) {
        new UDPClient().m_connect();
        
    }
    public void m_connect(){
        Calendar cal = Calendar.getInstance(); 
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
        // 서버에 보낼 데이터를 지정하자.
            String str = String.format("Locak time %tT", Calendar.getInstance()).trim(); //%tT" : 시간을 리턴
            byte[] buff = str.getBytes();
            
            DatagramPacket dp = new DatagramPacket(buff, buff.length, InetAddress.getByName("127.0.0.1"), 9999);
            ds.send(dp);
            System.out.println("보낸 메시지 확인 : " + str);
            
        } catch(Exception e) {
    
    } finally {
        
    }   // 무조건 서버를 먼저돌려라 그리고 클라이언트를 돌려! 서버는 가만히있어 빙글빙글돌아~~~ 그사이에 클라이언트실행해
        // 창이 두개야 console 확인하자! <받을날짜 : 07 5,2021 : Locak time 16:26:50 , 보낸 메시지 확인 : Locak time 16:26:50>
        
}
}
=============================================================
보낸 메시지 확인 : Locak time 22:40:31
```
​
**TCP: Transmission Control Protocol**
​
\- TCP 프로그램은 신뢰성(데이터 100%전송)이 보장.  
\- UDP방식(신뢰성 전무,오직 전송)보다 많이 사용
​
\- ServerSocket 클래스와 Socket 클래스로 구성
​
  
  
​
```
package com.test07;
​
import java.io.*;
import java.net.*;
​
//  socket  <-> serversocket // server 소켓을만들면 tcpserver를 만들고, socket을만들면 tcp client를 만든다고한다.
// tcpclient    tcpserver // socket을 만들면 ip, port 생성된다. 생성과 동시에 client가 연결되면 accept()메서드를 를 받아 통로가 생성된다. 
// accept를 해서 통로를 이용해 만들어지는게 socket ! socket - getOutputstream(), getInputstream() : 데이터를 입출력 
​
// 서버에서 글자써,, 클라이언트로 보내
public class TcpServer {
public static void main(String[] args) {
    ServerSocket server = null;
    Socket service = null;
    DataOutputStream oos = null;
    OutputStream ops = null;
            
    try {
        server = new ServerSocket(9090);
        System.out.println("클라이언트의 접속을 기다린다. ");
            while(true) {
                service = server.accept();
                System.out.println("클라이언트가 접속됬어");
                ops = service.getOutputStream();
                oos = new DataOutputStream(ops);
                oos.writeUTF("Hello java.net");
            }
            
        
    }catch (Exception e) {
        System.out.println(e);
    }finally {
        try {
            oos.close();
            ops.close();
            service.close();
            server.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
        
    }
            
    
}
}
​
=============================================================
​
클라이언트의 접속을 기다린다. 
클라이언트가 접속됬어
```
​
```
package com.test07;
​
import java.io.*;
import java.net.*;
​
public class TcpClient {
    public static void main(String[] args) {
        Socket client = null;
        try {
            client = new Socket("127.0.0.1",9090);
            InputStream is = client.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String str = dis.readUTF();
            System.out.println("서버에서 보낸것 :" + str);
            dis.close();
            is.close();
            
        } catch (Exception e) {
            System.err.println(e);
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } //  console 창이두개얌 
     // server : 클라이언트의 접속을 기다린다. 클라이언트가 접속됬어
     // client : 서버에서 보낸것 :Hello java.net
​
}
​
=================================================================
​
서버에서 보낸것 :Hello java.net
```
