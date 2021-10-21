from flask import Flask, request, jsonify, make_response
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

# routiong


@app.route("/boot", methods=["GET", "POST", "PUT", "DELETE"])
def boot_test():
    if request.method == "GET":
        print("get, 요청입니다")
        info = request.args.get("email")
        print(info)
    if request.method == "POST":
        print("post, 요청입니다")
        data = request.get_json()  # post 일때는 객체이기 때문에 get_json
        print(data)  # 객체값이 나옴
        print(data['email'])  # 요소값이 나옴
    if request.method == "PUT":
        print('put, 요청입니다')
        data = request.get_json()
        print(data)
        print(data['email'])
    if request.method == "DELETE":
        print("delete, 요청입니다.")
        info = request.args.get("email")
        print(info)
    return make_response(jsonify({'status': True}), 200)


if __name__ == "__main__":
    app.run(host="127.0.0.1", port="7788")
