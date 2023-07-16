sum_list=[]
max_num=0
max_row=0
max_column=0
for i in range(9):
    A_list=list(map(int,input().split()))
    sum_list.append(A_list)

for row in range(len(sum_list)):
    for column in range(len(sum_list[row])) :
        if sum_list[row][column] > max_num :
            max_num=sum_list[row][column]
            max_row=row
            max_column=column

print(max_num)
print(f"{max_row+1} {max_column+1}")