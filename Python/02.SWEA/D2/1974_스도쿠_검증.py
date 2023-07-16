def confirm(L):
    # 가로줄 검사
    for i in range(9):
        D1={1:0,2:0,3:0,4:0,5:0,6:0,7:0,8:0,9:0}
        D2={1:0,2:0,3:0,4:0,5:0,6:0,7:0,8:0,9:0}
        for j in range(9):
            if D1[L[i][j]]==1 or D2[L[j][i]]==1:
                return 0
            D1[L[i][j]]+=1
            D2[L[j][i]]+=1

    # 구역 검사
    for i in range(3):
        for j in range(3):
            D={1:0,2:0,3:0,4:0,5:0,6:0,7:0,8:0,9:0}
            for k in range(3):
                for h in range(3):
                    if D[L[i*3+k][j*3+h]]==1:
                        return 0
                    D[L[i*3+k][j*3+h]]+=1
    return 1


T=int(input())
for t in range(1,T+1):
    L=[list(map(int,input().split())) for _ in range(9)]
    result=confirm(L)

    print(f'#{t} {result}')
