def confirm(W):
    for i in range(2,11):
        new = str(int(W) * i)
        # 만약 갯수가 다르면 멈춘다. 자리수가 더 커졌을 경우에 인덱스가 같을 경우도 존재하므로 이 명령어를 넣어야 한다.
        if len(new) != len(W):
            return False
        # 리스트의 요소가 같은지
        if set(new) == set(W):
            return True

T=int(input())
for t in range(1,T+1):
    W=input()
    if confirm(W) :
        print(f'#{t} possible')
    else :
        print(f'#{t} impossible')