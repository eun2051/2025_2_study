import random
myHand = input("나의 가위/바위/보 ==> ")
comHand1 = random.choice(["가위", "바위", "보"])
comHand2 = random.choice(["가위", "바위", "보"])
print("컴퓨터1의 가위/바위/보 ==> ", comHand1)
print("컴퓨터2의 가위/바위/보 ==> ", comHand2)

if myHand == comHand1 and myHand == comHand2 :
    print("비겼습니다. comHand1=", comHand1, "comHand2=", comHand2, "myHand=", myHand)
elif myHand != comHand1 and myHand != comHand2 and comHand1 != comHand2 :
    print("비겼습니다. comHand1=", comHand1, "comHand2=", comHand2, "myHand=", myHand)

if myHand == "가위" :
    if (comHand1 == "보" or comHand2 == "보") :
        print("이겼습니다. comHand1=", comHand1, "comHand2=", comHand2, "myHand=", myHand)
    elif (comHand1 == "바위" or comHand2 == "바위") :
        print("졌습니다. comHand1=", comHand1, "comHand2=", comHand2, "myHand=", myHand)

elif myHand == "바위" :
    if (comHand1 == "가위" or comHand2 == "가위") :
        print("이겼습니다. comHand1=", comHand1, "comHand2=", comHand2, "myHand=", myHand)
    elif (comHand1 == "보" or comHand2 == "보") :
        print("졌습니다. comHand1=", comHand1, "comHand2=", comHand2, "myHand=", myHand)

elif myHand == "보" :
    if (comHand1 == "바위" or comHand2 == "바위") :
        print("이겼습니다. comHand1=", comHand1, "comHand2=", comHand2, "myHand=", myHand)
    elif (comHand1 == "가위" or comHand2 == "가위") :
        print("졌습니다. comHand1=", comHand1, "comHand2=", comHand2, "myHand=", myHand)
else :
    print ("가위/바위/보 중 하나를 내세요.")