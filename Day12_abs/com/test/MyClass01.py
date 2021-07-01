class Dog:
    def sound(self):
        print("bark")
    def AA(self):
        print("Dog's AA")
class Cat:
    def sound(self):
        print("meow")
    def BB(self):
        print("Cat's BB")

class Chimera(Cat,Dog):
    def sound(self):
        #Cat.sound(self)
        #Dog.sound(self)
        super().sound()
        super().AA()
        print("Chimera")

if __name__ == '__main__':
    Chimera().sound() #a1 = Chimera(); a1.sound()

