Rank={0:"A+",1:"A0",2:"A-",3:"B+",4:"B0",5:"B-",6:"C+",7:"C0",8:"C-",9:"D0"}

T = int(input())
for t in range(1,T+1):
    N, K= map(int,input().split())
    L=[]
    for n in range(N):
        A,B,C=map(int,input().split())
        T=((A*35)+(B*45)+(C*20))/100
        L.append(T)
    D=L[K-1]
    R=sorted(L, reverse=True).index(D)
    print(f'#{t} {Rank[R//(N//10)]}')