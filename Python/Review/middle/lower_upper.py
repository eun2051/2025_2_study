ss = "Python"
print("원본 문자열==>", ss)
ss2 = ""

ss2 += ss[0].lower()

ss2 += ss[1].upper()
ss2 += ss[2].upper()
ss2 += ss[3].upper()
ss2 += ss[4].upper()
ss2 += ss[5].upper()

print("변환 문자열 ==>", end='')
print(ss2)