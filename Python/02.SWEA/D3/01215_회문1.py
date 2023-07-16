def confirm(word,N):
    for i in range(N//2):
        if word[i]!=word[-(i+1)]:
            return False
    return True


for t in range(1,11):
    N=int(input())
    MAP=[[k for k in input()] for _ in range(8)]
    SW_L=[]

    # 가로 추가.
    for n in range(8):
        for j in range(8-N+1):
            SW_L.append(MAP[n][j:j+N])
        # 세로 추가.
        for k in range(8-N+1):
            SW_L.append([MAP[i+k][n] for i in range(N)])

    n=0
    # 회문 카운팅.
    for w in SW_L:
        if confirm(w,N):
            n+=1

    print(f'#{t} {n}')