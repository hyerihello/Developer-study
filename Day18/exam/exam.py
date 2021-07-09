#심심한그대
import random
import numpy as np #과학계산을 위한 라이브러리로서 다차원 배열을 처리하는데  유용한 기능제공
tall = [129.3, 130.2, 132.5, 134.7, 136.3, 137.8, 138.1, 140.2, 142.3, 145.2]
def Test01():
    #초등학생 키가 10개가 들어있는 아래의 tall 리스트의 요소 10개를 10000개로 증가시켜서
    # tall 10000리스트에 담고 출력하시오, 모집단의 평균값, 분산, 표준편차를 출력
    tall10000 = tall * 10000
    print(tall10000)
    print(type(tall10000)) #<class 'List'>
    print(np.mean(tall10000)) #136.66 모집단의 평균
    print(np.var(tall10000)) #23.782399999999985 모집단의 분산
    print(np.std(tall10000)) #4. 모집단의 표준편차

def Test02(): #Test01()의 tall10000에서 표본을 20개 랜덤으로 추출한다면?
    a = []
    tall10000 = tall * 10000
    for i in range(1,21) :
        r= random.choice(tall10000)
        a.append(r)
    #표본 20개의 평균을 출력한다면?
    print(np.mean(a))

if __name__ == '__main__':
    Test02()