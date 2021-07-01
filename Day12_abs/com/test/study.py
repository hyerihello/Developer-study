class Calc: #클래스 선언

    def __init__(self,a,b): #생성자 a,b
        self.__a = a #__a , 멤버변수를 현재 Calc안에는 메소드에만 공개하겠다. 멤버에게만 공개하겠다. private이라 하겠다.
        self.__b = b

    # 리턴형 메소드 ↓
    def get_a(self): #a,b를 은닉하고 리턴하는 메소드
        return self.__a
    def get_b(self):
        return self.__b

    def set_a(self,a): #초기값 외에 __a의 값도 변경하고싶은 욕망의 메소드를 선언
        self.__a = a  # = 멤버변수의 값 전달 및 변경
    def set_b(self,b):  #초기값 외에 __b의 값만 변경하고싶은 욕망의 메소드를 선언
        self.__b = b #멤버변수의 값 전달 및 변경


    def get_hap(self):
        return self.__a + self.__b
    def get_sub(self):
        return self.__b - self.__a
    def get_mul(self):
        return self.__a * self.__b
    def get_div(self):
        return self.__b / self.__a


    def caln_prn(self):
        print("\n")
        print("%5d + %5d = %5d" % (self.get_a(), self.get_b(), self.get_hap()))
        print("%5d - %5d = %5d" % (self.get_b(), self.get_a(), self.get_sub()))
        print("%5d * %5d = %5d" % (self.get_a(), self.get_b(), self.get_mul()))
        print("%5d / %5d = %5d" % (self.get_b(), self.get_a(), self.get_div()))


class MyTest:
    def mytest_prn(self):
        print("\nMytest_prn")

