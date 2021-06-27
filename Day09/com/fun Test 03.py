# 함수를 호출해서 값을 리턴 받아보자.

def getIntsu():
    return 100

if __name__ == '__main__':
    # 출력 함수인 print가 바로 getIntsu() 함수를 호출 후 100을 리턴받아 출력
    print("Intsu :", getIntsu()) #print("Intsu :", 100)

    #res라는 변수로 getInsu() 함수를 호출 후 100을 리턴받아 출력
    res = getIntsu() # res = 100
    print("res =",res)




