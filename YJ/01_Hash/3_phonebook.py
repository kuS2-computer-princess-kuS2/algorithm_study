def solution(phone_book):
    length = len(phone_book)
    
    for i in range(length):
        for j in range(length):
            if i != j and phone_book[j].startswith(phone_book[i]): #접두 전화번호 비교
                return False
    
    return True