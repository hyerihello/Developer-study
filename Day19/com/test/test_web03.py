from bs4 import BeautifulSoup
import urllib.request
from collections import Counter

# 레이디버그 게시판에서 다운로드 받았던 내용 중에서 가장 많이 나오는 단어(어절)은 무엇일까?

def Test():
    res = open("mytest.txt", encoding='UTF8')
    res02 = res.read().split() #어절별로 분리해서 리스트로 리턴한다.
    # print(res02)
    res02.sort() #리스트 안의 요소들을 정렬

    countlist = Counter(res02) #res02 리스트안에 어절별로 각각 몇건씩 있는지 계산
    print(countlist)

    result=countlist.most_common(30)
    print(result)

    for i in result:
        print(i[0],i[1])

if __name__ == '__main__':
    Test()