# 피클링 작업을 해보자
'''
try:
    import cPickle  ->임포트 cPickle
    pickle = cPickle  ->pickle로 대입한다. 대입시 cPickle이 없다면 프로그램은 중단이 되기때문에
    except로 이동
except:
    import pickle 임포트 ->cPickle

'''
import pickle
book = {'java':30000, 'jsp':35000,'oracle':40000, 'python':20000}
list=["abcd",90,90.8]
Tuple = (book,list)
print(Tuple)

f = open('ptest.txt','wb')
pickle.dump(Tuple,f) #파일에 객체를 저장 pickle.dump(data,file)
f.close()


f = open("ptest.txt",'rb')
res01, res02 = pickle.load(f)
print(res01)
print(res02)

