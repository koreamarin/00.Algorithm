import sys
A=[int(sys.stdin.readline()) for _ in range(int(input()))]
A.sort()
print(*A,sep="\n")