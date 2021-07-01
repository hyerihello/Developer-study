class Calc: #클래스 선언
    def __init__(self,a,b): #생성자 a,b
        self.a = a
        self.b = b
    def get_hap(self):
        return self.a + self.b
    def get_sub(self):
        return self.b - self.a
    def get_mul(self):
        return self.a * self.b
    def get_div(self):
        return self.b / self.a

if __name__ == '__main__':
    m = Calc(100,200) # m 이라는 변수를 이용
    '''
    print(m.get_hap())
    print(m.get_sub())
    print(m.get_mul())
    print(m.get_div())
    '''

    print("%5d + %5d = %5d"%(m.a,  m.b,  m.get_hap() ))
    print("%5d - %5d = %5d"%(m.b,m.a,m.get_sub()))
    print("%5d * %5d = %5d"%(m.a,m.b,m.get_mul()))
    print("%5d / %5d = %5d"%(m.b,m.a,m.get_div()))