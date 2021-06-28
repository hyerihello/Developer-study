#[Step 01:클래스 선언]
class Test: #object의 후손 클래스가 되어 선조의 멤소드들을 참조하고 있다. object <-Test
    def empty(self):
        self.data = []

    def add(self, x):
        self.data.append(x)
# 그리고 코드작성

if __name__ == '__main__':
#[Step 02 : 클래스 객체 생성]
    my01 = Test()
    #my01의 변수에 Test라는 클래스의 객체를 생성하게 되면 메모리에 Test클래스와 같은 자료형이 생성되어
    #메모리에 확보되고 확보된 주소가 my01에 = 연산자를 통해 대입되어 참조된다.
    my02 = Test()
    #my02의 변수에 Test라는 클래스의 객체를 생성하게 되면 메모리에 Test클래스와 같은 자료형이 생성되어
    #메모리에 확보되고 확보된 주소가 my02에 = 연산자를 통해 대입되어 참조된다.

#[Step 03 : 멤버호출]
    my01.empty()
    my02.empty()
    for i in range(1,6):
        my01.add(i)

    print(my01.data)
    print(my02.data)
    print(my01,my02)
    my03=my01
    print(my03.data)
    print(my01,my03)


