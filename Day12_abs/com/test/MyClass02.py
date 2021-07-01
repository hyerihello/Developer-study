# @property : 메소드를 변수로 호출 할 수 있도록 지칭

class My:
    def __init__(self):
        self.x = 0
    @property   #@mFun.getter의 의미를 가진다 
    def mFun(self): #멤버 변수 x를 리턴하는 Usermember Method
        return self.x #get의 용도

    @mFun.setter
    def mFun(self,x): #멤버 변수 x에게 지역변수 x가 값을 받아 전달 및 변경하는 UserMethod
        self.x = x #set의 용도


if __name__ == '__main__':
    a = My() #a라는변수 = My라는 클래스
    a.mFun = 100  #=int(100)
    print(a.mFun)
