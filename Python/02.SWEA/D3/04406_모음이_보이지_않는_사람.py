T=int(input())
for t in range(1,T+1):
    print(f"#{t} {input().replace('a','').replace('e','').replace('i','').replace('o','').replace('u','')}")