class Mstack:
    def __init__(self):
        self.stack =[]
        print("hi Mstack")

    def push(self,str1):
        self.stack.append(str1)
        print(list(self.stack),type(str1),str1)

    def pop(self):
        return self.stack.pop()
    def length(self):
        return len(self.stack)
    def __del(self):
        print("by Mstrack")

if __name__ == '__main__':
    a1 = Mstack();
    for x in range (1,6):
        a1.push(x);
    a1.pop()
    print("length :", a1.length())

