import sys
N=int(sys.stdin.readline())
A=[0]*8001
for n in range(N) :
    A[int(sys.stdin.readline())+4000] += 1

sum=0
for i in range(8001) :
    if A[i] != 0:
        sum+=A[i]*(i-4000)
print(round(sum/N))

B=[]
for i in range(8001) :
    if A[i] != 0:
        for _ in range(A[i]) :
            B.append(i-4000)
print(B[N//2])

high_frequency=0
C=[]
for i in range(8001) :
    if A[i] > high_frequency :
        high_frequency=A[i]
        C=[i]
    elif A[i] == high_frequency :
        C.append(i)
if len(C) == 1 :
    print(C[0]-4000)
else :
    C.sort()
    print(C[1]-4000)


max_num=0
min_num=0
for i in range(8001) :
    if A[i] != 0:
        min_num=i-4000
        break
for i in range(8001) :
    if A[8000-i] != 0:
        max_num=4000-i
        break
print(max_num - min_num)