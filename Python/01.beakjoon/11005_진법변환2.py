C=['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
N,B=map(int,input().split())
sum=[]
for i in range(100,-1,-1) :
    sum.append(C[N//(B**i)])
    N-=(B**i)*(N//(B**i))
for s in range(len(sum)) :
    if sum[s] != '0' :
        sum=sum[s:]
        break
print(*sum,sep='')