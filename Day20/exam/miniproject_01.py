# 영며들다: 영아쌤에게 스며들다..
from bs4 import BeautifulSoup
import urllib.request as req
import urllib.parse as par
import requests
import os
def Coupang(x, y, z):
    search = x
    rating_num = y
    review_num = z
    encoded = par.quote(search)
    if not os.path.exists("./coupang_img"):
        os.mkdir("./coupang_img")
    pg_num = 1
    row_num = 1
    while True:
        if pg_num == 11:
            break
        url = "https://www.coupang.com/np/search?q={}&channel=user&component=&eventCategory=SRP&trcid=&traid=&sorter=scoreDesc&minPrice=&maxPrice=&priceRange=&filterType=&listSize=36&filter=&isPriceRange=false&brand=&offerCondition=&rating=0&page={}&rocketAll=false&searchIndexingToken=1=4&backgroundColor=".format(
            encoded, pg_num)
        code = requests.get(url, headers={"User-Agent": "Mozilla/5.0"})
        soup = BeautifulSoup(code.text, "html.parser")
        all = soup.find_all("li", class_="search-product")
        for i in all:
            name = i.find("div", class_="name")
            rating = i.find("em", class_="rating")
            review = i.find("span", class_="rating-total-count")
            link = i.find("a")
            img = i.find("img", class_="search-product-wrap-img")
            if rating:
                rating_f = rating.get_text(" ", strip=True)
            else:
                continue
            if review:
                review_f = review.get_text(" ", strip=True).replace("(", "").replace(")", "")
            else:
                continue
            if float(rating_f) >= float(rating_num) and float(review_f) >= float(review_num):
                name_f = name.get_text(" ",strip = True)
                print("[", pg_num, "페이지", "]")
                print("상품명 :", row_num, name_f)
                print("평점 :", rating_f)
                print("리뷰수 :", review_f)
                link_f = "https://www.coupang.com" + link["href"]
                print("링크 :", link_f)
                print("===============================================================")
                img_f = "https:" + img["src"]
                if ".gif" in img_f:
                    img_f = "https:" + img["data-img-src"]
                req.urlretrieve(img_f, "./coupang_img/{}.jpg".format(row_num))
                row_num += 1
        pg_num += 1
if __name__ == '__main__':
    Coupang(input("어떤 상품을 원하니>>"), input("평점 몇 점 이상을 원하니>>"), input("리뷰수 몇 개 이상을 원하니>>"))