#컴퓨터가 1~5 숫자 중 한가지를 생각, 사람이 그 숫자를 맞추는 게임
#단, 10번 안에는 맞혀야함

#숫자를 맞힌다면 break문으로 빠져나가고,
#맞히지 못한다면 continue문으로 반복문의 처음으로 돌아가기

import random

computer, user = 0, 0

for i in range(1, 11, 1) :
    computer = random.randint(1, 5)
    print ("게임", i, "회:", end='')
    user = int(input("컴퓨터가 생각한 숫자는 ? "))
    if computer == user :
        print(" 맞혔네요. 축하합니다 !! ")
        break
    else :
        print(" 아까워요. ", computer, "였는데요. 다시 해보세요.")
        continue
print("게임을 마칩니다.")