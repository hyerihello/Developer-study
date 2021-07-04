#파일의 임의접근을해보자

f= open("test.txt","r")
str = f.read() #전체 파일의 내용을 읽어서 리턴, read를 하면 마지막으로 커서옮김
print(str)
print("================================")
f.seek(0) #파일 포인터의 위치를 0으로 이동, 파일의 0번째 바이트로 이동
while(1):
    l=f.readline() #한줄씩 읽어서 리턴
    if(l):
        print(l ,end='\r') #출력을한다.
    else:
        break
print("================================")
f.seek(0)
ls=f.readlines() #전체 출력
print(ls[3][2], ls[3][4])
print(f.tell()) #마지막
print("================================")
f.seek(20)
print(f.read())
f.close()