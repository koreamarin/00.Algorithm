import sys
sys.stdin.readline()
w=list(map(int,sys.stdin.readline().split()))
w2=sorted(list(set(w.copy())))
nd={}
for j in range(len(w2)) :
    nd[w2[j]] = j
    
for i in w :
    print(nd[i], end=" ")