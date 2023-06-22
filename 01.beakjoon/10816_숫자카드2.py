import sys
sys.stdin.readline()
card_list = list(map(int,sys.stdin.readline().strip().split()))
sys.stdin.readline()
num_list= list(map(int,sys.stdin.readline().strip().split()))

card_amount_dict = {}
for card in card_list :
    if card in card_amount_dict.keys() :
        card_amount_dict[card] += 1
    else :
        card_amount_dict[card] = 1

for num in num_list :
    if num in card_amount_dict.keys() :
        print(card_amount_dict[num], end=" ")
    else :
        print(0, end=" ")