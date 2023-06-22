valid_day={
    1 : 31,
    2 : 28,
    3 : 31,
    4 : 30,
    5 : 31,
    6 : 30,
    7 : 31,
    8 : 31,
    9 : 30,
    10 : 31,
    11 : 30,
    12 : 31
}
T=int(input())
for t in range(T):
    D=input()
    year = D[0:4]
    month = D[4:6]
    day = D[6:]
    if 0 < int(month) < 13 and valid_day[int(month)] >= int(day):
        print(f'#{t+1} {year}/{month}/{day}')
    else :
        print(f'#{t+1} -1')