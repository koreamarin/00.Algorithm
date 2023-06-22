T=int(input())
for t in range(1, T+1):
    N=int(input())
    D=[]
    for n in range(N):
        A,B=input().split()
        D.append([A,int(B)])
    i=0
    print(f'#{t}')
    for key,value in D:
        for _ in range(value):
            print(key, end="")
            i+=1
            if i==10:
                i=0
                print()
    print()