#csv 모듈을 이용한 파일을 구현해 보자.
import csv

def csv_reader():
    f=open("data04.csv","rt")
    try:
        reader = csv.reader(f) #list객체
        for row in reader:
            print(row)
    finally:
        f.close()

def csv_reader02():
    #dict로 csv를 읽어보자.
    f=open("data04.csv","rt")
    try:
        reader = csv.DictReader(f) #dict타입
        for row in reader:
            print(row)
    finally:
        f.close()


def csv_writer():
    f = open("result.csv","wt",newline="\n") #newline = 한줄 자동줄바꿈 방지
    try:
        writer = csv.writer(f, quoting=csv.QUOTE_NONNUMERIC) # 숫자외에 문구 " "지정 하기
        writer.writerow(("Title 1", "Title 2", "Title 3"))
        for i in range(6):
            writer.writerow((i+1, chr(ord('a')+i) , ' 2021/% 02d/ 07'%(i+1))) #%02d 자리에 (i+1)이 증가되어 매핑
    finally:
        f.close()
    print(open("result.csv","rt").read())


if __name__ == '__main__':
    #csv_reader()
    #csv_reader02()
    csv_writer()