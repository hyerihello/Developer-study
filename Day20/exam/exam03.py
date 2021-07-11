# 파파고에서 어플리케이션을 등록하고 id와 pw를 받아서 한글문서로 번역해서 영어문서로 저장해보자.

from requests import Request,Session

clientId = "IVWxZJNVjc_LkbdMJ8GM"
clientSecret = "c9M_2USPNa"
apiURL = "https://openapi.naver.com/v1/papago/n2mt"

s = Session()
headers = {"X-Naver-Client-Id" : clientId,
           "X-Naver-Client-Secret": clientSecret }

file = open("mydata.txt", "r", encoding ='utf-8')
file_out = open("mydata_res.txt", "w", encoding ='utf-8')
while True:
    line = file.readline() # 한글 파일 한줄 읽어서
    data ={'source':'ko','target':'en','text':line}
    if not line:
        break
    print(line)
    file_out.write(line)  # 한글 한줄 쓰고
    req = Request('Post', apiURL, data=data, headers=headers) #페이지 header 값으로 요청을 하고 text 변환 코드를 전달
    prepped = req.prepare() #1. 준비단계
    res = s.send(prepped)
    res_json = res.json()
    print(res_json)
    try:
        translate = res_json['message']['result']['translatedText']
        print(translate)
        file_out.write(str(translate) + "\n") # 번역된 글자 쓰고
    except:
        pass
file_out.close()
file.close()