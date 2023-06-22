import math

def confirm(N):
    N=[n for n in str(N)]
    for i in range(len(N)//2):
        if N[i] != N[-1-i]:
            return False
    return True


T=int(input())
for t in range(1,T+1):
    A,B=map(int,input().split())
    R=0
    for n in range(A,B+1):
        if confirm(n):
            sqrt_n=math.sqrt(n)
            if sqrt_n==int(sqrt_n):
                if confirm(int(sqrt_n)):
                    R+=1
    print(f"#{t} {R}")
            
