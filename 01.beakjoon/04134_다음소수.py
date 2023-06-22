import sys

def spn(N) :
    if N==0 or N == 1 :
        return False
    for i in range(2,int((N**0.5)+1)) :
        if N%i==0 :
            return False
    return True

T=int(sys.stdin.readline().strip())
for t in range(T) :
    N=int(sys.stdin.readline().strip())
    while True :
        if spn(N) :
            print(N)
            break
        N+=1