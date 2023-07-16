T=int(input())
for t in range(1, T+1):
    N, M = map(int, input().split())
    MAP = []
    for n in range(N):
        MAP.append(list(map(int, input().split())))
    
    sum_list=[]
    for y in range(N-M+1):
        for x in range(N-M+1):
            sum=0
            for vx in range(M):
                for vy in range(M):
                    sum+=MAP[y+vy][x+vx]
            sum_list.append(sum)
    
    print(f'#{t} {max(sum_list)}')