# with ~ as 파일 입출력


def my_write():
    with open("data.txt","w") as f: #f는 별칭
        for i in range(1,10): #1~9
            str = " %3d * %3d = %3d \n "%(2,i,2*i)
            f.write(str)

def my_read(): #read(size), readline(), readlines() ->[]
    with open("data.txt","r") as f:
        print(f.read())


if __name__ == '__main__':
    my_write()
    my_read()
