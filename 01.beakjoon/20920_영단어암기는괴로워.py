import sys
N,M=map(int,sys.stdin.readline().split())

D={}

for _ in range(N) :
    W=sys.stdin.readline().strip()
    if len(W) >= M :
        if W in D.keys() :
            D[W] +=1
        else :
            D[W] =1
D=sorted(D.items(), key=lambda x : (-x[1], -len(x[0]), x[0]))
for d in D :
    print(d[0])