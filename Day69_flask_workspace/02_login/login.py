# request 모듈을 추가한다.
# 실제 웹 화면과 서버를 연결하려면 화면의 모든 요청정보를 담고 있는 request모듈을 import해야한다.
from flask import Flask, request, render_template

# flask 정적 파일의 경로를 static으로 잡아두었다 라는 뜻
app = Flask(__name__)


# 정적인 페이지를 리턴하도록 랜더링한다. render_template
@app.route("/")
def index():
    # html 파일은 templates 폴더에 위치해야하고 이런 정적인 문서를 render_template()
    return render_template("login.html")


@app.route("/login")  # 라우팅 경로 설정
def login():  # login으로 요청이 들어오면 login() 함수가 실행됨
    '''
    controller 기능
    1. 폼값받는다.
    2. DAO 생성
    3. DAO 메소드 호출 -- DB 전달, 리턴받는다.
    4. 데이터 응답    
    '''

    user_id = request.args.get("user_id")  # form의 이름 ("user_id")를 넣고 값을 리턴받는다.
    user_pw = request.args.get("user_pw")
    print(user_id, user_pw)

    # DB 연결되어서 들어갔다 다시 나왔다고 생각해보자
    if user_id == "kery":
        user_data = {'id': 'kery', 'pass': 1234, 'address': 'SFO'}
    else:
        user_data = {'id': 'fail'}

    return user_data


if __name__ == "__main__":
    app.run(host="127.0.0.1", port="7788")
