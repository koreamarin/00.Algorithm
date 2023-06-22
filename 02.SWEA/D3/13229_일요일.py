D={
    'MON':6,
    'TUE':5,
    'WED':4,
    'THU':3,
    'FRI':2,
    'SAT':1,
    'SUN':7
}
T=int(input())
for t in range(1,T+1):
    print(f'#{t} {D[input()]}')