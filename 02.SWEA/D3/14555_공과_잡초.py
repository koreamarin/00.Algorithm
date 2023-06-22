T=int(input())
for t in range(1,T+1):
    word=[w for w in input()]
    for w in range(len(word)):
        if word[w]=='(' and word[w+1]=='|':
            word[w+1]=')'
        elif word[w]==')' and word[w-1]=='|':
            word[w-1]='('
    N=0
    for w in range(len(word)):
        if word[w]=='(' and word[w+1]==')':
            N+=1
    print(f'#{t} {N}')