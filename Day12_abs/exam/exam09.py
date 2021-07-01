from exam.exam08 import MyCalc


class My(MyCalc):
    def __init__(self,a,b):
        super().__init__(a,b)
    def get_mod(self):
        return self.get_a() % self.get_b()
    # 선조가 가지고있는 __a,__b는 private 으로 호출이 불가하므로 메소드로 호출
    def calc_prn(self):
        super().calc_prn() # +, -, *, /
        print("%5d %% %5d = %5d"% (super().get_a(),super().get_b(),self.get_mod())) # %

if __name__ == '__main__':
    m = My(100,20)
    m.calc_prn()
