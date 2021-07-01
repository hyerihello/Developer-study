from com.test.study import Calc,MyTest

if __name__ == '__main__':
    m = Calc(100,200) # m 이라는 변수를 이용
    m.caln_prn()

    m.set_a(200)
    m.caln_prn()

    m.set_b(300)
    m.caln_prn()

    # 새로운 계산기 만들기
    m1 = Calc(300,400)
    m1.caln_prn()
    m2 = MyTest()
    m2.mytest_prn()