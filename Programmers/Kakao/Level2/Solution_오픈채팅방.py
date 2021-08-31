def solution(record):
    answer = []
    # 명령어 확인하고
    # 마지막 유저의 닉네임을 저장
    a = []
    c = {"S": "유재석"}
    print(c["S"])
    for i in range(len(record)):
        a = record[i].split(" ")
        print(record[i])
        print(a)

    return answer


record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo",
          "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]
print(solution(record))
