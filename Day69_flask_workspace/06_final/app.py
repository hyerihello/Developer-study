# from flask import Flask, render_template,   request, jsonify,
from flask import Flask, render_template,  request
import numpy as np
import pickle


model = pickle.load(open('model.pkl','rb'))
app = Flask(__name__)


@app.route('/') # Homepage
def home():
    return render_template('index.html')



@app.route('/predict',methods=['POST','GET'])
def predict():  
          
    sepal_len = request.form['sepal_length'] # Get parameters for sepal length
    sepal_wid = request.form['sepal_width'] # Get parameters for sepal width
    petal_len = request.form['petal_length'] # Get parameters for petal length
    petal_wid = request.form['petal_width'] # Get parameters for petal width
    print(sepal_len)
    
    arr=  np.array([[sepal_len,sepal_wid, petal_len, petal_wid ]])
    arr= arr.astype(np.float64)
    
    pred = model.predict(arr)
    
    return render_template("result.html", data=pred)
    
  

if __name__ =="__main__":
    app.run(debug=True)
