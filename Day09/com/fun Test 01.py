def prn(): #def라는 키워드를 이용해서  prn() 사용자 함수를 선언
    print("hello python")

def prn02(): #def라는 키워드를 이용해서 prn02() 사용자 함수를 선언
    return "hello python_02" #prn02() 함수를 종료하면서 "hello python" 라는 문자열을 리턴





if __name__ == '__main__':
    prn() #"hello python"
    res = prn02() # res = "hello python_02"
    print(res)

