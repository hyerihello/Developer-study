# 심심한 그대
class MyClassA(object): #클래스 선언시 모든 클래스가 object의 상속을 받는 후손이 된다.
                        # class MyClassA(object): = class MyClass A:
    def __init__(self):
        self.val1 = 123
class MyClassB(MyClassA):
    def __init__(self):
        super(MyClassB, self).__init__() #super().__init__()로도 명시해서실행해보기
        self.val2 = 456

class Dog:
    def sound(self):
        print("bark")
class Cat:
    def sound(self):
        print("meow")
class Chimera(Dog,Cat):
    pass

if __name__ == '__main__':
    a = MyClassB()
    print(a.val1)
    print(a.val2)
    Chimera().sound()
    print(dir())
    print(help(object))


'''
1. 모든 클래스의 선조는 object 클래스이다.

2. 클래스를 선언하게 되면 내장으로 사용되는 메소드는 object 클래스로 부터 받은 메소드이다.

3. __class__ ▶ type( )

    >>> a=40
    >>> type(40)  ▷ int  class가 가진 __class__가 자동으로 호출되어 리턴하는 값 
          <class 'int'>
    >>> a.__class__
          <class 'int'>
    >>> b=97.7
    >>> type(b)
          <class 'float'>
    >>> b.__class__
          <class 'float'>
          
4. 연산자 오버로딩 = exam02.py 

5. 객체.__dir__ = >> dir()

'''


