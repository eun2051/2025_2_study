#택배를 받는 사람과 주소를 입력하고 택배의 무게를 입력
#택배 무게는 그램(g)당 5원이며, 자동으로 계산
print("## 택배를 보내기 위한 정보를 입력하세요. ##")
personName = input("받는 사람 : ")
personAddr = input("주소 : ")
weight = int(input("무게(g) : "))

print("** 받는 사람==> ", personName)
print("** 주소=> ", personAddr)
print("** 배송비 ==> ", weight * 5, "원")