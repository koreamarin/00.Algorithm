X=int(input())

line_num = 0
max_num = 0

while X > max_num :
    line_num+=1
    max_num += line_num

gap = max_num - X

if line_num % 2 == 0 :
    top = line_num - gap
    bottom = 1 + gap
elif line_num % 2 == 1 :
    top = 1 + gap
    bottom = line_num - gap

print(f"{top}/{bottom}")