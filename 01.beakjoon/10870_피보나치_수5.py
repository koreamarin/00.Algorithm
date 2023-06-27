def fibonachi(N):
    if N >= 2:
        return fibonachi(N - 2) + fibonachi(N - 1)
    return N


print(fibonachi(int(input())))
