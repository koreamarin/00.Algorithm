A,B,C=map(int,input().split())

if A+B+C<=2*max(A,B,C) :
    print((A+B+C-max(A,B,C))*2-1)
else :
    print(A+B+C)