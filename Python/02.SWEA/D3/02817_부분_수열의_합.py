def dfs(n,sum):
    global ans
    if K<sum:
        return
    if n == N:
        if sum==K :
            ans+=1
        return

    # 사용하는 경우
    dfs(n+1, sum+lst[n])
    # 사용하지 않는 경우
    dfs(n+1, sum)


T=int(input())
for t in range(1,T+1):
    N, K = map(int,input().split())
    lst=list(map(int,input().split()))
    ans = 0
    dfs(0,0)
    print(f'#{t} {ans}')