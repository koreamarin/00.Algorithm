def location(MAP,N):
    Lo=[]
    for i in range(N):
        A=[]
        for j in range(N):
            if MAP[i][j]=='#':
                A.append([i,j])
        if len(A)>0:
            Lo.append(A)
    return Lo

def confirm(Lo):
    if len(Lo)==0:
        return False
    
    I=len(Lo)
    J=len(Lo[0])
    if I != J:
        return False
    
    # 가로 검사
    for i in range(I):
        for j in range(I):
            if j+1 < I and Lo[i][j][1] != Lo[i][j+1][1]-1:
                return False
            
    # 세로 검사
    for j in range(I):
        for i in range(I):
            if i+1 < I and Lo[i][j][0] != Lo[i+1][j][0]-1:
                return False
    return True



T=int(input())
for t in range(1,T+1):
    N=int(input())
    MAP=[[w for w in input()] for _ in range(N)]
    Lo=location(MAP,N)
    print(f'#{t} yes' if confirm(Lo) else f'#{t} no')
