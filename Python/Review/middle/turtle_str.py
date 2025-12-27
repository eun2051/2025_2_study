#거북이는 화면 가운데서 출발
#사용자가 원하는 x위치, y위치, 거북이가 쓸 문자열을 입력하면
#거북이가 해당 위치를 찾아가 글자를 쓰는 프로그램

import turtle

turtle.shape("turtle")
turtle.penup()

while True :
    x = int(input("X위치==>"))
    y = int(input("Y위치==>"))
    text = input("쓰고 싶은 글자 ==>")

    turtle.goto(x, y)
    turtle.write(text, font=("Arial", 30))
    
turtle.done()