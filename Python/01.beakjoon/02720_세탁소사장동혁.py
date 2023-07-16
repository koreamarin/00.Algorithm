import sys
for _ in range(int(sys.stdin.readline())) :
    C=int(sys.stdin.readline())
    print(C//25, (C%25)//10, ((C%25)%10)//5, ((C%25)%10)%5)