# 이름, 주소, 전화번호를 관리하는 Address라는 클래스를 선언해서 변수로 값을 저장해보자
# 정적변수 static 변수 클래스.멤버변수
class Address:
    name = "Dominica"
    addr = "seoul"
    tel = "02-0000-0000"
    def prn(self): #멤버 메소드
        print(Address.name, Address.addr, Address.tel)

if __name__ == '__main__':
    print(Address.name, Address.addr, Address.tel)
    Address.name="111111"
    print(Address.name, Address.addr, Address.tel)

    a1=Address()
    a1.prn()

    # 이미지첨부하기