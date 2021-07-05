class Score:
    def __init__(self, no, name, kor, eng, mat):
        self.__no = no
        self.__name = name
        self.__kor = kor
        self.__eng = eng
        self.__mat = mat


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
    def tot(self):
        return self.getK() + self.getE() + self.getM()
    def avg(self):
        return self.tot() // 3
    def grade(self):
        if self.avg() >= 90:
            return "A"
        elif 80 <= self.avg() < 90:
            return "B"
        elif 70 <= self.avg() < 80:
            return "C"
        else:
            return "F"
    def __str__(self):
        return "No: %d, Name: %s, Kor: %d, Eng: %d, Mat: %d, Tot: %d, Avg: %d, Grade: %s"\
              %(self.getNo(), self.getName(), self.getK(), self.getE(), self.getM(), self.tot(), self.avg(), self.grade())

if __name__ == '__main__':
    s1 = Score(1."홍길동",90,100,80)
    print(s1)