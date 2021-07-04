#2진화 코드를 작성해보자 _class로 만들어보자
class BTest:

    def b_write(self):
        f = open("file_test01.txt","wb")
        str = '대한민국 우리나라'
        f.write(bytes(str,'utf-8')) #str을 utf-8로 변환
        f.close()


    def b_read(self):
        f = open("file_test01.txt","rb")
        while True:
            s = f.read(1)
            if s == b'':break;
            print(s.hex(), s)
        f.close()


    def b_mread(self): #다시 decoding 하기
        with open("file_test01.txt","rb") as f:
            print(f.read().decode('utf-8'))

        '''
        m = str(f.read().decode('utf-8')
        print(m)
        
        y = str(s,'utf-8')
        y
        
        '''

if __name__ == '__main__':
    b1 = BTest() #기분생성자를 호출하면서 객체를 생성한다. __init__(self)
    b1.b_write()
    b1.b_read()
    b1.b_mread()