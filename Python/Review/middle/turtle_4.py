#거북이가 활동할 화면 크기 (300, 300)
#화면 중앙 (0,0) >> 거북이의 활동 공간은 가로로 (-150~150), 세로로 (-150~150)
#거북이가 움직인 위치가 범위안 > 그냥 두기
#밖으로 나가면 중앙 (0,0) 위치로 데려다 놓기
import turtle
import random

turtle.shape("turtle")
turtle.pensize(5)
turtle.pencolor("blue")

turtle.screensize(300,300)
turtle.setup(330,330)

while True :
    angle = random.randint(0, 360)
    distance = random.randint(10, 100)
    turtle.right(angle)
    turtle.forward(distance)
    curX = turtle.xcor( )
    curY = turtle.ycor( )

    if (curX >= -150 and curX <= 150) and (curY >= -150 and curY <= 150) :
        print("Good Boy~")
    else :
        turtle.goto( 0, 0 )

    turtle.done( )