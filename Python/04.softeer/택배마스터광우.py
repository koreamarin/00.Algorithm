import sys, itertools
# 순열을 이용해서 순서를 레일 순서를 바꿔가면서 계산한다.
# 3<=N<=10, 1<=K<=50, 1<=Ni<=50
N, M, K = map(int, input().split())
rails = list(map(int, input().split()))
Min = sys.maxsize
for p in itertools.permutations(rails, N) :
    i=0
    ssum=0
    for _ in range(K) : 
        sum=0
        while(True) :
            if sum + p[i] > M :
                break
            else :
                sum += p[i]
                i = (i+1) % N
        ssum+=sum
    Min = min(Min, ssum)
print(Min)