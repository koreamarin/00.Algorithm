TC = int(input())

for t in range(1, TC+1) :
    N = int(input())
    if N%2 == 0 :
        print(f"#{t} Alice")
    elif N%2 == 1 :
        print(f"#{t} Bob")