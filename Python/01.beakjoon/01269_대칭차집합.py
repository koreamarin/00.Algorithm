import sys
sys.stdin.readline()
A=list(map(int,sys.stdin.readline().split()))
B=list(map(int,sys.stdin.readline().split()))
print(len(list((set(A)|set(B))-(set(A)&set(B)))))