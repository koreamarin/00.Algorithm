A,B=map(int,input().split())
C,D=map(int,input().split())

def gcd(n1,n2) :
    if n2>n1 :
        n1, n2 = n2, n1
    if n2==0 :
        return n1
    return gcd(n2, n1%n2)

g=gcd(A*D+C*B,B*D)
print((A*D+C*B)//g, (B*D)//g)