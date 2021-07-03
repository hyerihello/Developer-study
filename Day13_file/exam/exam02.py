# int,float, str, list, tuple, dict
# 연산자 (오칙연산자, 비교연산자 비트연산자, in, not in , is, not is )
# 제어문, (if, while, for + else) , continue, break, return
# def username(일반변수, 초기화 일반변수, * tulple변수, ** dict(변수):명령;
# 객체화 -> class -> 인스턴스
## exam : 주사위를 10번정도 던져서 출력되는 눈을 확인해보자.
import random

def Prn():
    #동전을 던져서 앞면이 나오는지 뒷면이 나오는지 확인해보자
    coin=['앞면','뒷면']
    print(random.choice(coin))
def Prn01():
    # exam : 주사위를 10번 던져서 출력되는 눈을 확인해보자.
    dice = [1,2,3,4,5,6]
    for i in range(1,11): # 1이상 11미만 출력
        print(i, '번째는 ', random.choice(dice))
def Prn02():
    # 동전을 10번 던져서 앞면이 나오는지 뒷면이 나오는지 확인해보자
    coin = ['앞면', '뒷면']
    for i in range(1, 11):
        print(i, '번째는 ', random.choice(coin))
def Prn03():
    # 동전을 10번 던졌을 때 앞면이 나오는 횟수가 어떻게 되는가
    coin = ['앞면', '뒷면']
    cnt = 0
    for i in range(1, 11):
        result = random.choice(coin)
        if result == '앞면':
            #cnt = cnt + 1
            cnt += 1
    else:
        print(cnt)
def Prn04():
    # 주사위를 100번 던져서 주사위를 눈이 3이나오는 횟수를 출력하자.
    dice = [1, 2, 3, 4, 5, 6]
    cnt = 0
    for i in range(1, 101):
        result = random.choice(dice)
        if result == 3:
            cnt += 1
    else:
        print(cnt)
def Prn05():
    # 주사위를 1000번던지고 주사위의 눈이 5가나올 확률을 구하시오
    dice = [1, 2, 3, 4, 5, 6]
    cnt = 0
    for i in range(1, 1001):
        result = random.choice(dice)
        if result == 5:
            cnt += 1
    else:
        print("확률 : " , cnt/1000)
def Prn06():
    # 주사위를 10번 던졌을 때 짝수가 나오는 횟수 (8 % 2 : 8을 2로 나눈 나머지)
    dice = [1,2,3,4,5,6]
    cnt = 0
    for i in range(1,11):
        result = random.choice(dice)
        if result % 2 == 0: #주사위의 눈이 짝수이면
            cnt += 1
    else:
        print(cnt)
def Prn07(): #Prn06()의 확장문제
    # 주사위를 10번 던졌을 때 짝수가 나오는 횟수를 확인하는 작업을
    # 5번 반복해서 짝수가 나오는 횟수가(5개)가 나오게 하시오
    # -> 주사위를 10번 던졌을 때 짝수가 나오는 횟수를 5번 확인하시오
    for j in range(1,6):
        dice=[1,2,3,4,5,6]
        cnt = 0
        for i in range (1,11):
            result = random.choice(dice)
            if result % 2 == 0:
                cnt += 1
        else:
            print(cnt)
def Prn08():
    # 동전을 100번 던져서 앞면이 나올 확률
    coin = ['앞면', '뒷면']
    cnt = 0
    for i in range(1,101):
        result = random.choice(coin)
        if result == '앞면':
            cnt += 1
    else:
        print("확률 :", cnt/100)
def Prn09():
    # 두개의 동전을 300번 던져서 동시에 둘다 앞면이 나오는 횟수를 출력
    coin1 = ['앞면','뒷면']
    coin2 = ['앞면','뒷면']
    cnt = 0

    for i in range(1,301):
        result1 = random.choice(coin1)
        result2 = random.choice(coin2)
        if result1 == '앞면' and result2 == '앞면':
            cnt +=1
    else:
        print(cnt)
def Prn10():
    #주사위 2개를 동시에 던졌을 때 두개의 주사위의 눈의 합을 구하는 실행문을 1000번
    #반복해서 합의 결과를  list 객체에 저장하자
    #단 while 문을 사용하자.
    dice1 = [1,2,3,4,5,6]
    dice2 = [1,2,3,4,5,6]
    x = 0
    a = []
    while x < 1000 :
       result1 = random.choice(dice1)
       result2 = random.choice(dice2)
       a.append(result1+result2)
       x += 1
    else:
        print(a)
        print(len(a)) # 요소의 갯수를 확인
def Prn11():
    # 두개의 주사위의 합이 10이 되는 확률을 구하시오. 단 1000번을 던졌을때 while문 구해보자
    # for 로도 변경해서 풀어보기!
    dice = [1,2,3,4,5,6]
    x = 0
    a = []
    while x < 1000:
        result1 = random.choice(dice)
        result2 = random.choice(dice)
        hap = result1 + result2
        if hap == 10:
            a.append(hap)
        x += 1
    else:
        print(a)
        print(len(a)/1000)  # 요소의 갯수를 확인
def Prn12():
    #주사위를 20번 던져서 주사위의 눈이 4 이상 나오는 횟수를 출력하시오
    dice = [1, 2, 3, 4, 5, 6]
    a = 0
    for i in range(1, 21):
        result = random.choice(dice)
        if i > 4:
            a += 1
    else:
        print(a)

def Prn13(): #제출
    # 동전한개와 주사위 한개를 동시에 100번 던져서 동전이 앞면이나오고 주사위의 눈이 5가
    # 나오는 횟수를 출력을 50번 하자
    coin = ["앞면", "뒷면"]
    dice = [1, 2, 3, 4, 5, 6]
    cnt = 0
    for i in range(1, 101):
        result1 = random.choice(coin)
        result2 = random.choice(dice)
        if result1 == "앞면" and result2 == 5:
            cnt += 1
    else:
        print(cnt)


if __name__ == '__main__':

    Prn()
    Prn01()



