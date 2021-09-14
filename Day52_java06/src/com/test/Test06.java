package com.test;
import java.io.*;
import com.test02.Address;
// ��ü ������ ���� ������� ��������.

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
			Address a1 = (Address)ois.readObject(); //�ٿ�ĳ����
			Address a2 = (Address)ois.readObject();
			Address a3 = (Address)ois.readObject();
			
			System.out.println(a1);
			System.out.println(a2);
			System.out.println(a3);
			
		} catch (ClassNotFoundException | IOException e) { //or�̱� ������ ���� e �ϳ��̴�.
			
			e.printStackTrace();
		} //�� ������� ����
		
	}
	
	public static void main(String[] args) {
		File fi = new File("test06.txt");
		try {
			//MyWrite(fi);
			MyRead(fi);
		} catch(IOException io){
			System.out.println(io);
		}
	}
}
