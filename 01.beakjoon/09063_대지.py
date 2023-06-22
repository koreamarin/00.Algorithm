x_list = []
y_list = []

for n in range(int(input())) :
    x,y = input().split()
    x_list.append(int(x))
    y_list.append(int(y))

print( (max(x_list) - min(x_list)) * (max(y_list) - min(y_list)))