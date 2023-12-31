import sys

N = int(input())
deq = []
for _ in range(N):
    C = sys.stdin.readline().split()
    if C[0] == "push_front":
        deq.insert(0, C[1])
    elif C[0] == "push_back":
        deq.append(C[1])
    elif C[0] == "pop_front":
        if deq:
            print(deq.pop(0))
        else:
            print(-1)
    elif C[0] == "pop_back":
        if deq:
            print(deq.pop())
        else:
            print(-1)
    elif C[0] == "size":
        print(len(deq))
    elif C[0] == "empty":
        if deq:
            print(0)
        else:
            print(1)
    elif C[0] == "front":
        if deq:
            print(deq[0])
        else:
            print(-1)
    elif C[0] == "back":
        if deq:
            print(deq[-1])
        else:
            print(-1)
