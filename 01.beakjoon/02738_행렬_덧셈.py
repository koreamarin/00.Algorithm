N,M=map(int,input().split())

sub_list=[]
for _ in range(2):
    A_list=[]
    for n in range(N):
        B_list=list(map(int,input().split()))
        A_list.append(B_list)
    sub_list.append(A_list)


for n in range(N) :
    for m in range(M) :
        sub=0
        for list in sub_list :
            sub+=list[n][m]
        print(f"{sub}", end=" ")
    print()