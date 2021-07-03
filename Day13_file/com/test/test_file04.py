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

with open("data02.txt",'w') as f:
    f.write(str)

with open("data02.txt",'r') as f:
    print(f.read())

with open("data02.txt", 'r') as f:
    print(f.readline()) #한 줄씩 읽을때 사용

with open("data02.txt", 'r') as f:
    print(f.readlines()) # 한 줄, 한 줄이 list의 객체로 []안에 들어감
print("========================")



f = open("data02.txt", 'r'); #파일 열기
while True:
    print(f.readline())
    break