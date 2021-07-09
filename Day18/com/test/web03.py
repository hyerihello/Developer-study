from bs4 import BeautifulSoup
import urllib.request

#1. ebs 레이디 버그 시청자 게시판을 가지고 직접 크롤링 해보자.

def Test():
    list_url = "https://home.ebs.co.kr/ladybug/board/6/10059819/oneBoardList?hmpMnuId=106"
    url = urllib.request.Request(list_url)

    result = urllib.request.urlopen(url).read().decode('utf-8')
    # print(result) 전체문서출력

    soup = BeautifulSoup(result, "html.parser")
    result02 = soup.find_all('p', class_ = 'con')
    params =[]
    for i in result02:
        params.append(i.get_text(" ",strip = True))
        #print(i.get_text(" ",strip = True)) #약간 보기좋게
    print(params)

def Test02():
    # 2021.02.19 16:07 '와 진짜 만화 안보는데 이건 너무 좋아요~!!!\r\n어제 꿈에 나옴ㅋㅋㅋㅋㅋ
    list_url = "https://home.ebs.co.kr/ladybug/board/6/10059819/oneBoardList?hmpMnuId=106"
    url = urllib.request.Request(list_url)

    result = urllib.request.urlopen(url).read().decode('utf-8')
    # print(result) 전체문서출력

    soup = BeautifulSoup(result, "html.parser")
    result01 = soup.find_all('span', class_='date')
    result02 = soup.find_all('p', class_ = 'con')

    params1 = []
    for i in result01:
        params1.append(i.get_text(" ", strip=True))
        # print(i.get_text(" ",strip = True)) #약간 보기좋게

    params2 = []
    for i in result02:
        params2.append(i.get_text(" ", strip=True))
        # print(i.get_text(" ",strip = True)) #약간 보기좋게

    for k,h in zip(params1,params2):
        print(k+ ' ' + h)

if __name__ == '__main__':
    Test02()
