import pickle

class score:
    def __init__(self, no, name, kor, eng, mat):
        self.__no = no
        self.__name = name
        self.__kor = kor
        self.__eng = eng
        self.__mat = mat
    def getNo(self):
        return self.__no
    def getName(self):
        return self.__name
    def getK(self):
        return self.__kor
    def getE(self):
        return self.__eng
    def getM(self):
        return self.__mat

    def setNo(self, no):
        self.__no = no

    def setName(self, name):
        self.__name = name

    def setK(self, kor):
        self.__kor = kor

    def setE(self, eng):
        self.__eng = eng

    def setM(self, mat):
        self.__mat = mat

    def tot(self):
        return (self.getK() + self.getE() + self.getM())
    def avg(self):
        return (self.getK() + self.getE() + self.getM()) / 3
    def grade(self):
        if self.avg() >= 90:
            return "A"
        elif 80 <= self.avg() < 90:
            return "B"
        elif 70 <= self.avg() < 80:
            return "C"
        else:
            return "F"
    def prn_score(self):
        print(self.getNo(), self.getName(), self.getK(), self.getE())
if __name__ == "__main__":

    no01 = score(1, "민정", 70, 80, 100)
    no01.prn_score()
    no02 = score(2, "혜리", 70, 80, 100)
    no03 = score(3, "예욱", 70, 80, 100)
    no04 = score(4, "미래", 70, 80, 100)
    no05 = score(5, "영아", 70, 80, 100)
    no06 = score(6, "은성", 70, 80, 100)
    no07 = score(7, "원석", 70, 80, 100)
    no08 = score(8, "승민", 70, 80, 100)
    no09 = score(9, "천빈", 70, 80, 100)
    no10 = score(10, "상훈", 70, 80, 100)
    list_all = [(no01, no02, no03, no04, no05, no06, no07, no08, no09, no10)]

    Im = (list_all)
    with open("score.txt", "ab") as f:
        pickle.dump(Im, f)
    with open("score.txt", "rb") as f:
        res = pickle.load(f)
        res.prn_score()
    print(
        no01.getK() + no02.getK() + no03.getK() + no04.getK() + no05.getK() + no06.getK() + no07.getK() + no08.getK() + no09.getK() + no10.getK())
    print(
        no01.getE() + no02.getE() + no03.getE() + no04.getE() + no05.getE() + no06.getE() + no07.getE() + no08.getE() + no09.getE() + no10.getE())

    for i in list_all:
        i.setM(0)
        print(i.prn_score())