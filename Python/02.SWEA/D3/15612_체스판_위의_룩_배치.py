for t in range(1, int(input())+1):
    chessboard=[]

    rook_existence_row = []
    rook_existence_column = []

    for r in range(8) :
        chessboard.append(input())
        
    
    rook_amount = 0
    for row in range(8) :
        for column in range(8) :
            if chessboard[row][column] == 'O':
                rook_amount+=1
                rook_existence_row.append(row)
                rook_existence_column.append(column)

    if rook_amount != 8 :
        print(f"#{t} no")
        continue

    
    
    for row in rook_existence_row :
        row_rook=0
        for column in range(8) :
            if chessboard[row][column] == 'O':
                row_rook+=1
        if row_rook > 1 :
            print(f"#{t} no")
            break
    if row_rook > 1 :
        continue

    for column in rook_existence_column :
        column_rook=0
        for row in range(8) :
            if chessboard[row][column] == 'O':
                column_rook+=1
        if column_rook > 1 :
            print(f"#{t} no")
            break
    if column_rook > 1 :
        continue

    print(f"#{t} yes")