def composite_number_checker(a):
    for i in range(2,a):
        if a%i==0:
            return True
    return False

T=int(input())
for t in range(1, T+1):
    N=int(input())
    for n in range(2,(10**9)+1):
        if composite_number_checker(n)==True and composite_number_checker(n+N)==True:
            print(f'#{t} {n+N} {n}')
            break