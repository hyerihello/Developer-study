import urllib.request as req
from bs4 import BeautifulSoup
from konlpy.tag import Okt
from collections import Counter
import wordcloud
import matplotlib.pyplot as plt
from PIL import Image
import numpy as np

def Test01():
    list_review = []
    page_num, review_num = 1, 1
    while True:
        if page_num == 11:
            break
        url = "https://movie.naver.com/movie/bi/mi/review.nhn?code=187310&page={}".format(page_num)
        url = req.urlopen(url).read().decode("utf-8")
        soup = BeautifulSoup(url, "html.parser")
        all = soup.select("ul.rvw_list_area > li")
        for i in all:
            review = i.select_one("p > a").text.strip().replace("  ", "")
            print("리뷰", review_num, ": ", review)
            print()
            list_review.append(review)
            review_num += 1
        page_num += 1
    with open("review.txt", "w", encoding="utf-8") as f:
        f.writelines(list_review)
    with open("review.txt", encoding="utf-8") as f:
        result_total = f.read()
        okt = Okt()
        nouns_list = okt.nouns(result_total)  # 명사만 추출하여 리스트형으로 반환
        stopword = "미나리"
        for i in nouns_list:
            if len(i) == 1:
                nouns_list.remove(i)
            elif stopword in nouns_list:
                nouns_list.remove(stopword)
        cnt = Counter(nouns_list)
        print(cnt)
        img_list = np.array(Image.open("./tree.png"))
        img_color = wordcloud.ImageColorGenerator(img_list)
        cloud_image = wordcloud.WordCloud(font_path="./NanumGothic.ttf", background_color="white",
                                          mask=img_list).generate_from_frequencies(cnt)
        plt.figure(figsize=(10, 10))
        plt.imshow(cloud_image.recolor(color_func=img_color), interpolation="bilinear")
        plt.axis("off")
        plt.show()
if __name__ == '__main__':
    Test01()