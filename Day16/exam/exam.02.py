# sum() 내장함수를 사용해보자.
import string #문자열에 대해 다양한 연산을 위함

def Test01():
    #1. list 객체의 요소의 합을 출력하자
    listdata = [2,2,1,3,8,4,3,9,2,20]
    result = sum(listdata)
    print(listdata)
    print(result)
    print("=========================")
def Test02():
    #2. 짝수번째 요소의 합을 출력해보자
    listdata = (2, 2, 1, 3, 8, 4, 3, 9, 2, 20)
    result = listdata[1::2] #1부터 마지막까지 출력, 2의배수만
    print(listdata[1::2])
    print(sum(result))
    print("=========================")
def Test03():
    a = [2,1,5,6,7,9,10,3]
    result = sum(range(1,11)) -sum(a) # 1~10의 sum = 55, - sum(a)
    print(result)
    print("=========================")
def Test04(): #list 요소가 진리값(all,any) // all() = And,And ,,,  any() = or,or ,,,
    '''
     True = 1 , False = 0
     all(): 인자로 입력되는 리스트의 모든 요소가 참일경우만 True, 거짓이 하나라도 있으면 False를 리턴
     any(): 인자로 입력되는 리스트의 모든 요소가 거짓인 경우만 False, 참이 하나라도 있으면 True 리턴
    '''
    listdata1 = [True, True, True]
    listdata2 = [True, False, True]
    print(all(listdata1))  # True
    print(all(listdata2))  # false
    print(any(listdata1))  # True
    print(any(listdata2))  # True
    print("=========================")
def Test05():
    listdata1 = [1, 1, 1]
    listdata2 = [1, 0, 1]
    print(all(listdata1))  # True
    print(all(listdata2))  # false
    print(any(listdata1))  # True
    print(any(listdata2))  # True
    print("=========================")
def Test06():
    #문자코드구하기 (ord) :문자를 컴퓨터가 인식하는 코드값으로 변환 A(사람)---인코딩---->65(컴퓨터)
    print(ord('A'))
    # 알파벳 대문자를 출력해보자.
    print(string.ascii_uppercase, type(string.ascii_uppercase)) #A~Z
    print(string.digits) # 0~9
    print("영문자 대문자를 코드값으로 바꿔보자")
    for i in string.ascii_uppercase:
        print(i,"----------->", ord(i))
    print("=========================")
def Test07():
    print("영문자 소문자를 코드값으로 바꿔보자, string 모듈과 ord()함수를 사용하자 ")
    print(string.ascii_lowercase,type(string.ascii_lowercase))
    for j in string.ascii_lowercase:
        print(j, '----------->', ord(j))
    print("=========================")
def Test08(): #chr()인자로 정수를 입력하게 되면 정수값에 해당하는 문자를 리턴한다.
    '''
    65 ------------> A
    ...
    90 ------------> Z
    '''
    print(chr(65))
for i in range(65,91):
    print(i, '-------------->', chr(i))

if __name__ == '__main__':
    Test08()
