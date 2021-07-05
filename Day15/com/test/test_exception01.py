def excep_test01():
    try:
        r = 10/0 # 10/4도 해보기
        print(1111111)
    except ZeroDivisionError: #pvm에서 Error의 종류에 해당하는 클래스를 생성해서 리턴 되는 것을 except에서 해결한다.
        print("0으로 나눌려고 했잖아 !!")
    else:
        print("else")
    finally: #호출하지 않아도 반드시 실행한다.
        print(2222222) #파일, db등의 close() / 로그아웃
    print("=======main======")

def excep_test02():
    #try ~ else
    L = [1,2,3]
    try:
        num = L[4]
    except IndexError as IE: #IE는 변수
        print("Index Error :",IE, type(IE))
        # IE.with_traceback(sys.exc_info()[2]) #확인해볼 필요가 있다.
    else:
        print('keep calm and go ahead')

if __name__ == '__main__':
    excep_test01()
    excep_test02()