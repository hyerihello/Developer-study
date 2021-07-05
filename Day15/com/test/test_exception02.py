import traceback
# 예외를 처리하는 방법 중 하나,
# 예외가 발생한 후 프로그램의 stack trace를 출력하는데 사용
# traceback에는 오류메세지, 오류를 일으킨 줄번호, 오류까지 이어지는 함수호출순서를 나타내는 호출 스택이 들어가있음
def f1(a,b):
    return f2(a)+f2(b)

def f2(x):
    return 1.0/x

if __name__ == '__main__':
    try:
        f1(1.0,0.0)
    except:
        traceback.print_exc()
    '''
    except(ZeroDivisionError, IOError):
        traceback.print_exc()
        '''
