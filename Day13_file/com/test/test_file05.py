# 파일을 readline() 메소드를 읽어보자.

print("======case1============readLine()")
f=open("data02.txt","r")
line = f.readline() #하나의 라인만 리턴받는다.
print(line)
f.close()


print("=======case2============readLine()")
f=open("data02.txt","r")
line = f.readline()
while line:
    print(line)
    line = f.readline()
f.close()


print("=======case3=============readLine()")
f=open("data02.txt","r")
while 1:
        line = f.readline()
        if not line:
            break
f.close()

print("=======case4=============readLine()")
f=open("data02.txt","r")
for line in f:
        print(line)
f.close()
