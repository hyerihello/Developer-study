#모듈활용하기
from collections import defaultdict
# 컨테이너데이터형 / 누락된 값을 호출하기 위한 함수

def Test01():
    artist = ['비틀즈','비틀즈','아이유','아이유','마이클잭슨','마이클잭슨']
    music = ['yesterday','imagine','너랑나','마슈멜로우','beat it', 'smooth criminal']
    gini = defaultdict(list) #기본 dict를 만들어서 ()객체를 key로 생성하고 value를 추가로 dict로 만드는 과정
    for i, k in enumerate(artist):
        gini[k].append(music[i])

    print(gini,"\n", type(gini))
    print("=========값 추출========")
    for i in gini.values(): #key 제외한 value 값 추출
        print(i)


def Test02():
    artist = ['비틀즈', '비틀즈', '아이유', '아이유', '마이클잭슨', '마이클잭슨']
    music = ['yesterday', 'imagine', '너랑나', '마슈멜로우', 'beat it', 'smooth criminal']
    gini = defaultdict(list)
    for i, k in enumerate(artist):
        gini[k].append(music[i])
    for j in gini.values():
        print(j[0]) # 인덱스 0번지 값 추출


if __name__ == '__main__':
    Test01()
    Test02()