import json

My_str = '{"name":"hyeri", "brothers":["changyong","changyong2"],"addr":"Toronto"}'

class my_jsonObject:
    def __init__(self,d): # d = My_str
        self.__dict__ = d
        print(self.__dict__, type(self.__dict__))
        print(d,type(d))
# __dict__ : 객체가 가진 여러가지 속성들을 딕셔너리 형태로 편하게 확인할 수 있다.

if __name__ == '__main__':
    # object_hook 은 대상을 클래스인 객체로 연동해서 구현된다.
    data = json.loads(My_str, object_hook = my_jsonObject)
    # my_jsonObject = dict형태이기에 사용자 클래스를 사용해서 key값으로 바로 value뽑아올 수 있게함
    print(data,type(data))
    print(data.name)
    for brother in data.brothers:
        print(brother)
