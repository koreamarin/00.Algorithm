import sys

N=int(sys.stdin.readline().strip())
L=[]
error = False
i=1
R=[]

for _ in range(N) :
    if error == False :
        n=int(sys.stdin.readline().strip())
        while True :
            if i <= n :
                L.append(i)
                R.append("+")
                i+=1
            else :
                if L[-1] == n :
                    L.pop()
                    R.append("-")
                    break
                else : 
                    error = True
                    break

if error == True :
    print("NO")
else : 
    print(*R, sep="\n")