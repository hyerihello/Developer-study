# 정수형 변수 a,b를 관리하는 클래스를 만들어 보자. 단 캡슐화로 구현해보자
# 은닉된 멤버 변수에게 setxx으로 값 전달 및 변경하고 getxx return 메소드로 리턴하는 구조
class Test:
    __a=0 # 주소 히든 private 초기값은 생성자에서 대입
    __b=0
    # name = 'abc' def setName():
    def setA(self,a):
        self.__a=a #객체 생성 후 값을 a로 전달받아 멤버 __a 에게 값 전달 및 변경
    def getA(self):
        return self.__a

    def setB(self,b):
        self.__b=b
    def getB(self):
        return self.__b

if __name__ == '__main__':
    t1=Test()
    t1.setA(100)
    print(t1.getA())

    t1.setB(200)
    print(t1.getB())

