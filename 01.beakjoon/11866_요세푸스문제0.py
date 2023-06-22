N,K=map(int,input().split())
L=[l for l in range(1, N+1)]
R=[]
M=0
i=0
while len(L)!=0:
    if i==K-1 :
        M=(M+i)%len(L)
        R.append(L[M])
        del L[M]
        i=0
    i+=1

print("<", end="")
for r in range(len(R)) :
    if r!=len(R)-1 :
        print(R[r],end=", ")
    else:
        print(R[r],end=">")