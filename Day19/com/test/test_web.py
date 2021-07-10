# 중앙일보에서 인공지능을 검색 후 최근3개의 상세기사 url을 스크롤하자
# https://news.joins.com/article/24055226
# https://news.joins.com/article/24055193
# https://news.joins.com/article/24055000

from bs4 import BeautifulSoup
import urllib.request

def Test():
    list_url = "https://news.joins.com/search/?keyword=%EC%9D%B8%EA%B3%B5%EC%A7%80%EB%8A%A5"
    url = urllib.request.Request(list_url)
    result=urllib.request.urlopen(url).read().decode('utf-8')
    soup = BeautifulSoup(result,"html.parser")

    # 상세 기사를 가져올 수 있도록 태그와 클래스를 찾는다.
    result01 = soup.find_all('h2',class_="headline mg")
    print(result01)

'''
    # result01의 결과가 리스트, for loop문을 이용해서 요소를 꺼내고 href값을 리턴받자.
    for i in result01:
        for k in i :  #h2 태그에 이너요소인 a태그를 가져오기 위한 코드
            print(k.get("href"))
'''

def Test01():
    # 상세 기사의 본문 텍스트를 스크롤링 해서 출력해보자.
    list_url = "https://news.joins.com/article/24055226"
    url = urllib.request.Request(list_url)
    result = urllib.request.urlopen(url).read().decode('utf-8')
    soup = BeautifulSoup(result, "html.parser")

    # 상세 기사의 본문을 가져올 수 있도록 태그와 클래스 찾아보자
    # // *
    result1 = soup.find_all("div",class_='article_body mg fs4')
    #print(result1)
    params2 = []
    for i in result1:
        params2.append(i.get_text(" ",strip = True))
    print(params2)
if __name__ == '__main__':
    Test()