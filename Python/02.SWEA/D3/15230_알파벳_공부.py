T = int(input())

alphabet = 'abcdefghijklmnopqrstuvwxyz'

for t in range(T) :
    word = input()
    length_word = len(word)
    i=0
    for i in range(1,length_word+1) :
        if alphabet[i-1] != word[i-1] :
            i-=1
            break
    print(f"#{t+1} {i}")
        