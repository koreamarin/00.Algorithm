import sys
D=set()
for _ in range(int(sys.stdin.readline())) :
    A,B=sys.stdin.readline().split()
    if A== 'ChongChong' or B == 'ChongChong' :
        D.add(A)
        D.add(B)
    if A in D :
        D.add(B)
    elif B in D :
        D.add(A)
print(len(D))