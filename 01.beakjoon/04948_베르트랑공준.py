import sys

def spn(N) :
    if N==1 :
        return False
    for n in range(2,int(N**0.5)+1) :
        if N%n==0 :
            return False
    return True

A = [i for i in range(2,123456*2) if spn(i)]

while True :
    N=int(sys.stdin.readline().strip())
    if N==0:
        break
    i=0    
    for n in A :
        if N < n < (2*N)+1 :
            i+=1
    print(i)