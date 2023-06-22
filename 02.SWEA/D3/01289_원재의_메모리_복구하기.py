T=int(input())
for t in range(1,T+1):
    org_Memory=list(map(int,input()))
    N=len(org_Memory)
    crt_Memory = [0 for _ in range(len(org_Memory))]

    n=0
    for i in range(N):
        if org_Memory[i]!=crt_Memory[i]:
            for j in range(i,N):
                crt_Memory[j]=org_Memory[i]
            n+=1
    print(f'#{t} {n}')