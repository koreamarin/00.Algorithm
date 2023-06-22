N=int(input())

N -= 2
peel=1
for i in range(1, 100000) :
    if N<0 :
        print(peel)
        break
    a=i*6
    N-=a
    peel+=1