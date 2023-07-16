import sys
word_list=[sys.stdin.readline().strip() for _ in range(int(sys.stdin.readline()))]
word_list=list(set(word_list)) #중복제거
word_list.sort(key=lambda x:(len(x),x)) #길이순, 사전순 정렬
print(*word_list,sep='\n')