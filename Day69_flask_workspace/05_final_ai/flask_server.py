from flask import Flask, render_template, request, jsonify
import numpy as np
import pickle

# model.pkl 파일을 받아온다. (읽기)
model = pickle.load(open('model.pkl', 'rb'))

# 생성된 flask 기능을 app에 할당
app = Flask(__name__)


# 웹 서비스 추가


@app.route("/")
def home():
    return render_template('index.html')

# index.html 에서 <form action="predict" method="post"> 이랑 맞춰준다.


@app.route("/predict", methods=['POST'])
def predict():
    # post로 넘어오는 값이  .method 부분 전부 다 받는다 :: request.form.values() 함수사용
    # 배열로 들어오기 때문에 [] 안에 넣어주고 그것을 for문 사용한다.
    # 들어오는 값이 float 형식이기 때문에 형변환 함수 float(x) 를 앞에 써준다.
    init_feature = [float(x) for x in request.form.values()]
    # 예측할 때 사용하기 위해 numpy 배열로 변경해준다.
    final_feature = [np.array(init_feature)]

    # 예측값 :: prediction , 모델예측 :: model.predict
    prediction = model.predict(final_feature)

    # 결과를 index.html로 보낸다.
    # ginger문법 ::  prediction_text='Prediction Class {}'.format(prediction)
    return render_template("index.html", prediction_text='Prediction Class {}'.format(prediction))


if __name__ == '__main__':
    app.run(debug=True)
