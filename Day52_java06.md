## **파일처리**

#### **File class(io.package)**

public class File extends Object implements Serializable, Comparable<File>

**생성자**

File(String pathname)

 : 지정 경로 밑에 폴더 만들기 (존재하지 않을 때)

 : 지정된 경로 이름 문자열을 추상 경로 이름으로 변환하여 새 파일 인스턴스를 생성합니다.

```
package com.test;
import java.io.*;

// 파일클래스가 가진 생성자와 메소드를 살펴보자. 
public class Test {
	
	// File(String pathname)
	public static void prn() {
		File f = new File("c:\\Utest");
		f.mkdir(); // File 경로가서 확인해보자.
		if(f.exists()) {
			System.out.println("이미 만들어 졌어");
		} else {
			f.mkdir();
			System.out.println("지금 만들었다.");
		}
	}
    
==============================================

 이미 만들어 졌어
```

File(String parent, String child)

 : 상위 경로 이름 문자열과 하위 경로 이름 문자열에서 새 파일 인스턴스를 생성합니다.

```
	// File(String parent, String child)
	public static void prn02() {
		File f = new File("c:\\Utest", "mytest11");
		f.mkdir(); // File 경로가서 확인해보자.
	}
```

 File(File parent, String child)

 : 상위 추상 경로 이름과 하위 경로 이름 문자열에서 새 파일 인스턴스를 생성합니다.

```
	public static void prn03() {
		File parent = new File("c:\\Utest");
		File f = new File(parent, "mytest02");
		f.mkdir(); // File 경로가서 확인해보자.
	}
```

```
	public static void main(String[] args) {
		
		System.out.println(File.pathSeparator);
		System.out.println(File.pathSeparatorChar);
		System.out.println(File.separator);
		System.out.println(File.separatorChar);
		
		String path = "c:" + File.separatorChar + "test" + File.separator + "ytest"; //운영체제 별로 디렉토리 
		System.out.println(path);
		File fi = new File(path);
		fi.mkdir();
		
	}
	}
    =====================================================
    
;
;
\
\
c:\test\ytest
```

**파일 생성하기** 

```
package com.test;
import java.io.*;
import java.security.DomainCombiner;
public class Test01 {
	
	// 파일을 만들어 보자.
	public static void disp() {
		
		File f = new File("c:\\Utest");
		File fi = new File(f, "B.txt");
		//System.out.println(fi);
		try { // 없으면 새로생성하자.
			fi.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(f.getAbsolutePath()); //절대 (full path)
		System.out.println(f.getName());
		System.out.println(f.getFreeSpace());
		System.out.println(f.getParent());
		System.out.println(f.getPath()); //상대 
		System.out.println(f.getParentFile());
		System.out.println(f.lastModified()); // 마지막 탐색시간 
	}
    
    public static void main(String[] args) {
	disp();
}
}
=========================================================
c:\Utest
Utest
387012681728
c:\
c:\Utest
c:\
1625306053625
```

**지정된 폴더 내 새 파일 생성 후, 다른 폴더로 이름 변경 후 이동**

```
package com.test;
import java.io.*;
import java.security.DomainCombiner;
public class Test01 {
	
	
	//
	public static void disp02() {
		/* 1. Utest 디렉토리에 있는 11_11.txt를 c:\test로 이동
		 * 2. Utest \11_11.txt 삭제
		 */
		
		File fi = new File("c:\\Utest\\11_11.txt");
		try {
			fi.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fi.renameTo(new File("c:\\Test\\11_11.txt"));
	}
	
    public static void main(String[] args) {
	disp02();
}
}
```

**지정된 디렉토리의 파일의 개수와 디렉토리 개수를 출력**

```
package com.test;
import java.io.*;
import java.security.DomainCombiner;
public class Test01 {

public static void disp03() {
		String path = "C:\\Windows\\System32";
		File file = new File(path);
		//지정된 디렉토리의 파일의 개수와 디렉토리 개수를 출력해보자.
		File [] file_list = file.listFiles();
		
		int file_cnt = 0;
		int dir_cnt = 0;
		
		//배열의 객체를 하나씩 풀어서 File로 리턴받아 isXX 메소드를 통해 파일과 디렉토리를 판별한다.
		for (File r : file_list) {
			if(r.isDirectory()) {
				dir_cnt++;
				
				System.out.println("dir :" + r.getName());
			}
			if(r.isFile()) {
				file_cnt++;
				System.out.println("file : " + r.getName());
			}
		}
		System.out.println("전체 개수 :" + file_list.length);
		System.out.println("디렉토리 개수 :" + dir_cnt);
		System.out.println("파일의 개수 :" + file_cnt);
	}
	
public static void main(String[] args) {
	disp03();
}
}
========================================================================

file : forfiles.exe
file : format.com
file : fpb.rs
file : fphc.dll
dir :fr-CA
dir :fr-FR
file : framedyn.dll
file : framedynos.dll
file : FrameServer.dll
file : FrameServerClient.dll
file : frprov.dll
file : fsavailux.exe
file : FsIso.exe
file : fsmgmt.msc
file : FsNVSDeviceSource.dll
file : fsquirt.exe
file : fsutil.exe
file : fsutilext.dll
file : fthsvc.dll
file : ftp.exe
file : fundisc.dll
file : fveapi.dll
file : fveapibase.dll
file : fvecerts.dll

'''

전체 개수 :4541
디렉토리 개수 :134
파일의 개수 :4407
```

#### **파일 입/출력**

**1\. 문자 단위로 파일 입/출력** 

**(1) 입력**

FileWriter class

 → docs 참고

public void write(int c) throws IOException

```
package com.test;
import java.io.*;
// 1. 문자 단위로 파일 입출력을 하자.
public class Test02 {

	public static void MyWrite(File f) throws IOException{
		FileWriter fw = new FileWriter(f, true); // true 는 append한다.
		fw.write("abcdefg\n");
		fw.append("111111\n");
		fw.append("abcdefggggg\n");
		
		String str = String.format("%5d %5d %5d \n", 10, 20, 30);
		fw.append(str);
		
		char[] res = str.toCharArray();
		fw.write(res);
		
		char [] res02 = "abcdef 오늘은 수요일".toCharArray();
		fw.write(res02);
		
		fw.close();
		
	}
    
    
    
public static void main(String[] args) {
		String filename = "test02.txt";
		File f = new File(filename);
		try {
			MyWrite(f);
			//MyRead(f);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```

```
[test02.txt]

abcdefg
111111
abcdefggggg
   10    20    30 
   10    20    30 
abcdef 오늘은 수요일
```

**(2) 출력**

FileReader class

 → docs 참고, FileReader 가 extends 하는 InputStreamReader의 Method 를 확인하자. (FileReader method가 없음)

public int read() throws IOException

 : The character read, or -1 if the end of the stream has been reached

```
package com.test;
import java.io.*;

public class Test02 {

    public static void MyRead(File f) throws IOException { 
		FileReader fr = new FileReader(f);
		int ch = 0;
		
		//파일의 끝이 -1이 될때까지 글자를 하나씩 읽어서 ch로 리턴받아 출력하자.
		while ((ch = fr.read()) != -1) { // 문자 읽기 또는 스트림 끝에 도달한 경우 -1
			System.out.printf("%c", (char)ch);
		}
		fr.close();
	}
 
 
 
	public static void main(String[] args) {
		String filename = "test02.txt";
		File f = new File(filename);
		try {
			//MyWrite(f);
			MyRead(f);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

=====================================================================
abcdefg
111111
abcdefggggg
   10    20    30 
   10    20    30 
abcdef 오늘은 수요일
```

**2\. byte 단위로 파일 입출력 (stream 이용)**

 **(1) 입력**

FileOutputStream class

 : FileOutputStream is meant for writing streams of raw bytes such as image data. For writing streams of characters, consider using FileWriter.

```
package com.test;
import java.io.*;
// 2. byte 단위로 파일 입출력을 하자.

public class Test03 {

	public static void MyWrite(File f) throws IOException{
		FileOutputStream fos = new FileOutputStream(f);
		for(int i = 65; i < 91; i++) {
			fos.write(i);
			
		}
		
		String msg = "오늘은 수요일이다";
		fos.write(msg.getBytes());
		fos.close();
	}
    

	public static void main(String[] args) {
		File fi = new File("test03.txt");
		try {
			MyWrite(fi);
			//MyRead(fi);
			
		}catch(IOException ie) {
			System.out.println(ie);
		}catch(Exception e) {
			
		}
	}
}
```

```
[test03.txt]

ABCDEFGHIJKLMNOPQRSTUVWXYZ 오늘은 수요일이다
```

**(2) 출력**

FileInputStream class

: A FileInputStream obtains input bytes from a file in a file system.

public int read(byte\[\] b) throws IOException

: the total number of bytes read into the buffer, or \-1 if there is no more data because the end of the file has been reached.

```
package com.test;
import java.io.*;
// 2. byte 단위로 파일 입출력을 하자.

	public static void MyRead(File f) throws IOException {
		FileInputStream fis = new FileInputStream(f);
		int ch =0;
		while ((ch = fis.read()) != -1) { 
         // 버퍼에서 읽은 총 byte 수 또는 파일 끝에 도달하여 데이터가 더 이상 없는 경우 -1 입력
			System.out.printf("%c", (char)ch);
		}
				
	}
	
    
	public static void main(String[] args) {
		File fi = new File("test03.txt");
		try {
			//MyWrite(fi);
			MyRead(fi);
			
		}catch(IOException ie) {
			System.out.println(ie);
		}catch(Exception e) {
			
		}
	}
}
==================================================================

ABCDEFGHIJKLMNOPQRSTUVWXYZ¿?´??º ¼?¿?????´?
```

**3\. 이미지 파일 입 출력**

(1) 입, 출력 

```
package com.test;
import java.io.*;
// 3. 이미지 파일을 입출력을하자.

public class Test04 {

	public static void MyWrite(File f){
	
	}
	public static void MyRead(File f) {
		
	}
	public static void prn01() {
		
			//1. 이미지 파일을 객체를 생성한다.
			File fi = new File("apple01.jpg");
			File output = new File("apple_res.jpg");
			
			//2. 이미지 파일을 스트림으로 읽어들인다.
			FileInputStream fis = null;
			FileOutputStream fos = null;
			
			int ch =0;
			try {
				fis = new FileInputStream(fi); //읽고
				fos = new FileOutputStream(output);//쓰고
				while((ch = fis.read()) != -1) {
					fos.write(ch); //3. 읽어들인 데이터를 apple_res.jpg로 저장한다.
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException ie) {
				
			} finally {
				try {
					fos.close();
					fis.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}

public static void main(String[] args) {
	prn01();
```

[##_Image|kage@mh9Ej/btq8L8vdCIN/K8lKgP4hZLHtypNckTi2B1/img.png|alignCenter|data-origin-width="973" data-origin-height="671" data-ke-mobilestyle="widthOrigin"|Test06 프로젝트를 F5를 눌러 새로고침 하면 새로 저장 되어있는 것을 볼 수 있다.||_##]

(2) 입, 출력 

```
package com.test;
import java.io.*;
// 3. 이미지 파일을 입출력을하자.
public class Test04 {

	public static void MyWrite(File f){
	
	}
	public static void MyRead(File f) {
		
	}
    
    public static void prn02() {
		
			//1. 이미지 파일을 객체를 생성한다.
			File fi = new File("apple01.jpg");
			File output = new File("apple_res2.jpg");
			
			//2. 이미지 파일을 스트림으로 읽어들인다.

			
			int ch =0;
			try (FileInputStream fis =  new FileInputStream(fi);
				FileOutputStream fos = new FileOutputStream(output)){
				
				while((ch = fis.read()) != -1) {
					fos.write(ch); //3. 읽어들인 데이터를 apple_res.jpg로 저장한다.
				}
			} catch(Exception ie) {
				System.out.println(ie.getMessage());

			}
		}
	
	
	public static void main(String[] args) {
		//prn01();
		prn02();
}}
```

[##_Image|kage@cecZCW/btq8IeKbwpG/xFKyDhpAKwwWnZothqRR4k/img.png|alignCenter|data-origin-width="1045" data-origin-height="651" data-ke-mobilestyle="widthOrigin"|||_##]

**4. BufferStream 입 출력**

public class BufferedOutputStream extends FilterOutputStream

 : The class implements a buffered output stream

public class BufferedInputStream extends FilterInputStream

 : the ability to buffer the input and to support the mark and reset methods.

(1) 입, 출력

```
package com.test;
import java.io.*;

// BufferStream

public class Test05 {

	public static void MyWrite(File f) throws IOException{
    
		File res = f;
		FileOutputStream fos = new FileOutputStream(res); // 버퍼링된 출력 스트림을 구현
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		

		bos.write("abcde".getBytes());
		bos.close(); 
		
		fos.close();
	}
    
    
	public static void MyRead(File f) throws IOException {
		

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
		int res = 0;
		
		while ((res = bis.read()) != -1) {
			System.out.printf("%c", res);
		}
		

		bis.close(); 

		
	}
	
	public static void main(String[] args) {
		File fi = new File("test05.txt");
		try {
			//MyWrite(fi);
			MyRead(fi);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

=================================================================
<console>

abcde
```

```
[text05.txt]

abcde
```

(2) 입, 출력

```
package com.test;
import java.io.*;


public class Test05 {

	public static void MyWrite(File f) throws IOException{

		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
	
		bos.write("abcde".getBytes());
		bos.close(); //자동으로 닫힘 fos

	}
    
	public static void MyRead(File f) throws IOException {
		

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
		int res = 0;
		
		while ((res = bis.read()) != -1) {
			System.out.printf("%c", res);
		}
		

		bis.close(); 

		
	}
	
	public static void main(String[] args) {
		File fi = new File("test05.txt");
		try {
			MyWrite(fi);
			MyRead(fi);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
===============================================================================
<console>

abcdefghijk
```

```
[text05.txt]

abcdefghijk
```

**5. 객체 단위 입 출력**

public class ObjectOutputStream extends OutputStream implements ObjectOutput, ObjectStreamConstants

 : An ObjectOutputStream writes primitive data types and graphs of Java objects to an OutputStream.

public class ObjectInputStream extends InputStream implements ObjectInput, ObjectStreamConstants

 : An ObjectInputStream deserializes primitive data and objects previously written using an ObjectOutputStream.

```
package com.test;
import java.io.*;
import com.test02.Address;
// 객체 단위로 파일 입출력을 구현하자.

public class Test06  {

	public static void MyWrite(File f) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		Address a1= new Address("111", "111", "111");
		Address a2= new Address("112", "1112", "1112");
		Address a3= new Address("113", "1113", "1113");
		oos.writeObject(a1);
		oos.writeObject(a2);
		oos.writeObject(a3);
		oos.close();
		
		
	}
    
    
	public static void MyRead(File f) throws FileNotFoundException, IOException  {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		try {
			Address a1 = (Address)ois.readObject(); //다운캐스팅
			Address a2 = (Address)ois.readObject();
			Address a3 = (Address)ois.readObject();
			
			System.out.println(a1);
			System.out.println(a2);
			System.out.println(a3);
			
		} catch (ClassNotFoundException | IOException e) { //or이기 때문에 변수 e 하나이다.
			
			e.printStackTrace();
		} //쓴 순서대로 리턴
		
	}
	
	public static void main(String[] args) {
		File fi = new File("test06.txt");
		try {
			MyWrite(fi);
			//MyRead(fi);
		} catch(IOException io){
			System.out.println(io);
		}
	}
}

==========================================================================
  111   111   111

  112  1112  1112

  113  1113  1113

```

[##_Image|kage@WYeHQ/btq8JtmRkGW/2S127RthJGxavSNJ8EtfOk/img.png|alignCenter|data-origin-width="777" data-origin-height="120" data-ke-mobilestyle="widthOrigin"|||_##]

**6. Scanner.class(util.package) 를 이용한 입출력**

public final class Scanner extends Object implements Iterator<String>, Closeable

 : A simple text scanner which can parse primitive types and strings using regular expressions.

\[형식\]

Scanner sc = new Scanner(System.in);

 int i = sc.nextInt();

```
package com.test;
import java.io.*;
import java.util.*;

public class Test08 {

	public static void main(String[] args) {
		
		File f = new File("test07.txt");
		try (Scanner sc = new Scanner(f)){
			String s1 = sc.next();  // 문자타입  변수 = 출력
			int a1 = sc.nextInt();
			double d1 = sc.nextDouble();
			System.out.println(s1);
			System.out.println(a1);
			System.out.println(d1);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

}
===========================================================================

대한민국
123
92.8
```
