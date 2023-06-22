def solution(name, yearning, photo):
    memory = {name[i]: yearning[i] for i in range(len(name))}
    l = []
    for p in photo:
        sum = 0
        for j in p:
            if j in memory:
                sum += memory[j]
        l.append(sum)
    return l


name = ["may", "kein", "kain", "radi"]
yearning = [5, 10, 1, 3]
photo = [
    ["may", "kein", "kain", "radi"],
    ["may", "kein", "brin", "deny"],
    ["kon", "kain", "may", "coni"],
]
print(solution(name, yearning, photo))
