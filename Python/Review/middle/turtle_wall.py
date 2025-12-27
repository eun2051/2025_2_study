#거북이 무늬의 벽지 만들기

#흰 벽지에 알록달록한 거북이 모양의 무늬를 가지런하게 그려보자
#벽지 크기는 가로 300, 세로 300 지정
#거북이는 약 50 거리만큼 떨어져서 다양한 색상의 거북이를 그림
#중첩 for문을 활용해서 코드를 작성

import turtle
import random

turtle.shape("turtle")
colors = ['red','green','magenta', 'blue', 'black']
turtle.penup()
turtle.screensize(300,300)
turtle.setup(330,330)

for i in range(7) :
    for k in range(7) :
        x = i * 50 - 150
        y = k * 50 - 150
        turtle.goto( x, y )
        turtle.color(random.choice(colors))
        turtle.stamp()

turtle.done()