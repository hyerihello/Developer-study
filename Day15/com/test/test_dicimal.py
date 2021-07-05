import decimal #십진법모듈
# 생성자 decimal.Decimal()

#(90.7 + 30.2) + 0.0002
if __name__ == '__main__':
    a,b = decimal.Decimal('90.7'),decimal.Decimal('30.2')
    print(a,b)
    print(a,b,type(a),type(b))
    c = decimal.Decimal('0.0002')
    print((a+b)+c)
    r = (90.7 + 30.2) + 0.0002
    print(r)
    print("********************")
    print(1/3)
    decimal.getcontext().prec=3 #객체의 환경설정 ex) 소수 3번째 자리되도록 설정
    e,f = decimal.Decimal('1'), decimal.Decimal('3')
    print(e/f)
    e,f = decimal.Decimal('5'), decimal.Decimal('7')
    print(e/f)

    c = decimal.Context(prec=28, Emin=-425000000, Emax=425000000,rounding = decimal.ROUND_HALF_EVEN,\
                        capitals = 1, clamp = 1, flags = [])

    decimal.setcontext(c) #활성 스레드의 현재 컨텍스트를 돌려줌
    print(decimal.getcontext()) #활성스레드의 현재 컨텍스트를 돌려줌
    decimal.setcontext(decimal.ExtendedContext) # 표준컨텍스트 정밀도 9
    print(decimal.getcontext())
