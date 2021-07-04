try:
    import cPickle  #임포트 cPickle
    pickle = cPickle  #pickle로 대입한다. 대입시 cPickle이 없다면 프로그램은 중단이 되기때문에
    #                  except로 이동
except:
    import pickle #임포트 ->cPickle

class Address:
    def __init__(self,name, addr, tel):
        self.name = name
        self.addr = addr
        self.tel = tel
    def Prn(self):
        print("%10s%10s%15s\n"%(self.name,self.addr,self.tel))

if __name__ == '__main__':
    no01 = Address("홍길동","서울","02-0000-0000")
    with open("address.txt","wb") as f:
        pickle.dump(no01,f)
    with open("address.txt","rb") as f:
        res = pickle.load(f)
        res.Prn()

