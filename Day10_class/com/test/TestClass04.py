#캡슐화 : 은닉된 멤버 변수에 오픈된 메소드로 값을 전달(setxx) 및 변경하는 구조 (getxx return)
# getter & setter
class Test:
    __b=100 #객체 생성 후 호출할 수 없고, Test의 멤버만 접근이 가능하다.
    def __m(self): #한문자를 리턴하는 private 메소드
        return 'a'
    def k(self):
        print(self.__m(), self.__b)


if __name__ == '__main__':
    my = Test()
    my.k()
    # print(my.__b) 오류 ,,! Test.__b 또한 안됨

