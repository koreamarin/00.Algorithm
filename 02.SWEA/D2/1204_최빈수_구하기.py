T=int(input())
for _ in range(1,T+1):
    t=int(input())
    D={}
    L=list(map(int,input().split()))
    for l in L:
        if l not in D.keys():
            D[l]=1
        else:
            D[l]+=1
    m=max(D.values())
    ML=[key for key in D.keys() if D[key]==m]
    print(f'#{t} {max(ML)}')