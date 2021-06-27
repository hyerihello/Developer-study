#함수의 가변 인자 값 전달
'''
def test(*args):
    print(args,type(args))

'''
def my_fun(a,*args,**kwargs): # a는 일반변수, args는 튜플, kwargs 딕셔너리
    print("a=",a)
    print("args=",args)
    print("kwargs=",kwargs)

if __name__ == '__main__':
    '''
    test((1,2,3,4,5))
    test([1,2,3,4,5])
    test("1,2,3,4,5")
    '''
    my_fun(11) # a=11, args=(), kwargs={}
    my_fun(11,22,33,44,55) # a-11, args=(22,33,44,55), kwarg={}
    my_fun(11, 22, 33, 44, 55,id='a123',pw='1234') # a-11, args=(22,33,44,55) , kwargs= {'id': 'a123', 'pw': '1234'}


