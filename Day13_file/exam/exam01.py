# 심심한그대
for i in range(6): #0부터 5까지 출력한다
    print(i)

for i in range(1,6): # 1부터 5까지 출력한다
    print(i)

for i in range(1,6,2): #1,3,5 를 출력한다
    print(i)

for i in range(6,1,-1): #6부터 1씩 차감해서 2까지 출력한다
    print(i)

a = int (input('숫자를 입력하세요 ~'))
for i in range(1,a+1):
    print('★' * 1)
    '''
    i 가 1일때는 ★
    i 가 2일때는 ★★ 
    '''