#거북이 100마리를 만들어서 화면 중앙에서 각 거북이가
#다양한 방향으로 선을 그리며 나가는 거북이 쇼 프로그램

#거북이 한 마리는 튜플로 (거북이, X위치, Y위치, 선 색상) 가짐
#X, Y 위치 : 거북이가 화면 중앙에서 선을 그리며 이동할 위치

#거북이 100개를 리스트로 저장
#거북이를 모두 생성한 후, 리스트에 있는 거북이 100마리가 차례대로 선을 그음

import turtle
import random

turtleList = [ ]
colorList = ["red", "green", "blue", "black", "magenta", "orange", "gray"]
shapeList = ["arrow", "circle", "square", "triangle", "turtle"]

turtle.setup(550, 550)
turtle.screensize(500, 500)

for i in range(0, 100) : # 거북이 100마리 생성
    shape = random.choice(shapeList)
    color = random.choice(colorList)
    x = random.randint(-250, 250)
    y = random.randint(-250, 250)
    myTurtle = turtle.Turtle(shape)
    tup = (myTurtle, color, x, y)
    turtleList.append(tup)

for tup in turtleList : # 리스트에 담긴 거북이 100마리 그리기
    myTurtle = tup[0]
    myTurtle.pencolor( tup[1] )
    myTurtle.goto(tup[2], tup[3])

turtle.done( )