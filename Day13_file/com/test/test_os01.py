# 지정된 디렉토리가 가진 하위 목록과 파일의 크기 및 사이즈 생성 시간을 출력해보자
# join()를 사용해서 디렉토리와 파일을 조인해보자.
# os, time 모듈을 사용.
import os,time
import os.path

def Test01():
    print(os.listdir("c:\\")) # 지정한 디렉토리 내의 모든 파일과 디렉토리의 list리턴
    path = "c:\\Test" #지정된 디렉토리
    file_list = os.listdir(path)

    for file in file_list: #c:\\Test 하위 목록을 리턴받게 된다.
        file = os.path.join(path,file) #패스와 파일이름을 조인하게 된다. 경로를 병합하여 새 경로 생성
        print(file,os.stat(file).st_size, time.ctime(os.stat(file).st_mtime),os.stat(file).st_mtime)


def Test02():
    #파일 이름을 구성요소(디렉토리와 파일)로 구분할때는 os.path모듈을 사용
    #basename() -> split() 사용한다. os.path.normpath(".")
    file = "c:/Test/b.txt"
    if os.path.isfile(file):
        a = os.path.basename(file) #무조건 경로 끝에있는 파일링크, 폴더,파일 보여줌
        b = os.path.split(file) # 파일과 폴더 부분을 서로 잘라준다.
        c = os.path.normpath(file) #리눅스, 윈도우에서 경로로 인지한다, (디렉토리 포맷이 섞이거나 잘못써졌을때 고침)
        print(a)
        print(b)
        print(c)

if __name__ == '__main__':
    Test02()

