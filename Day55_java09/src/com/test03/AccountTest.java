// java에서 온 소스
// 해보자

package com.test03;

class Account {
	static private int account = 10000;
	private boolean available = false;

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

}

class UserIn extends Thread {
	private Account account;
	private String name;

	public UserIn(Account a, String name) {
		account = a;
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			account.save(1000);
			System.out.println("고객#" + this.name + ", 입금액 : 1000");
		}
	}
}

class UserOut extends Thread {
	private Account account;
	private String name;

	public UserOut(Account a, String name) {
		account = a;
		this.name = name;
	}

	public void run() {
		int value = 0;
		for (int i = 0; i < 5; i++) {
			value = account.get((int) (Math.random() * 5 + 1000));
			System.out.println("고객# " + this.name + ", 출금액 :" + value);
		}
	}
}

public class AccountTest {
	public static void main(String args[]) {
		Account a = new Account();
		UserIn usr1 = new UserIn(a, "홍길동");
		UserOut usr2 = new UserOut(a, "정길동");
		usr1.start();
		usr2.start();
	}
}
