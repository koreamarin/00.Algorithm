import sys
from collections import deque
N=int(sys.stdin.readline().strip())
L=deque([])
for _ in range(N):
    C=sys.stdin.readline().strip().split()
    if C[0]=="pop" :
        if len(L)==0 :
            print(-1)
        else :
            print(L[0])
            del L[0]

    elif C[0]=="front" :
            print(-1 if len(L)==0 else L[0])

    elif C[0]=="back" :
        print(-1 if len(L)==0 else L[-1])

    elif C[0]=="size" :
        print(len(L))

    elif C[0]=="empty" :
        print(1 if len(L)==0 else 0)

    elif C[0]=="push" :
        L.append(C[1])