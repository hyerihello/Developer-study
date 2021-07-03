# 함수로 코드를 변환해보자.

def My_write(str,mypath):
    f=open(mypath,'w')
    f.write(str)
    f.close()
def My_read(mypath):
    f=open(mypath,'r')
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
    My_write(str,mypath)
    My_read(mypath)