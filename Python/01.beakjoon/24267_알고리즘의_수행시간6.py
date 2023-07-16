n=int(input())-1
list=[((n-i)*(n-(n-i))) for i in range(1,n+1)]
print(sum(list), 3 ,sep="\n")