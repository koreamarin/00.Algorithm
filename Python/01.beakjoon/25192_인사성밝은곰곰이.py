import sys
N=int(sys.stdin.readline().strip())
L=set()
c=0
for _ in range(N) :
    W=sys.stdin.readline().strip()
    if W=="ENTER" :
        c+=len(L)
        L.clear()
    elif W!="ENTER" :
        L.add(W)
print(len(L)+c)