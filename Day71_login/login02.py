from flask import Flask, request, render_template, jsonify


app = Flask(__name__, static_url_path="/static")


@app.route('/')
def index():
    # html 파일은 templates 폴더에 위치해야 하고.. 이런 정적인 문서를 render_template()
    return render_template("index2.html")


@app.route("/login")  # 라우팅 경로설정
def login():  # login으로 요청이 들어오면 login() 함수가 실행됨
    '''
    1. form 값 받아서 
    2. DAO 생성하고
    3. DAO 메소드 호출 , 디비 갔다 왔다 데이터 리턴 받고
    4. 데이터를 응답한다.
    '''
    user_id = request.args.get("user_id")
    user_pw = request.args.get("user_pw")
    user_address = request.args.get("user_address")

    if user_id == 'kery':
        user_data = {'id': user_id, 'pass': user_pw, 'address': user_address}
    else:
        user_data = {'id': 'fail'}

    return jsonify(user_data)


if __name__ == '__main__':
    app.run(host="127.0.0.1", port='7788')
