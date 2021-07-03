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

f = open("data.txt",'w') #현재 패키지 com.test 하위에 data.txt파일을 쓰기전용으로 생성 후 내용 저장
f.write(str)
f.close()

f = open("data.txt",'r') #읽기
print(f.read())
f.close()

