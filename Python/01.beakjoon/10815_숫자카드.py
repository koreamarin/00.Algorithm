import sys
sys.stdin.readline()
N=set(map(int,sys.stdin.readline().split()))
sys.stdin.readline()
M=list(map(int,sys.stdin.readline().split()))
for m in M :
    if m in N : 
        print(1, end=" ")
    else :
        print(0, end=" ")