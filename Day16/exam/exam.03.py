import csv # csv확장자를 가진 파일을 처리하는 모듈
# 몇가지 필드를 쉼표(,)로 구분한 텍스트 데이터/파일

def Test():
    #파일에서 읽은 수식이나 문자열을 그대로 실행해야 할 경우 '2+3' eval()
    # eval : string 값을 넣으면 해당값을 그대로 실행, 출력
    a = '2 + 3'
    print(a)
    print(eval(a)) #5

    res = '24 + 256 - 71 * 34'
    print(res, ' = ', eval(res))
    print("*******************************")
def Test01():
    # a 리스트객체를 추출해서 34+22... 형식의 문자로 출력하고싶다. str.join() // p203
    a = [34,22,45,27,31,33,35]
    b = [] #문자로 변경해서 추가하는 변수
    for i in a:
        b.append(str(i)) #문자로 변경해서 b리스트에 추가한다.
    print(b) # ['34','22',,,]
    bond = ' + '
    result = bond.join(b)
    print(result, '=' , eval(result))
def Test02():
    # 34, 22, 45, 27, 31, 33, 35 = hap , exam-3.csv데이터를 읽어서 출력
    file = open("exam03.csv")
    res = csv.reader(file)
    print(res, type(res))
    b = []
    for row in res:
        b.append(row)
    print(b[0])
    bond = " + "
    result = bond.join(b[0])
    print(result, ' = ', eval(result))
    #try 로도 해보기
def Test03():
    file = open("data02.csv", encoding="utf-8") #sys.getdefaulttencoding()
    res_csv = csv.reader(file, delimiter=' ') #한 칸 띄워야함 # 각 필드를 구분하기 위한 문자 (기본값: ',')

    for row in res_csv:
        print(row)

def Test04():
    # 34, 22, 45, 27, 31, 33, 35 = hap , exam-3.csv데이터를 읽어서 출력
    file = open("data.csv", encoding='utf-8')
    res = csv.reader(file, delimiter=' ')
    print(res, type(res))
    b = []
    name = []
    for row in res:
        b.append(row[0])
        name.append(row[1])
    print(b)
    bond = "+"
    result = None
    result = bond.join(b)
    print(result, '=', eval(result))
    print(name)
    return name;
def Test05():
    #data03.csv 에서 data.csv에서 이름만 추출해서 저장하자
    print("===========Test05============")
    name = Test04()
    print("------Test05--->" , name)
    file = open("data03.csv",mode='w',encoding='utf-8')
    csv_writer = csv.writer(file, delimiter = ' ', lineterminator='\r\n')
    csv_writer.writerow(name) #writerow 가로로, ows 세로로 나열
    for row in name:
        csv_writer.writerow(row)

if __name__ == '__main__':
    #Test04()
    Test05()

