T=int(input())
for t in range(1, T+1):
    word = input()
    
    for i in range(1, 11):
        if word[i+1: (2*i)+1] == word[0:i]:
            print(f'#{t} {i+1}')
            break