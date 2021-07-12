'''
(1) 웹크롤링을 하기위해 필요한 라이브러리에는 무엇이있는지,
왜 그 라이브러리를 사용해야 하는지 작성
1-1 : from bs4 import BeautifulSoup

2-1 : <div class="tit3">

'''
import requests
from bs4 import BeautifulSoup

def crawl(url):

    data = requests.get(url) #print(data)
    return data.content

def parse(pageString):
    bsObj = BeautifulSoup(pageString, "html.parser")
    # ////  name 변수 = BeautifulSoup을 파싱해 데이터 긁어오기 /////

    name = bsObj.find_all('div', class_="tit3")
    content = []
    for i in name:
        content.append(i.get_text(" ", strip = True))

    return content #리턴을 꼭 넣고 출력한다.

if __name__ == '__main__':

    url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn"
    pageString = crawl(url)
    print("조회순으로 보는 영화순위입니다 =>",'\n', parse(pageString))
