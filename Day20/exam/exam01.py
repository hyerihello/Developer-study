import urllib.request
def Test():
    f = urllib.request.urlopen('http://www.python.org/'); print(f.read(300).decode('utf-8'))

def Test01():
    req = urllib.request.Request('http://www.my_server.org')
    try:
        urllib.request.urlopen()
if __name__ == '__main__':
    Test()