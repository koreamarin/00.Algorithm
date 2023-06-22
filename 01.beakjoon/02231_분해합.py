N=int(input())
for n in range(N) :
    if ((n//1000000)%10)+((n//100000)%10)+((n//10000)%10)+((n//1000)%10)+((n//100)%10)+((n//10)%10)+(n%10)+n == N :
        print(n)
        break
if n==N-1 :
    print(0)