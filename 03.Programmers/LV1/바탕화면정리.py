def solution(wallpaper):
    x_list, y_list = [], []

    for y in range(len(wallpaper)):
        for x in range(len(wallpaper[y])):
            if wallpaper[y][x] == "#":
                x_list.append(x)
                y_list.append(y)
    return [min(y_list), min(x_list), max(y_list) + 1, max(x_list) + 1]


wallpaper = ["..........", ".....#....", "......##..", "...##.....", "....#....."]
print(solution(wallpaper))
