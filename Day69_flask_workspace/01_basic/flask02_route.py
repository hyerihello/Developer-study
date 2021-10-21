from flask import Flask

app = Flask(__name__)


@app.route("/")
def index():
    return "<h1>index..</h1>"


@app.route("/hello")
def flask_hello():
    return "<h3>Hello Flask..!!</h3>"


if __name__ == "__main__":
    app.run(host="127.0.0.1", port="7788")
# ctrl + c 로 서버 끄고 다시 돌려야함
# url 나오면 ctrl + 클릭 해서 확인, /hello치면 다른 페이지 뜸
