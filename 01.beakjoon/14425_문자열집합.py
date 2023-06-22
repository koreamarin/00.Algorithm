N,M=map(int,input().split())
i=0
S=[input() for _ in range(N)]
for _ in range(M) :
    if input() in S :
        i+=1
print(i)