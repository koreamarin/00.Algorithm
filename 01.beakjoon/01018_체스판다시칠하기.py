H,W=map(int, input().split())

board = []

for h in range(H) :
    board.append(input())

min=100
chess_list=[]
for w in range(W-7) :
    for h in range(H-7) :
        chess=[board[h][w:w+8],board[h+1][w:w+8],board[h+2][w:w+8],board[h+3][w:w+8],board[h+4][w:w+8],board[h+5][w:w+8],board[h+6][w:w+8],board[h+7][w:w+8]]
        chess_list.append(chess)

for chess_board in chess_list :
    wordA=list(chess_board[0]+chess_board[1]+chess_board[2]+chess_board[3]+chess_board[4]+chess_board[5]+chess_board[6]+chess_board[7])
    m=0
    for i in range(len(wordA)-1) :
        if i % 8 != 7 :
            if wordA[i] == wordA[i+1] == 'W':
                wordA[i+1] = 'B'
                m+=1
            elif wordA[i] == wordA[i+1] == 'B':
                wordA[i+1] = 'W'
                m+=1
        elif i % 8 == 7 :
            if wordA[i] != wordA[i+1] :
                wordA[i+1] = wordA[i]
                m+=1
    if m < min :
        min = m


    wordB=list(chess_board[0]+chess_board[1]+chess_board[2]+chess_board[3]+chess_board[4]+chess_board[5]+chess_board[6]+chess_board[7])
    if wordB[0] == 'W' :
        wordB[0] = 'B'
    elif wordB[0] == 'B' :
        wordB[0] = 'W'
    m=1
    for i in range(len(wordB)-1) :
        if i % 8 != 7 :
            if wordB[i] == wordB[i+1] == 'W':
                wordB[i+1] = 'B'
                m+=1
            elif wordB[i] == wordB[i+1] == 'B':
                wordB[i+1] = 'W'
                m+=1
        elif i % 8 == 7 :
            if wordB[i] != wordB[i+1] :
                wordB[i+1] = wordB[i]
                m+=1
    if m < min :
        min = m

print(min)