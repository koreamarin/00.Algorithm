x1, y1 = map(int,input().split())
x2, y2 = map(int,input().split())
x3, y3 = map(int,input().split())

diff_x = 0
diff_y = 0

if x1 == x2 :
    diff_x = x3
elif x1 == x3 :
    diff_x = x2
else :
    diff_x = x1

if y1 == y2 :
    diff_y = y3
elif y1 == y3 :
    diff_y = y2
else :
    diff_y = y1

print(diff_x, diff_y)