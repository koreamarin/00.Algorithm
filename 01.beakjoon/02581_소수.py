def spn(num) :
    if num == 1 :
        return False
    for n in range(2, num) :
        if num%n == 0 :
            return False
    return True

list=[]

for i in range(int(input()), int(input())+1) :
    if spn(i) == True :
        list.append(i)


if len(list) == 0 :
    print(-1)

else :
    print(sum(list))
    print(min(list))