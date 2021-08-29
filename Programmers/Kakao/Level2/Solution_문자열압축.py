def solution(s):
    answer = len(s)
    i = 1
    for i in range(1, len(s)//2 + 1):
        word = s[0:i]
        compression = ""
        cnt = 1
        for j in range(i, len(s), i):
            if(word == s[j:j+i]):
                cnt += 1
            else:
                if(cnt != 1):
                    compression += str(cnt)
                compression += word
                word = s[j:j+i]
                cnt = 1
        if(cnt != 1):
            compression += str(cnt)
        compression += word

        answer = min(answer, len(compression))
    return answer


s = "aabbaccc"
print(solution(s))
