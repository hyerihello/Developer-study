def add(a,b):
    print("ADDING %d + %d"% (a, b))
    return a + b
def subtract(a,b):
    print("ADDING %d - %d"% (b, a))
    return b - a
def multiply(a,b):
    print("ADDING %d * %d" % (a, b))
    return a * b
def divide(a,b):
    print("ADDING %d / %d"% (b, a))
    return b / a
def choose_menu():
    print('input?')
    print('add, sub, mul, div, quit')
    return input('choice : ')
if __name__ == '__main__':
    menu = {'add': add, 'sub':subtract, 'mul':multiply, 'div':divide}
    choice = choose_menu()
    while choice != 'quit':
        if menu.get(choice):
            x = input('first value : ')
            y = input('second value : ')
            print(menu[choice](int(x), int(y)))
            choice = choose_menu()

