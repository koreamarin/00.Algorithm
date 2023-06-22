import sys
A=[list(reversed(list(map(int,sys.stdin.readline().strip().split())))) for _ in range(int(sys.stdin.readline()))]
for a in sorted(A) :
    print(*list(reversed(a)))