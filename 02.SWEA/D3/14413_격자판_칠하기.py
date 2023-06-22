
# '#' 또는 '.'을 발견하면 #과 .의 좌표가 짝수인지, 홀수인지 알아내서 짝수이면 0을, 홀수이면 1을 딕셔너리D에 넣어 반환한다.
def even(MAP,N,M):
    D={}
    for i in range(N):
        for j in range(M):
            if MAP[i][j]=='.':
                if (i+j)%2==0:
                    D['.']=0
                    D['#']=1
                elif (i+j)%2==1:
                    D['#']=0
                    D['.']=1
            elif MAP[i][j]=='#':
                if (i+j)%2==0:
                    D['.']=1
                    D['#']=0
                elif (i+j)%2==1:
                    D['.']=0
                    D['#']=1
    return D

# .과 #의 위치가 짝수인지, 홀수인지에 대한 데이터가 있는 딕셔너리 D를 가지고 모든 인덱스를 loof하며 위치를 비교한다.
# 만약 딕셔너리 D에 해당하지 않는 위치에 있는 #또는 .를 발견한다면 False를 반환하고, 모든 위치가 정상적이라면 True를 반환한다.
def confirm(MAP,D):
    for i in range(N):
        for j in range(M):
            if MAP[i][j] == '#' and (i+j)%2==D['.']:
                return False
            if MAP[i][j] == '.' and (i+j)%2==D['#']:
                return False
    return True

T=int(input())
for t in range(1,T+1):
    N,M=map(int,input().split())
    MAP=[[w for w in input()] for _ in range(N)]
    D=even(MAP,N,M)
    print(f'#{t} possible' if confirm(MAP,D) else f'#{t} impossible')
