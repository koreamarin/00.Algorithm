T=int(input())
for t in range(1,T+1):
    W=input()
    N=len(W)
    row_0='..'+('#...'*(N-1))+'#..'
    row_1='.'+('#.'*(N*2))
    row_3=row_1
    row_4=row_0
    row_2='#'
    for w in W:
        row_2+='.'+w+'.#'
    print(row_0)
    print(row_1)
    print(row_2)
    print(row_3)
    print(row_4)