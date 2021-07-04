#2진화 코드를 작성해보자 _class로 만들어보자
class BTest:
    def b_write(self):
        f = open("file_test01.txt","wb")
        f.write(b'ABC123') # b=1byte 이내 코드값 변환, ASCII, (확장형코드=scancode, unicode)
        f.close()


    def b_read(self):
        f = open("file_test01.txt","rb")
        while True:
            s = f.read(1)
            if s == b'':break;
            print(s.hex(), s)
        print(f.read())
        f.close()

if __name__ == '__main__':
    b1 = BTest() #기본생성자를 호출하면서 객체를 생성한다. __init__(self)
    b1.b_write()
    b1.b_read()