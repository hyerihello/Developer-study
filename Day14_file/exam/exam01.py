import os
#함수 하나씩 메인에서호출하세요 <<심심한그대>>
def myTest():
    #c:/MyTest/My_dir 하위에 a,b,c 세개의 디렉토리를 만들고 실행
    for root, dirs, files in os.walk('c:/MyTest/my_dir',topdown=False):
        # os.walk 하위디렉토리 탐색
        for dir in dirs:
            olddir = os.path.join(root,dir)
            newdir = os.path.join(root,dir + '_new')
            os.rename(olddir,newdir) #폴더명변경
            print(os.path.normpath(newdir))

def myTest02():
    for k, v in os.environ.items():
        print("%s = %s" % (k, v))
    print("===================================")
    print(os.environ.get("windir"))

def myTest03():
    #어디에 파일을 가져올까요? 코드 생각해보고 하위 파일 및 디렉토리 탐색기에서 만들어서 실행
    for root, dirs, files in os.walk('c:/MyTest/my_dir'):
        dirs [:] = (dir for dir in dirs if dir != 'b_new')
        for res in files:
            print(os.path.join(root,res))

if __name__ == '__main__':
    print(myTest())