def confirm(W,sw,i):
    for j in range(len(sw)):
        if W[i+j]!=sw[j]:
            return False
    return True

for _ in range(1,11):
    t=int(input())
    sw=[i for i in input()]
    W=[i for i in input()]
    n=0
    for i in range(len(W)-len(sw)+1):
        if W[i]==sw[0]:
            if confirm(W,sw,i):
                n+=1
    print(f'#{t} {n}')

