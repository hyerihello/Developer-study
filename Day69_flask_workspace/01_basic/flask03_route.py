# 라우팅 심화 -- Vue의 Axios 기술과 연결
# 클라이언트 비동기 요청시 변수로 값 전달

from flask import Flask


app = Flask(__name__)


@app.route("/")
def index():
    return "<h2>Index page</h2>"

# ---1. string
# http://127.0.0.1:7788/emps/hyeri


@app.route("/emps/<empid>")  # <empid> 값을 전달, string이 기본타입이다.
def get_employee(empid):
    return "<h3>Employee ID :: " + empid + "</h3 >"


# ---2. int
def annualSalary(amount):
    return amount * 12 + 12000


@app.route("/emps/<int:sal>")
def get_salary(sal):
    totalSalary = annualSalary(sal)
    return "<h3>%d</h3>" % (totalSalary)

# url에 실수형을 변수로 전달할 때는 :: float:sal, %f 로 변경해주면 된다


if __name__ == "__main__":
    app.run(host="127.0.0.1", port="7788")
