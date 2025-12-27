#A, B, C, D, E 다섯명의 학생들에게 도시락 나눠주기
#다섯명의 학생들이 도시락을 받기위해 순서대로 줄을 서려면
#총 몇가지 경우 ??

#팩토리얼 함수를 사용하면 쉽게 해결 가능
i = 0
fact = 1
friends_num = 5

for i in range(1, friends_num+1, 1):
    fact = fact * i

print("A, B, C, D, E 학생들을 순서대로 세우는 경우의 수:", fact)