import os
def showDir(path):
    print("======================")
    for dirpath, dirnames, filenames in os.walk(path):
        for dirname in dirnames:
            print(os.path.join(dirpath, dirname))

if __name__ == '__main__':
    filepath = "c:/TEST"
    if os.path.exists(filepath):
        print("지정된 경로에 파일 또는 디렉토리가 존재하고 있습니다")
        if os.path.isfile(filepath):
            print("파일이 존재합니다")
        if os.path.isdir(filepath):
            print("디렉토리가 존재합니다.")
    else:
        print("존재하지 않습니다.")

    tmpdir = "c:/Test"
    os.mkdir(tmpdir)
    os.makedirs("c:/Test/python/tmp/mkdir1/mkdir2/mkdir3")
    showDir(tmpdir)