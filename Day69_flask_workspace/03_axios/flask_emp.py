from flask import Flask, request, make_response, jsonify
from flask_cors import CORS

app = Flask(__name__)
CORS(app)


@app.route("/emps", methods=['GET'])
def get_emps():

    return jsonify(
        [
            {"id": 1, "name": "James", "mailid": "sky98", "start_date": "1990-03-03", "manager_id": 0,
                "title": "사장", "dept_id": 118, "salary": 5000.0, "commission_pct": 0.0},
            {"id": 2, "name": "Peter", "mailid": "2xxsig", "start_date": "1990-03-08", "manager_id": 1,
                "title": "기획부장", "dept_id": 110, "salary": 3000.0, "commission_pct": 0.0},
            {"id": 3, "name": "Scott", "mailid": "ch21175", "start_date": "1991-06-17", "manager_id": 1,
                "title": "영업부장", "dept_id": 102, "salary": 3500.0, "commission_pct": 0.0},
            {"id": 4, "name": "Tiger", "mailid": "mquickto", "start_date": "1990-04-07",
                "manager_id": 1, "title": "총무부장", "dept_id": 101, "salary": 3000.0, "commission_pct": 0.0},
            {"id": 5, "name": "Tomson", "mailid": "aropebur", "start_date": "1990-03-04",
                "manager_id": 1, "title": "인사부장", "dept_id": 118, "salary": 3200.0, "commission_pct": 0.0},
            {"id": 6, "name": "Brion", "mailid": "murguhar", "start_date": "1991-01-18",
                "manager_id": 2, "title": "과장", "dept_id": 110, "salary": 2400.0, "commission_pct": 0.0},
            {"id": 7, "name": "Somin", "mailid": "enchu", "start_date": "1990-05-14",
                "manager_id": 2, "title": "과장", "dept_id": 111, "salary": 2400.0, "commission_pct": 0.0}
        ]
    )


if __name__ == '__main__':
    app.run(host="0.0.0.0", port="7777")
