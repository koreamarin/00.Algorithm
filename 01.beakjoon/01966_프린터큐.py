T = int(input())
for t in range(1, T + 1):
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))
    n = 0

    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            if arr[i] < arr[j]:
                arr.append(arr.pop(0))
                print(arr)
            # else:
            #     arr.pop(0)
            #     n += 1
    print(n)
