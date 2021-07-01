class Calc: #클래스 선언
    def __init__(self,a,b): #생성자 a,b
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
    m = Calc(100,200) # m 이라는 변수를 이용
    # 강한 private , 은닉화
    print("%5d + %5d = %5d"%(m.get_a(), m.get_b(), m.get_hap()))
    print("%5d - %5d = %5d"%(m.get_b(), m.get_a(), m.get_sub()))
    print("%5d * %5d = %5d"%(m.get_a(), m.get_b(), m.get_mul()))
    print("%5d / %5d = %5d"%(m.get_b(), m.get_a(), m.get_div()))

