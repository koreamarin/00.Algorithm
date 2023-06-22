import sys
N, M = map(int,sys.stdin.readline().split())

dogam={}
for i in range(1, N+1) :
    p=sys.stdin.readline().strip()
    dogam[p]=i
    dogam[i]=p


for _ in range(M) :
    test=sys.stdin.readline().strip()
    if test.isdigit() :
        print(dogam[int(test)])
    else :
        print(dogam[test])