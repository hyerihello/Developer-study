'''
 두수를 입력받아 (두수를 입력받을 생성자 또는 a,b를 관리하는 메소드) 사칙구현하는 클래스를 만들고 싶다.
  100 + 200 =   get_hap()
  200 - 100 =   get_sub()
  100 * 200 =   get_mul()
  200 / 100 =   get_div()
   class Calc:
   [1단계]
'''

class Calc:
    def __init__(self,a,b):
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
    m = Calc(100,200) # 생성자
    print(m.get_hap())
    print(m.get_sub())
    print(m.get_mul())
    print(m.get_div())


