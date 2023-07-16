def kantoe(arr):
    l = len(arr)
    A, B, C = arr[: (l // 3)], [""] * (l // 3), arr[((l * 2) // 3) :]
    print(A, B, C)


N = int(input())
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
kantoe(arr)
print(arr)
