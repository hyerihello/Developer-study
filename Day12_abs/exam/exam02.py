class MYSU:
    def __init__(self,Su):
        self.Su=Su
        # ↓두 객체의 크기를 비교할때 사용
    def __lt__(self, Su): #less than <
        print("self.Su<other.Su")
    def __gt__(self, Su): #great than >
        print("self.Su>other.Su")
    def __eq__(self,other): #equal ==
        print("EQ")

if __name__ == '__main__':
    a = MYSU(100)
    b = MYSU(50)
    a > b
    a < b
    a == b
