'''
Flask 웹 서비스 만드는 순서

    1. flask 모듈 import
    2. app 라는 이름으로 Flask 객체 생성
    3. app 라는 변수에 웹 서비스 기능을 추가
        - @app.route("/")
        - route란? 클라이언트 요청을 route로 받는다.
                Flask 서버에서 여러가지 url로 이동하기 위한 일종의 문법
    4. app를 run시킨다. 이 때 host, port를 지정한다.
        - http://www.daum.net --> 80 port가 돈다.
        - https://www.daum.net --> 443port가 돈다.
'''


# flask 라이브러리에서 Flask 함수 로딩한다.
# flask 라이브러리는 서버의 핵심적인 기능을 가지고 있는 모듈 -- Flask
from flask import Flask


# Flask 객체를 생성 -- 변수에 할당
app = Flask(__name__)  # 생성자
print(__name__)  # 해당 파일이 직접 호출 대상이라면 __main__이 출력된다.
print(app)  # 객체 호출


# 클라이언트에서 들어오는 요청을 받아들일 수 있어야 한다.
# app를 이용해서 라우팅 시킨다.
@app.route("/")  # /이렇게 요청이 들어온다 :: http://127.0.0.1:7777/
def index():
    return "<h1>INDEX PAGE</h1>"


# FLASK 서버를 가동시킨다
if __name__ == "__main__":
    app.run(host="0.0.0.0", port="7788")  # 서버호출 , "0.0.0.0" :: localhost
