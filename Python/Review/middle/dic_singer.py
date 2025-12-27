#딕셔너리 구조를 활용해 가수의 특징 저장

singer = {}
singer['이름'] = "트와이스"
singer['구성원수'] = 9
singer['데뷰'] = "서바이벌 식스틴"
singer['대표곡'] = "CRY FOR ME"

for k in singer.keys() :
    print(k, " ==> ", singer[k])