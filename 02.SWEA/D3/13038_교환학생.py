T=int(input())
for t in range(1,T+1):
    N=int(input())
    W=list(map(int,input().split()))
    W1=0
    for w in W:
        if w == 1:
            W1+=1
    
    WL=[]
    for _ in range(W1):
        W.append(W.pop(0))
        while W[0]==0:
            W.append(W.pop(0))
        WL.append(W.copy())

    L=[]
    for wl in WL:
        d,n=0,N
        while n!=0:
            if wl[d%7]==1:
                n-=1
            d+=1
        L.append(d)
    print(f'#{t} {min(L)}')