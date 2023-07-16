def factorial(N) :
    f=1
    for n in range(2,N+1) :
        f*=n
    return f

for _ in range(int(input())) :
    N,M=map(int,input().split())
    print(factorial(M)//(factorial(N)*factorial(M-N)))