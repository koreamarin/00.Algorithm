N, M = map(int, input().split())
num_list = list(map(int, input().split()))
rmv_list = []

for num in num_list :
    if num >= M-2 :
        rmv_list.append(num)

num_list = list(set(num_list) - set(rmv_list))
max_sum_num = 0

for i in range(N-2) :
    for j in range(i+1, N-1) :
        for k in range(j+1,N) :
            sum_num = num_list[i] + num_list[j] + num_list[k]
            if sum_num <= M and sum_num > max_sum_num:
                max_sum_num = sum_num

print(max_sum_num)