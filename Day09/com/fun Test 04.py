# 값을 리턴하는 함수를 만들어 보자.
def getA():
    return [1,2,3,4,5]

def getB():
    return (1,2,3,4,5)

def getC():
    return {'a':100,'b':200}

def getD():
    return 97.9,100,False # ,로 나열할때는 튜플로 리턴한다.

def getE():
    return [1,2,3,(4,5,6)]



if __name__ == '__main__':
    print("a=",getA()) #[1,2,3,4,5]
    print("b=",getB()) #(1,2,3,4,5)
    print("c=",getC()) # {'a':100,'b':200}
    print("d=", getD())  # 97.9 ,100
    print("e=", getE()) # [1,2,3,(4,5,6)]
    a1, b1,c1 = getD()
    print(a1,b1,c1, type(getD()))
    #ord('a'):unicord로 리턴, chr(97) 글자로리턴


