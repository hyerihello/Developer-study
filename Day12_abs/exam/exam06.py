'''
 두수를 입력받아 (두수를 입력받을 생성자 또는 a,b를 관리하는 메소드) 사칙구현하는 클래스를 만들고 싶다.
  100 + 200 =   get_hap()
  200 - 100 =   get_sub()
  100 * 200 =   get_mul()
  200 / 100 =   get_div()

  100 + 300 =   get_hap()
  300 - 100 =   get_sub()
  100 * 300 =   get_mul()
  300 / 100 =   get_div()

  200 + 300 =   get_hap()
  300 - 200 =   get_sub()
  200 * 300 =   get_mul()
  300 / 200 =   get_div()

   class Calc:

   [step 4단계 : 출력문]
   - prn 함수

'''

'''
    class userName(클래스선언) -> 생성자 -> 멤버변수 getter&setter -> 계산형메소드 -> 출력용메서드 -> 소멸자
    // 생성자는 명시하지 않으면 파이썬에서 기본 생성자를 자동으로 호출해서 __init(self) : 객체를 생성하고
      명시하게 되면 명시된 생성자가 호출한다.  
'''

class Calc:

    def __init__(self,a,b):
        self.__a = a #__a , 멤버변수를 현재 Calc안에는 메소드에만 공개하겠다. 멤버에게만 공개하겠다. private이라 하겠다.
        self.__b = b

    #읽기전용
    def get_a(self): #a,b를 은닉하고 리턴하는 메소드
        return self.__a
    def get_b(self):
        return self.__b

    #쓰기전용
    def set_b(self,b): #초기값 외에 __b의 값만 변경하고싶은 욕망의 메소드를 선언
        # = 멤버변수의 값 전달 및 변경
        self.__b = b
    def set_a(self,a): #초기값 외에 __a의 값도 변경하고싶은 욕망의 메소드를 선언
        # = 멤버변수의 값 전달 및 변경
        self.__a = a


    def get_hap(self):
        return self.__a + self.__b
    def get_sub(self):
        return self.__b - self.__a
    def get_mul(self):
        return self.__a * self.__b
    def get_div(self):
        return self.__b / self.__a


    def calc_prn(self):
        print("\n")
        print("%5d + %5d = %5d" % (self.get_a(), self.get_b(), self.get_hap()))
        print("%5d - %5d = %5d" % (self.get_b(), self.get_a(), self.get_sub()))
        print("%5d * %5d = %5d" % (self.get_a(), self.get_b(), self.get_mul()))
        print("%5d / %5d = %5d" % (self.get_b(), self.get_a(), self.get_div()))



if __name__ == '__main__':
    m = Calc(100,200) # 생성자
    m.calc_prn()

    m.set_b(300)
    m.calc_prn()

    m.set_a(200)
    m.calc_prn()
    '''
    print("%5d + %5d = %5d"%(m.a,m.b,m.get_hap()))
    print("%5d - %5d = %5d"%(m.b,m.a,m.get_sub()))
    print("%5d * %5d = %5d"%(m.a,m.b,m.get_mul()))
    print("%5d / %5d = %5d"%(m.b,m.a,m.get_div()))
    '''
    # 새로운 계산기 만들기
    m1=Calc(300,400)
    m1.calc_prn()
