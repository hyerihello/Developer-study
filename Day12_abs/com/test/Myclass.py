from abc import abstractmethod, ABCMeta
class Base(metaclass=ABCMeta):
    @abstractmethod
    def start(self):
        print("base start")
    @abstractmethod
    def Stop(self):
        print("base stop")
        # △ 추상클래스
class Cat(Base):
    def start(self):
        print("cat start")
    def Stop(self):
        print("cat stop")
class Duck(Base):
    def start(self):
        print("duck start")
    def Stop(self):
        print("duck stop")
class Puppy(Base):
    def start(self):
        print("puppy start")
    def Stop(self):
        print("puppy stop")

def My_Call(m):
        m.start()
        m.Stop()

if __name__ == '__main__':
    My_Call(Puppy())
    My_Call(Cat())
    My_Call(Duck())