import sys
N=int(sys.stdin.readline())
S=[]

for _ in range(N):
    C=sys.stdin.readline().strip().split()
    if len(C)>1 :
        S.append(int(C[1]))
    else :
        if C[0] == "top" :
            if len(S) == 0 :
                print(-1)
            else :
                print(S[-1])
        elif C[0] == "pop" :
            if len(S) == 0 :
                print(-1)
            else :
                print(S[-1])
                del S[-1]
        elif C[0] == "size" :
            print(len(S))
        elif C[0] == "empty" :
            if len(S) == 0 :
                print(1)
            else :
                print(0)