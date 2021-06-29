# 간단한 구조의 상속을 구현해 보자.
# 이름과 나이를 관리하는  person 클래스가 있다.
# Student 클래스를 만들어서 person을 상속받아
# 학년만 추가해서 이름, 나이, 학년을 모두 출력하는 클래스를 만들고 싶다.

class Person:
    #__b = 10 #강한 private 형식은 멤버만 호출이 가능하다. 후손은 호출이 불가능하다.
    def __init__(self,name,age): #매개 변수를 통해 초기값을 전달받아 초기화 #5 .
        # 선조의 객체가 생성되면서 멤버변수에게 값 전달
        self.name = name
        self.age = age
        #self.__b=b
    def personInfo(self): #멤버변수 출력용 메소드 + 연결 연산자는 시퀀스의 같은 객체끼리 연결이 가능하다.
        return self.name + ": (age :" + str(self.age)+")"

class Student(Person): #2
    def __init__(self,name,age,grade): #3
        Person.__init__(self,name,age) #4 선조의 생성자
        # super().__init__(self,name,age) 로 생성도 가능함
        self.grade=grade #6. 객체 생성하면서 grade 변수 값 전달

    def GetStudent(self):
       # print("b=" , self.__b)
        return self.personInfo() + ",grade :"+ str(self.grade)

if __name__ == '__main__':
    x=Student("Ruri",7,3) #1.Student("Ruri",7,3) #7. 생성된 선조의 주소를 리턴
    print(x.GetStudent())
    print(x.personInfo())
    # 이미지 첨부
    '''
    y=Person("abc",10)
    print(y.personInfo())
    '''