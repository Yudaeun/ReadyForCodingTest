def solution(nums):
    original_nums_len=len(nums)
    nums=set(nums)

    if len(nums)>original_nums_len//2:
        return original_nums_len//2
    else:
        return len(nums)