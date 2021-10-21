from flask import Flask, request, render_template, jsonify


# flask 정적 파일의 경로를 static으로 잡아두었다 라는 뜻
app = Flask(__name__, static_url_path="/static")


@app.route("/")
def index():
    return render_template("index.html")


@app.route("/login")
def login():

    user_id = request.args.get("user_id")
    user_pw = request.args.get("user_pw")
    user_address = request.args.get("user_address")

    if user_id == "kery":
        user_data = {'id': user_id, 'pass': user_pw, 'address': user_address}
    else:
        user_data = {'id': 'fail'}

    # 나중에 flask를  REST API로 다룰 때는 json 리턴
    return jsonify(user_data)
    # return user_data


if __name__ == "__main__":
    app.run(host="127.0.0.1", port="7788")
