N, M = map(int, input().split())

A = list(map(int, input().split()))
deque, cnt = [i + 1 for i in range(N)], 0

while A:
    if deque[0] == A[0]:
        A.pop(0), deque.pop(0)

    else:
        l = len(deque) // 2
        while A[0] != deque[0]:
            if A[0] in deque[: l + 1]:
                deque.append(deque.pop(0))
                cnt += 1
            elif A[0] in deque[l + 1 :]:
                deque.insert(0, deque.pop())
                cnt += 1
print(cnt)
