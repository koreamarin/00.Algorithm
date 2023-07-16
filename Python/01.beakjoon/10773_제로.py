import sys
K=int(sys.stdin.readline().strip())
L=[]
for _ in range(K) :
    N=int(sys.stdin.readline().strip())
    if N==0:
        del L[-1]
    else :
        L.append(N)
print(sum(L))