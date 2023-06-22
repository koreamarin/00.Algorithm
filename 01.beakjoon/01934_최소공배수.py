T=int(input())
for _ in range(T) :
    A,B=map(int,input().split())
    a,b=A,B
    while b!=0 :    # 최대공약수를 구하는 반복문. 둘 중 작은 수가 0이 될때까지 반복하면 a가 최대공약수가 된다.
        a,b = b,a%b
    print((A*B//a))