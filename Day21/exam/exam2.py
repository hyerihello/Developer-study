import requests
from bs4 import BeautifulSoup

def crawl():

    a=[]

    url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn"
    data = requests.get(url) #print(data)
    soup = BeautifulSoup(data, "html.parser")

    name = soup.find_all('div', class_="tit3")
    for i in name:
        a.append(i.get_text(" ", strip = True))

    print("조회순으로 보는 영화순위입니다 =>", a)
if __name__ == '__main__':
    crawl()




