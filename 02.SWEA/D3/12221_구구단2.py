T=int(input())
for t in range(1,T+1):
    A,B=map(int,input().split())
    status=True
    if A>9 or B>9:
        status=False
    if status==False:
        print(f'#{t} -1')
    else :
        print(f'#{t} {A*B}')