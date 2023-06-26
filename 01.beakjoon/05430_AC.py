import sys


def commend(P, arr):
    reverse = False
    for p in P:
        if p == "R":
            if reverse == False:
                reverse = True
            elif reverse == True:
                reverse = False
        elif p == "D":
            if not arr:
                return "error"
            elif arr:
                if reverse == True:
                    arr.pop()
                elif reverse == False:
                    arr.pop(0)
    if reverse == True:
        arr.reverse()
    return "[" + ",".join(map(str, arr)) + "]"


T = int(input())
for t in range(1, T + 1):
    P = list(sys.stdin.readline())
    sys.stdin.readline()
    arr = eval(sys.stdin.readline())

    print(commend(P, arr))
