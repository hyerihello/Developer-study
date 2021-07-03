str='''In text mode, if encoding is not specified the encoding used is platform
    dependent: locale.getpreferredencoding(False) is called to get the
    current locale encoding. (For reading and writing raw bytes use binary
    mode and leave encoding unspecified.) The available modes are'''

f = open("hyeri_01.txt","w")
f.write(str)
f.close

print("**case1**readline()")
f = open("hyeri_01.txt","r")
line = f.readline()
print(line)
f.close()

print("**case2**readline()")
f = open("hyeri_01.txt","r")
line = f.readline()
while line:
    print(line)
    line = f.readline()
f.close()

print("**case3**readline()")
f = open("hyeri_01.txt","r")
while 2:
    line = f.readline()
    if not line:
        break
f.close()

print("**case4**")
f = open("hyeri_01.txt","r")
for line in f:
    print(line)
f.close()
