for _ in range(10):
    N=int(input())
    arr=[list(map(int,input().split())) for _ in range(100)]
    L=[]

    # 행들의 합 리스트 만들기
    for row in arr:
        L.append(sum(row))
    
    # 열들의 합 리스트 만들기
    for j in range(100):
        S=0
        for i in range(100):
            S+=arr[i][j]
        L.append(S)

    
    # 대각선 합 리스트 만들기
    C1,C2=0,0
    for i in range(100):
        C1+=arr[i][i]
        C2+=arr[i][99-i]
    L.append(C1)
    L.append(C2)

    print(f'#{N} {max(L)}')
