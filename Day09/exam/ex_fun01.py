# ord('a'):unicord로 리턴, chr(97) 글자로리턴

# 숫자를 입력받아 getMych () 함수로 전달 하게 되면 영문자를 리턴하는 코드를 작성하자. 단 65-80까지만 받자
'''
def getMych(su):
    return chr(su) #내장함수 chr()을 이용해서 숫자를 영문자로 변환해서 리턴
'''
def repeat_msg(msg, repeat=3): #메세지 반복 출력 횟수 = 3
    for i in range(repeat):
        print(msg)


if __name__ == '__main__':
    '''
    su = int(input("input 65~80:"))
    res = getMych(su)
    print("su = %5d  res =%s"%(su,res)) # input 65~80:65 , su =    65  res =A
    '''

    repeat_msg("python")
    repeat_msg("spring", repeat=5)
