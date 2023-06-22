N=int(input())

for n in range(1, N+1):
    if '3' in str(n) or '6' in str(n) or '9' in str(n):
        print((str(n).count('3')+str(n).count('6')+str(n).count('9'))*'-', end=" ")
    else :
        print(n, end=" ")