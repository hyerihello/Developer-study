import json
def Test01():
    data=[{'a':'A', 'b':(2,4), 'c':3.0}]
    print('data :', data)
    print("repr(data) :", repr(data))
    print("str :", str(data))

    # repr : 해당객체를 문자열로 리턴함, value 자체만 type만 string
    print(type(data), type(repr(data)), type(str(data)))

    data_string = json.dumps(data)
    print('json :', data_string, type(data_string))
    # key값이 "" 로 리턴되는것 확인한다.

def Test02():
    data = {'a':'A', 'b':(2,4), 'c':3.0}

    data_string = json.dumps(data, indent=4, sort_keys=True)
    print('Encoded :', data_string, type(data_string))
    #repr(data_string)
    print()
    decoded = json.loads(data_string)
    print('Decoded :', decoded, type(decoded))

def Test03():
    obj_json = '{"str" : [42.2], "str01":42}'
    obj = json.loads(obj_json)
    print(type(obj))
    print(json.dumps(obj, indent=4, sort_keys=True))
    j= json.dumps(obj, indent=4, sort_keys=True)
    print(type(j))


def Test04():
    obj_json = '{"str": [42.2], "str01":42}'

    # 파일에쓰기
    file = open("data.json",'w')
    json.dump(obj_json, fp=file, indent=4, sort_keys=True)
    file.close()

    # 파일에서 읽어서 화면 출력하기
    file = open("data.json", 'r')
    result = json.load(fp=file)
    print(result,type(result))
    file.close()


def Test05():
    obj_json = {"str": [42.2], "str01":42, "str02":'대한민국'}
    file = "data1.json"
    json.dump(obj_json, fp=open(file,'w'),indent=4, sort_keys=True)
    result = json.load(fp=open(file, 'r'))
    print(result, type(result))


if __name__ == '__main__':
    #Test01()
    # Test03()
    Test04()
    Test05()