T=int(input())

for t in range(1, T+1):
    w=input()
    lw=len(w)
    s=True
    for i in range(lw//2):
        if w[i] != w[-1-i]:
            s=False
            break
    if s==False:
        print(f'#{t} 0')
    else:
        print(f'#{t} 1')