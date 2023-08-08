def solution(participant, completion):
    names = {} #이름 딕셔너리
    
    for name in participant:
        if name in names:
            names[name] += 1
        else:
            names[name] = 1 #이름 생성
    
    for name in completion:
        names[name] -= 1 #완료하면 빼기
    
    for name, count in names.items():
        if count != 0: #0 아니면 완주 못함
            answer=name
            return answer
