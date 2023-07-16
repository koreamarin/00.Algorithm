import math
T=int(input())

for t in range(1,T+1):
    N=int(input())
    L=[]
    for i in range(1,round(math.sqrt(N))+1):
        if N % i == 0:
            L.append([i,N//i])
    ML=[l[0]+l[1]-2 for l in L]
    print(f'#{t} {min(ML)}')