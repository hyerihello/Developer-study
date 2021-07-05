#
import pickle

sample = ['a',('b','c'),1,set([1]),3,['Dominica'],{'egg':2000},'감','惠']
sample01 = ['a',('b','c'),2,set([2]),4,['Dominica'],{'egg':3000}]
sample02 = ['a',('b','c'),3,'RuRi',set([3]),5,['Dominica'],{'egg':4000}]

with open('data','wb') as f:
    res = sample + sample01 + sample02
    pickle.dump(res,f)
    f.close() # 선택적 close X, with 문에서는 close()문을 호출하기 전에 False 경우 자동 호출되어 사용하지 않는다.

with open('data','rb') as f01:
    obj = pickle.load(f01)
    print(obj)