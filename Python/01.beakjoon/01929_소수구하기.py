M,N = map(int, input().split())

def spn(N) :
    if N == 0 or N == 1 :
        return False
    for i in range(2, int((N**0.5)+1)) :
        if N%i == 0:
            return False
    return True

for i in range(M,N+1) :
    if spn(i) :
        print(i)