from requests import Request,Session

clientId = "IVWxZJNVjc_LkbdMJ8GM"
clientSecret = "c9M_2USPNa"
apiURL = "https://openapi.naver.com/v1/papago/n2mt"

s = Session()
text = "안녕하세요. 오늘 기분은 어떻습니까?"
data ={'source':'ko','target':'en','text':text,}
headers = {"X-Naver-Client-Id" : clientId, "X-Naver-Client-Secret": clientSecret }
req = Request('Post', apiURL, data=data, headers=headers) #페이지 header 값으로 요청을 하고 text 변환 코드를 전달
#서버가 가진 클라이언트가 접속할때 정보로 생성된 Session의 객체를 통해 값을 리턴받는다.
prepped = req.prepare() #1. 준비단계
res = s.send(prepped) #2. 세션을 통해 연결 고리를 만든다. 데이터 변환 코드 전송
#결과를 리턴받는다.

res_json = res.json()
print(res_json) #4. 결과를 출력한다.
print(res_json['message']['result']['translatedText'])