# 시간초과를 해결하기 위해 에라토스테네스의 체 알고리즘을 활용하여 소수집합을 구하였다.


def spn(N):
    S = [True] * (N + 1)
    for i in range(2, int(N ** (1 / 2)) + 1):
        if S[i] == True:
            j = 2
            while i * j <= N:
                S[i * j] = False
                j += 1
    S[0], S[1] = False, False
    return S


T = int(input())
S = spn(1000000)
for t in range(1, T + 1):
    N = int(input())
    result = 0

    for i in range(2, int(N / 2) + 1):
        if S[i] == True and S[N - i] == True:
            result += 1
    print(result)
