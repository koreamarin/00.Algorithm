import sys
G=[int(sys.stdin.readline().strip()) for _ in range(int(sys.stdin.readline().strip()))]
bt=[G[i+1]-G[i] for i in range(len(G)-1)]

def gcd(n1,n2) :
    if n2 > n1 :
        n1, n2 = n2, n1
    while n2 != 0 :
        n1, n2 = n2, n1%n2
    return n1

gcd1=bt[0]
for b in bt :
    gcd1=gcd(gcd1, b)

i=0
for b in bt :
    i+=(b//gcd1)-1

print(i)