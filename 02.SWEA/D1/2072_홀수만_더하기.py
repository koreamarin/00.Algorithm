for t in range(int(input())):
    sum = 0
    for a in list(map(int, input().split())) :
        if a % 2 == 1:
            sum+=a
    print(f'#{t+1} {sum}')