'''
 두수를 입력받아 (두수를 입력받을 생성자 또는 a,b를 관리하는 메소드) 사칙구현하는 클래스를 만들고 싶다.
  100 + 200 =   get_hap()
  200 - 100 =   get_sub()
  100 * 200 =   get_mul()
  200 / 100 =   get_div()
   class Calc:

   [step 2단계 : a,b 를 관리하는 메소드 절실하게 느껴보자]
   << 멤버 변수를 private 지정하고 외부에서 각각의 전달받은 두수를 리턴해서 확인 할 수 있도록
       return 형 메소드를 선언 >>
   - 변수를 바로 호출하면 값이 적나라하게 나옴
   - 형변환

'''

class Calc:

    def __init__(self,a,b):
        self.__a = a #__a , 멤버변수를 현재 Calc안에는 메소드에만 공개하겠다. 멤버에게만 공개하겠다. private이라 하겠다.
        self.__b = b
    # 리턴형 메소드 ↓
    def get_a(self): #a,b를 은닉하고 리턴하는 메소드
        return self.__a
    def get_b(self):
        return self.__b



    def get_hap(self):
        return self.__a + self.__b
    def get_sub(self):
        return self.__b - self.__a
    def get_mul(self):
        return self.__a * self.__b
    def get_div(self):
        return self.__b / self.__a

if __name__ == '__main__':
    m = Calc(100,200) # 생성자
    '''
    print("%5d + %5d = %5d"%(m.a,m.b,m.get_hap()))
    print("%5d - %5d = %5d"%(m.b,m.a,m.get_sub()))
    print("%5d * %5d = %5d"%(m.a,m.b,m.get_mul()))
    print("%5d / %5d = %5d"%(m.b,m.a,m.get_div()))
    '''
    # 강한 private , 은닉화
    print("%5d + %5d = %5d"%(m.get_a(),m.get_b(),m.get_hap()))
    print("%5d - %5d = %5d"%(m.get_b(),m.get_a(),m.get_sub()))
    print("%5d * %5d = %5d"%(m.get_a(),m.get_b(),m.get_mul()))
    print("%5d / %5d = %5d"%(m.get_b(),m.get_a(),m.get_div()))

