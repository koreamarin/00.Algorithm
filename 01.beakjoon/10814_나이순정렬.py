import sys
member_list=[sys.stdin.readline().split() for _ in range(int(sys.stdin.readline()))]
member_list.sort(key=lambda x:int(x[0]))
for l in member_list :
    print(*l)