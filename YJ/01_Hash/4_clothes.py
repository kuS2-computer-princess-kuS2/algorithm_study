def solution(clothes):
    clothess = {} #옷 딕셔너리

    for item in clothes:
        name = item[0]
        type = item[1]

        if type in clothess:
            clothess[type] += 1 #종류별로 옷 개수 추가
        else:
            clothess[type] = 1
        
    answer = 1 #적어도 하나는 입음

    for i in clothess.values():
        answer *= (i+1) #옷 안입는 경우 포함

    return answer-1 #하나도 안 입은 경우 빼기