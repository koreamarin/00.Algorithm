N,K=map(int,input().split())

def factorial(N) :
    f=1
    for n in range(2,N+1) :
        f*=n
    return f

print(factorial(N)//(factorial(K)*factorial(N-K)))