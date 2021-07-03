# class 코드를 변환해보자.
class MyFile:
    def __init__(self,mypath,str):
        self.mypath = mypath
        self.str = str

    def My_write(self):
        f=open(self.mypath,'w') #'a' 덮어쓰기
        f.write(self.str)
        f.close()

    def My_read(self):
        f=open(self.mypath,'r')
        print(f.read())
        f.close()

if __name__ == '__main__':
    str = '''mode is an optional string that specifies the mode in which the file
        is opened. It defaults to 'r' which means open for reading in text
        mode.  Other common values are 'w' for writing (truncating the file if
        it already exists), 'x' for creating and writing to a new file, and
        'a' for appending (which on some Unix systems, means that all writes
        append to the end of the file regardless of the current seek position).
        In text mode, if encoding is not specified the encoding used is platform
        dependent: locale.getpreferredencoding(False) is called to get the
        current locale encoding. (For reading and writing raw bytes use binary
        mode and leave encoding unspecified.) The available modes are:'''

    mypath = "c:\\test\\data.txt"

    m1 = MyFile(mypath, str) #생성자 호출
    m1.My_write()
    m1.My_read()