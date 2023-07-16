T=int(input())
for t in range(T):
    A,B=map(int,input().split())
    if A > B :
        print(f'#{t+1} >')
    elif A < B :
        print(f'#{t+1} <')
    elif A == B :
        print(f'#{t+1} =')