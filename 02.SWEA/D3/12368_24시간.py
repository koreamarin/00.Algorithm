for t in range(1, int(input())+1):
    print(f'#{t} {sum(map(int,input().split()))%24}')