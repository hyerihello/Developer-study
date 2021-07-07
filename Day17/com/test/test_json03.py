import json

def Prn():
   with open("data.json") as f:
       s = f.read()
       print(s,type(s))


class Student:
    def __init__(self, d):
        self.__dict__= d

def Prn02():
    # 1. json 모듈로 STUDENT.json 파일을 읽어오자
    # 2. Object_hook 을 이용해서 Student 클래스를 만들어서 데이터를 대입한다.
    # 3. 이름 : 총점으로 출력한다.
    # ex) Ruse : 270점
    file = open('STUDENT.json', 'r')
    str = file.read()
    file.close()

    #data = json.loads(str, object_hook=Student)
    data = json.load(fp=open('STUDENT.json','r'), object_hook=Student)
    for i in data.STUDENT:
        hap = i.SCORE.KOR + i.SCORE.ENG + i.SCORE.MATH
        print(i.NAME + ":%3d 점" % hap)

def Prn03():
    file = open('STUDENT.json', 'r')
    data = json.load(fp=file, object_hook=Student)
    file.close()

    for i in data.STUDENT:
        hap = i.SCORE.KOR + i.SCORE.ENG + i.SCORE.MATH
        print(i.NAME + ":%3d 점" % hap)

if __name__ == '__main__':
    Prn02()
    Prn03()
