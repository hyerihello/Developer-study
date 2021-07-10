#심심한그대 -> 아래 코드를 실행해보고 with문으로도 변경하기, main에서 함수 하나씩 호출
def Test():
    listdata = [2, 2, 1, 3, 8, 5, 7]; result = sorted(listdata) #리스트의 요소를 정렬한다.
    print(result) #[1,2,2,3,5,7,8]
    f = open("c:\\data\\mydata11.txt", "w") #mydata11.txt를 생성하겠다
    f.write(str(result)) #result에 있는 내용을 mydata11.txt로 생성한다.
    f.close() #result 에 있는 내용을 문자로 변환 해야한다.
def Test01(): #아래의 리스트를 mydata12.txt로 저장하시오!
    listdata2 = ['a','b','c','d','e','f','g']
    result = sorted(listdata2); print(result);
    f = open("c:\\data\\mydata12.txt", "w")
    f.write(str(result)); f.close()

def Test02():
    data = [] #data라는 비어있는 리스트 생성
    while True: #무한루프를 수행
        text = input('저장할 내용을 입력하세요')
        if text == '': # text에 아무것도 입력하지 않으면
            break #break 문을 실행해서 무한루프를 종료
        data.append(text + '\n') #text가 엔터와 함께 data 리스트에 append
    f = open('c:\\data\\mydata13.txt','w' ) #mydata13.txt 를 생성하겠다.
    f.writelines(data); f.close() #data 리스트의 내용을 mydata13.txt에 저장하겠다.
def Test03():
    '''
    바이너리 파일 복사하기(read,write)
    이미지나 동영상도 파이썬으로 복사 붙여넣기를 할 수 있다.
    이미지나 동영상을 복사 붙여넣기 할때는 파일의 크기가 크므로
    한번에 읽어들일 수는 없고 일부분만 일정한 크기도 읽으면서
    복사 붙여넣기를 한다. 
    '''
    bufsize = 1024 # 1kb 크기의 버퍼사이즈를 지정
    f = open("c:\\data\\apple.png",'rb') #rb는 read binary의 약자
    h = open("c:\\data\\apple_copy.png",'wb') #wb는 write binary의 약자
    data = f.read(bufsize)
    while data:
        h.write(data)
        data=f.read(bufsize)
    h.close()
    f.close()
if __name__ == '__main__':
    Test02()