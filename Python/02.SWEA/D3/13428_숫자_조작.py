T=int(input())
for t in range(1, T+1):
    N=[n for n in input()]
    # NL 리스트에 입력 포함하여 넣기.
    NL=[N]

    # 1번 바꿔서 나올 수 있는 경우의 수를 모두 NL 리스트에 저장. 단, 맨 앞인덱스가 0인 경우에는 저장하지 않음.
    for i in range(len(N)):
        for j in range(i+1,len(N)):
            A=N.copy()
            A[i],A[j]=A[j],A[i]
            if A[0]!='0':
                NL.append(A)
    
    # NL인덱스의 중복제거.
    L=list(set([''.join(w for w in W) for W in NL]))
    # L 리스트의 최대값, 최소값 출력
    print(f'#{t} {min(L)} {max(L)}')
