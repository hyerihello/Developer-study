## DOM

: Document Object Model, 웹 페이지에 대한 인터페이스

## **xml 파싱 **

 **(1) xml : dom.tree **

     : 다른 언어와 유사한 API를 갖는 문서 객체 모델 인터페이스의 최소 구현.

      전체(full) DOM보다 단순하고 훨씬 작다

```
from xml.dom.minidom import parse, parseString

dom = parse('myfriend.xml')
for name in dom.getElementsByTagName('name'):
    print(name.firstChild.data)
    
print('==============================================')

datasource = open('myfriend.xml')
dom2 = parse(datasource)
for name in dom.getElementsByTagName('addr'):
    print(name.firstChild.data)
    
# 심심한 그대 이름과 주소를 xml에서 파싱해서 결과를 확인


C:\Python\Python39\python.exe C:/Python_work/Day37(6.9)/com/test/심심한그대.py
Dominica
Dominico
RuRi
RuSe
==============================================
seoul
toronto
alberta
alberta

Process finished with exit code 0

```

 **(2) xml.etree.Element Tree**

     :  XML 데이터를 구문 분석하고 만들기 위한 단순하고 효율적인 API를 구현 

```
import xml.etree.ElementTree
import xml.etree.ElementTree as et


def Test(): # 함수 이용해서 찾는 법
    friend = xml.etree.ElementTree.parse('myfriend.xml')
    friends = friend.findall("address")
    for res in friends:
        print(res.find("name").text, "," ,
              res.find("addr").text)

print("====================================")

def Test01(): # 속성값 이용해서 찾는 법
    tree = et.ElementTree(file='fruit.xml')
    root = tree.getroot()
    for child in root:
        print('tag : ', child.tag,
              'attributes : ', child.attrib)
        for grandchild in child:
            print('\ttag: ', grandchild.tag,
                  'attributes : ', grandchild.attrib)
if __name__ == '__main__':
    Test()
    Test01()



C:\Python\Python39\python.exe C:/Python_work/Day38(6.10)/com/test/exam01.py


Dominica , seoul
Dominico , toronto
RuRi , alberta
RuSe , alberta
====================================
tag :  origin attributes :  {'name': 'korean'}
	tag:  quantity attributes :  {}
	tag:  price attributes :  {'type': 'unit'}
	tag:  basket attributes :  {'classification': 'fruit', 'name': 'apple'}
	tag:  basket attributes :  {'classification': 'vegetable', 'name': 'eggplant'}
tag :  origin attributes :  {'name': 'Singapore'}
	tag:  quantity attributes :  {}
	tag:  price attributes :  {'type': 'unit'}
	tag:  basket attributes :  {'classification': 'fruit', 'name': 'banana'}
	tag:  basket attributes :  {'classification': 'vegetable', 'name': 'cabbage'}
tag :  origin attributes :  {'name': 'Andes'}
	tag:  quantity attributes :  {}
	tag:  price attributes :  {'type': 'unit'}
	tag:  basket attributes :  {'classification': 'fruit', 'name': 'tomato'}
	tag:  basket attributes :  {'classification': 'vegetable', 'name': 'leek'}

Process finished with exit code 0

```

**(3) xml**

```
import xml.etree.ElementTree as et
def Test():
    tree = et.ElementTree(file='fruit.xml')
    root = tree.getroot()
    for basket02 in root.iter('basket'): #iter() 전체 목록을 리턴한다.
        if basket02.attrib['classification'] == 'vegetable':
            print('\t (채소)', basket02.attrib['name'])
        else:
            print('\t (과일)', basket02.attrib['name'])

    print("*********************************************")

def Test01():
    tree = et.ElementTree(file='fruit.xml')
    root = tree.getroot()
    for origin in root.findall('origin'):
        if origin.attrib['name'] == 'Andes': # origin의 name 속성값이 Andes라면
            origin.set('name', 'Canana') # 속성값 변경을 Canada로 지정
        quantity = int(origin.find('quantity').text)
        price = int(origin.find('price').text)
        if quantity < 5: # 수량이 5이하인 origin 엘리먼트 삭제
            root.remove(origin)
        total = quantity * price
        for res in origin.findall('basket'):
            print(res.get('name'), format(total, ',')) # 목록과 (수량*단가) 금액 출력

if __name__ == '__main__':
    Test()
    Test01()
    
    
    
    	 (과일) apple
	 (채소) eggplant
	 (과일) banana
	 (채소) cabbage
	 (과일) tomato
	 (채소) leek
*********************************************
apple 15,000
eggplant 15,000
banana 2,850
cabbage 2,850
tomato 5,000
leek 5,000
```

**4) xml : dom tree **

```
import xml.dom.minidom
def test():
    dom = xml.dom.minidom.parse("Doit.xml")
    print(dom.documentElement.tagName)
# node 객체로 접근 해서 데이터 호출
    for node in dom.documentElement.childNodes:
        if node.nodeType == node.ELEMENT_NODE:
            print("  " + node.tagName)
            for node2 in node.childNodes:
                if node2.nodeType == node2.ELEMENT_NODE:
                    print("      " + node2.tagName)
                    for node3 in node2.childNodes:
                        if node3.nodeType == node3.TEXT_NODE:
                            print("          " + node3.data)
    print("----------------------------------")
    for url in dom.getElementsByTagName("url"):
        print(url.firstChild.data)
if __name__ == '__main__':
    test()
    
    
    
    C:\Python\Python39\python.exe C:/Python_work/Day40(06.14)/com/test/exam01.py
bookmark
  site
      name
           google 
      url
           http:// www.google.co.kr/
  site
      name
           naver 
      url
           http:// www.naver.com/
  site
      name
           daum 
      url
           http:// www.daum.net/
----------------------------------
 http:// www.google.co.kr/
 http:// www.naver.com/
 http:// www.daum.net/

Process finished with exit code 0
```

**4) xml : e tree 로 변경해 출력해 보자.**

```
import xml.etree.ElementTree


def Test():
    domain = xml.etree.ElementTree.parse('Doit.xml')
    domains = domain.findall("site")
    print("bookmark \n")

    for res in domains:
        print("   site           \n",
              "      name        \n",
              "            ",res.find("name").text, "   \n",
              "      url         \n",
              "            ",res.find('url').text)


    print("----------------------------------")
    for url in domains:
        print(url.find('url').text)
if __name__ == '__main__':
    Test()
    
    
 C:\Python\Python39\python.exe C:/Python_work/Day40(06.14)/com/test/exam02.py
bookmark 

   site           
       name        
               google     
       url         
               http:// www.google.co.kr/
   site           
       name        
               naver     
       url         
               http:// www.naver.com/
   site           
       name        
               daum     
       url         
               http:// www.daum.net/
----------------------------------
 http:// www.google.co.kr/
 http:// www.naver.com/
 http:// www.daum.net/

Process finished with exit code 0
```

---

```
# 파일이름 "myfriend.xml"

<?xml version="1.0" encoding="UTF-8" ?>
<friends>
    <address>
        <name>Dominica</name>
        <addr>seoul</addr>
    </address>
    <address>
        <name>Dominico</name>
        <addr>toronto</addr>
    </address>
    <address>
        <name>RuRi</name>
        <addr>alberta</addr>
    </address>
    <address>
        <name>RuSe</name>
        <addr>alberta</addr>
    </address>
</friends>
```

```
# 파일 이름 'fruit.xml'

<?xml version="1.0" encoding="UTF-8" ?>

<viand>
    <origin name = "korean">
        <quantity>10</quantity>
        <price type = 'unit'>1500</price>
        <basket classification = "fruit" name = "apple"/>
        <basket classification = "vegetable" name = "eggplant"/>

    </origin>
    <origin name="Singapore">
        <quantity>3</quantity>
        <price type = "unit">950</price>
        <basket classification = "fruit" name = "banana"/>
        <basket classification = "vegetable" name = "cabbage"/>
    </origin>
        <origin name="Andes">
        <quantity>5</quantity>
        <price type = "unit">1000</price>
        <basket classification = "fruit" name = "tomato"/>
        <basket classification = "vegetable" name = "leek"/>
    </origin>
```

```
# 파일이름 Doit.xml

<?xml version="1.0" encoding="UTF-8" ?>
<bookmark>
    <site>
        <name> google </name>
        <url> http:// www.google.co.kr/</url>
    </site>

    <site>
        <name> naver </name>
        <url> http:// www.naver.com/</url>
    </site>

    <site>
        <name> daum </name>
        <url> http:// www.daum.net/</url>
    </site>
</bookmark>
```
