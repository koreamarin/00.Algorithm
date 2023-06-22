A,B=map(int,input().split())
a,b = A,B
while b!=0 :
    a,b = b, a%b
print(A*B//a)