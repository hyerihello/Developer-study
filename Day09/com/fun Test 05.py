# 매개인자 값을 받는 함수를 호출해보자.
# ord('a'):unicord로 리턴, chr(97) 글자로리턴

'''
def getA(a): #a=100
    print("a=",a, type(a))


def getB(a, test=3): #호출할 떄 값을 주지 않아도 초기값으로 대입되어 명령을 수행하겠다.
    print("a=", a , "test =",test)
'''

def getC(a,b,c=1,d=2):
    print(a,b,c,d)


if __name__ == '__main__':
    '''
    getA(97.9)
    getA((1,2,3,4,5))
    getA([1,2,3,4,5])
    getA("abcdef")

    
    getB(100) #100은 a변수로 전달되고 test=3 초기값으로 대입되어 실행된다. a=100 test=3
    getB(1,2)
    getB(1,test="abcd")
    getB(1,"abcd")
    getB(test='abc', a=4)
    '''

    getC(a=100,d=200,b=400,c=500)



