#피겨스케이팅 경기는 심사위원 5명이 각 10점 만점으로 줄 수 있다

#~ 선수의 경기 후 5명의 심사위원의 점수를 리스트에 저장하고
#점수의 평균을 구하는 프로그램

print("홍길동 선수 경기 끝났습니다~~ 짝짝짝")

score = []
for i in range(5) :
    jumsu = int(input("평가 점수 ==>"))
    score.append(jumsu)

hap = 0
for i in range(5) :
    hap += score[i] 
avg = hap / 5
print("심사위원 평균 점수 :", avg)