def solution(nums):
    pokemon = set(nums) #중복제거
    answer = min(len(pokemon), len(nums) // 2) #둘 중 적은거로
    return answer