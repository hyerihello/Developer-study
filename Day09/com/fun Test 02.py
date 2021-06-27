def prn(): #3
    print("my python")#4
    prn01()#5
    print("prn' fun")#8

def prn01():#6
    print("hello python")#7

def prn02():
    print("100+100=200")
    a=100
    print("%5d+%5d=%5d"%(a,a,(a+a)))



if __name__ == '__main__': # 프로그램을 실행하는 진입점 → 1
    prn() # my python → 2
    prn01() # hello python
    prn02() # 100 + 100 = 200
    print("------main------") #9