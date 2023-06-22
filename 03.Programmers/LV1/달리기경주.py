def solution(players, callings):
    A = {player: rank for rank, player in enumerate(players)}
    for c in callings:
        idx = A[c]
        A[c] -= 1
        A[players[idx - 1]] += 1
        players[idx - 1], players[idx] = players[idx], players[idx - 1]
    return players


players = ["mumu", "soe", "poe", "kai", "mine"]
callings = ["kai", "kai", "mine", "mine"]
print(solution(players, callings))
