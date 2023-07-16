word_list=[]
for _ in range(5) :
    word=input()
    word_list.append(word)


for column in range(15) :
    for word in word_list :
        try :
            print(word[column], end="")
        except :
            pass
print()