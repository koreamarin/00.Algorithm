T = int(input())

bg_paper_location = [[x, y] for x in range(100) for y in range(100)]


for t in range(T) :
    x,y = list(map(int, input().split()))
    for x_veriate_location in range(x,x+10):
        for y_veriate_location in range(y, y+10):
            if [x_veriate_location,y_veriate_location] in bg_paper_location :
                bg_paper_location.remove([x_veriate_location,y_veriate_location])

print(10000-len(bg_paper_location))