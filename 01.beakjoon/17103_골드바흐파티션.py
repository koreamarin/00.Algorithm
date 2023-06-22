import sys

def spn(N) :
    if N<=1 :
        return False
    for n in range(2,int(N**0.5)+1) :
        if N%n==0 :
            return False
    return True

T=int(sys.stdin.readline().strip())
N_list=[int(sys.stdin.readline().strip()) for _ in range(T)]

sosu_list = [i for i in range(2, max(N_list)+1) if spn(i)]

for N in N_list:
    slice_list=[]
    for i in range(len(sosu_list)) :
        if sosu_list[i]>N :
            slice_list=sosu_list[0:i]
            break
        elif i==len(sosu_list)-1 :
            slice_list=sosu_list.copy()
    count=0
    for i in range(len(slice_list)-1) :
        for j in range(i, len(slice_list)) :
            if slice_list[i] + slice_list[j] == N :
                count+=1
    print(count)