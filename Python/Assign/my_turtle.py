import turtle

turtle.shape("turtle")
turtle.penup()

x = 0
y = 0
text = "lee seungeun"

turtle.goto(x, y)
turtle.write(text.lower(), font=("Arial", 30))

turtle.goto(x, y + 40)
turtle.write(text.upper(), font=("Arial", 30))

turtle.done()