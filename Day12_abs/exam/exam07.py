#[모듈화]
from com.test.Calc import Calc,MyTest #ctrl+spacebar = 자동완성기능

if __name__ == '__main__':
    m = Calc(100,200) # 생성자
    m.calc_prn()

    m.set_b(300)
    m.calc_prn()

    m.set_a(200)
    m.calc_prn()
    '''
    print("%5d + %5d = %5d"%(m.a,m.b,m.get_hap()))
    print("%5d - %5d = %5d"%(m.b,m.a,m.get_sub()))
    print("%5d * %5d = %5d"%(m.a,m.b,m.get_mul()))
    print("%5d / %5d = %5d"%(m.b,m.a,m.get_div()))
    '''
    # 새로운 계산기 만들기
    m1=Calc(300,400)
    m1.calc_prn()
    m2 = MyTest()
    m2.mytest_prn()
