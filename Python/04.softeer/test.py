import sys

n, q = map(int, input().split())
rate=list(map(int, input().split()))
Min = min(rate)
Max = max(rate)

for _ in range(q) :
    m=int(input())
    if m<=Min || m>=Max :
        print(0)
        continue
    else : 
        # 아래개수 구하기
        # 위 개수 구하기
        down = 0
        up = 0
        exist = False
        for r in rate :
            if m > r :
                down++
            elif m < r :
                up++
            elif m==r :
                exist=True
        if exist==False :
            print(0)
            continue
        print(down * up)        # 아래 개수 X 위 개수를 출력하기
            
        
       

        
    