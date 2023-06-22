for t in range(1,11):
    N=int(input())
    H=list(map(int,input().split()))
    R=0
    for i in range(N):
        if i==0:
            L=H[0:i+3]
            L.pop(0)
        elif i==1:
            L=H[0:i+3]
            L.pop(1)
        else :
            L=H[i-2:i+3]
            L.pop(2)
        A=H[i]-max(L)
        if A > 0 :
            R+=A
        
    print(f'#{t} {R}')