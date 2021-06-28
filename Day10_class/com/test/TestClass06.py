# 생성자와 소멸자를 살펴보자
# 생성자를 명시하지 않으면 자동으로 내부호출되어 생성되고 명시하게되면 명시된 생성자가 호출된다.
# 생성자는 단 한번 객체를 생성할 때 자동 호출되며 해당 클래스의 모든 멤버를 동적 할당 메모리로 로드하게된다.
# 생성자의 목적은 멤버 변수 초기화에 있다.

class MyDel:
    def __init__(self,a): #생성자
        self.a=a
        print("__init__")

    def __del__(self): #소멸자 객체가 소멸되는 시점에서 호출 되면서 리소스 해제
        print("__del__")

if __name__ == '__main__':
    a1 = MyDel(100) #MyDel 이라는 클래스를 생성자를 호출하면서 객체 생성한다.
    print(a1)
    del a1
    print("abcd")
    print("a=",a1)
    a1=Mydel()
    print("a=", a1)


