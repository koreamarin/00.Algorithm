def solution(n, m, section):
    L = [1] * n
    for s in section:
        L[s - 1] = 0

    sum = 0

    for i in range(n):
        if L[i] == 0:
            sum += 1
            for j in range(m):
                if i + j < n:
                    L[i + j] = 1

    return sum


n = 8
m = 4
section = [2, 3, 6]
print(solution(n, m, section))
