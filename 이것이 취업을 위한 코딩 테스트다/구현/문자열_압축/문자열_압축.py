def solution(s):
    max_offset = len(s) // 2
    start = 0
    answer = len(s)
    
    for offset in range(1, len(s) // 2 + 1) :
        result = ''
        word = s[0: offset]
        count = 1
        for idx in range(offset, len(s), offset):
            next_word = s[idx: idx + offset]
            if word == next_word:
                count += 1
            else:
                if count > 1:
                    result += (str(count) + word)
                else :
                    result += word
                    
                count = 1
                word = next_word
            
        if count > 1:
            result += (str(count) + word)
        else:
            result += word
            
        answer = min(len(result), answer)
        
    return answer