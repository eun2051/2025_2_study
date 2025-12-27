#2단 ~ 9단 for문 사용
#바깥 for문은 2단, 3단 ... 9단을, 
#안쪽 for문은 1,2,3..으로 곱하는 숫자 사용
#중첩 for문을 사용해서 코드 작성
i = 0
k = 0

for i in range(2, 10, 1) :
    for k in range(1, 10, 1) :
        print(i, " X ", k, " = ", i*k)
    print("")