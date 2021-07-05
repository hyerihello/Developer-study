import sys

if __name__ == '__main__':
    try:
        10/0
    except ZeroDivisionError as z:
        print(sys.exc_info()) #현재 발생한 예외정보를 튜플로 반환(예외없는경우 None반환)
        print(format(type(z)))
        print(format(z.args))
        print(format(z))