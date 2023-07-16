T=int(input())
for t in range(1,T+1):
    status='yes'
    word1, word2=input().split()
    word1_length=len(word1)
    word2_length=len(word2)
    iterations = word2_length * word1_length

    for iterration_num in range(iterations) :
        if word1[iterration_num%word1_length] != word2[iterration_num%word2_length] :
            status='no'
            break

    print(f"#{t} {status}")
