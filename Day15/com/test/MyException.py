class MyException(Exception):
    def __init__(self,value): #4) value = err_mgs / value = "My Error!!!"
        self.value = value # 5) 멤버변수 value = "My Error!!!"
    def __str__(self): #인스턴스 자체를 출력 할 때의 형식을 지정해주는 함수 8)
        return self.value #My Error

# 생성자와 어떤기능을 가지고있으면서 자동으로 호출하는 객체

def raise_exception(err_mgs): #username 2).err_mgs = My Error !!!
    raise MyException(err_mgs) #3) err_mgs = My Error !!!, 프로그램중단
# 강제로 Error를 발생시키는 함수를 생성 후 호출 ↑
# raise를 강제로 주지않으면 일반클래스라고 생각해서 except뒤에 올 수 없음


if __name__ == '__main__':
    try:
        raise_exception("My Error!!") #1.함수호출(모듈안에 객체라서 메서드)
        # raise MyException("My Error!!") 로 위 메소드 없이 바로 사용해도됨
    except MyException as e: # e= MyException , 프로그램이 중단된 주소값을 입력받음 6)
        print(e.args) #7), 9)
        # except 뒤에 오는 class는 pvm이 Error class로 인지를 해야 올 수 있음
        #그림보기