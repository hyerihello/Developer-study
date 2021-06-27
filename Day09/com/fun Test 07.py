# lambda 만들어보자
def add(x,y):
	res = x+y
	return(res)

hap = lambda x,y : x+y

if __name__ == '__main__':
    n = add(5,3)
    print(n)
    print(hap(5,3))
    print((lambda x,y,z : x*y*z)(1,2,3))
    print((lambda x,y : x+y)(5,3))


# 목록에 사용되는 람다 표현식
    r=['one', lambda x : x*x ,10]
    print(r[0], r[1](2),r[2])
    print(r) #r의 전체주소를 출력
