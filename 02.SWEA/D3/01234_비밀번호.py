for t in range(1,11):
    N,W=input().split()
    L=[]
    for w in W:
        if L and w == L[-1]:
            L.pop()
        else : 
            L.append(w)
    R=''.join(L)
    print(f'#{t} {R}')