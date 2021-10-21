import numpy as np
import pandas as pd
from pandas import DataFrame
from sklearn.model_selection import train_test_split

# 밑에서 weight값 저장하기 위한 모듈
# 파이썬에서 텍스트 이외의 자료형을 파일로 저장할때 필요한 모듈. dump() 사용된다.
import pickle
import seaborn as sns
from sklearn.svm import SVC

iris = sns.load_dataset('iris')
# print(iris.head())


X = iris[['sepal_length', 'sepal_width',
          'petal_length', 'petal_width']]  # 2차원 [[]] 사용
y = iris['species']  # target


# 모델 분류
x_train, x_test, y_train, y_test = train_test_split(X, y, test_size=0.2)

# 모델 생성
model = SVC()

# 모델 학습
model.fit(x_train, y_train)

# 이 부분을 해주면 된다.
# 모델의 학습결과 :: model = weight 값
pickle.dump(model, open('model.pkl', 'wb'))  # weight값이 저장됨, 확장자 pkl로 저장하기
