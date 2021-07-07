#심심한그대 -> main 만들어서 함수 각각 호출해봅니다.
import random
def Test():
    #1. 몬테카를로 알고리즘을 이용해서 원주율의 근사값을 파이썬으로 구하세요.
    print(random.uniform(0,1)) #0~1 사이의 난수를 출력
    cnt = 0
    for i  in range (1,10001): #10000번 루프를 돌리는데
        result1 = random.uniform(0,1) #0~1 사이의 난수를 result1 대입
        result2 = random.uniform(0,1) #0~1 사이의 난수를 result2 대입
        if (result1**2) + (result2 ** 2) <= 1: #부채꼴안의 점이라면
            cnt = cnt +1
    print(cnt/10000*4)
def Test01():
    # 2. 복소수는 실수부와 허수부로 되어있고 허수부는 숫자뒤에 문자 i
    # 파이썬에서는 j를 사용한다. ex: c1 = 1(실수부) + 7j(허수부)
    c1 = 1 + 7j
    print(c1.real) #복소수형 자료에서 실수부만 취한다.
    print(c1.imag) #복소수형 자료에서 허수부만 취한다.
    c2 = complex(2,3) #실수부가 2이고 허수부가 3인 복소수를 만든다.
    print(c2, type(c2)) #(2+3j)

if __name__ == '__main__':
    Test01()