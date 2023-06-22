input()
num_list=list(map(int,input().split()))
amount = len(num_list)
for num in num_list :
    if num == 1 :
        amount -=1
        continue

    for n in range(2, num) :
        if num%n == 0 :
            amount-=1
            break
print(amount)