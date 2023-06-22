T=int(input())

for t in range(1,T+1):
    h1, m1, h2, m2 = map(int,input().split())
    sum=((h1+h2)*60)+m1+m2

    h=(sum//60)%12
    m=sum%60
    
    print(f'#{t} {h} {m}' if h>0 else f'#{t} {12} {m}')