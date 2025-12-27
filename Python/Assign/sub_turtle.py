import turtle

class SeaTurtle(turtle.Turtle) :
    name = ''
    def __init__(self) :
        super().__init__('triangle')
        self.color("blue")
        self.name = "바다거북"
        self.body = self
    def swim(self, x, y) :
        super().goto(x, y)

class SandTurtle(turtle.Turtle) :
    name = ''
    body = None
    def __init__(self) :
        self.body = turtle.Turtle('circle')
        self.body.color("red")
        self.name = "모래 거북"
    def walk(self, x, y) :
        self.body.goto(x, y)

class SpinyTurtle(SandTurtle) :
    def __init__(self) :
        super().__init__()
        self.name = "가시 거북"
        self.body.shape("turtle")
        self.body.color("brown")

    def spike(self, x, y) :
        self.body.goto(x, y)
 
seaTut, sandTut, spinyTut = None, None, None
seaTut = SeaTurtle()
seaTut.swim(100, 100)
seaTut.body.write(seaTut.name, font=("Arial", 20))

sandTut = SandTurtle()
sandTut.walk(-100, 100)
sandTut.body.write(sandTut.name, font=("Arial", 20))

spinyTut = SpinyTurtle()
spinyTut.spike(0, -100)
spinyTut.body.write(spinyTut.name, font=("Arial", 20))
turtle.done()