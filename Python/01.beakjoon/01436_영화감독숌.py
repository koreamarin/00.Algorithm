N=int(input())
for i in range(666,10**100) :
    if i%1000==666 or (i%10000)//10==666 or (i%100000)//100==666 or (i%1000000)//1000==666:
        N-=1
        if N==0 :
            print(i)
            break