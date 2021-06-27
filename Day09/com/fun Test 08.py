# 고차함수 filter 를 써보자
# filter(function or None, iterable) → filter object


# 0~9 까지 값 중에서 짝수만 출력해 보자. filter
# 0,1,2,3,4,5,6,7,8,9 → 0,2,4,6.8

from functools import reduce
# reduce 함수 (결과값을 누적해서 연산)

'''
def even(x):
    return(x%2==0)
lis = range(10)

def filter_test():
   print(list(filter(lambda x : x%2==0, range(10))))

def map_test():
   print(list(map(lambda x : x%2==0, range(10))))
   print(list(map(lambda x: x*2, range(10)))) # 이 용도로 더 많이 쓰임

def reduce_test():
    print(reduce(lambda x, y: x+y,[1,2,3,4,5]))

#5를 입력해서 5+4+3+2+1 // 재귀함수
def sum_n(n):
    if n == 0:
        return 0
    else:
        return n + sum_n(n-1)
'''

s="Global"
m="Global_m"
def Test():
    s="my_Local" #지역변수
    print(s)
    my_test="my_test_Local"


if __name__ == '__main__':
    '''
    print(list(filter(even,lis)))
    filter_test()
    map_test()
    reduce_test()
    print(sum_n(5))
    '''
    Test()
    print(m)
