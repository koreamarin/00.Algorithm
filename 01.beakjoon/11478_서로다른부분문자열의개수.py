S=input()
P=[]
for i in range(1,len(S)+1) :
    for j in range(i) :
        P.append(S[j:i])
print(len(list(set(P))))