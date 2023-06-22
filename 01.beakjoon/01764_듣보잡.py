import sys
N,M=map(int, sys.stdin.readline().strip().split())
not_hear_people=[sys.stdin.readline().strip() for _ in range(N)]
not_meet_people=[sys.stdin.readline().strip() for _ in range(M)]
not_person=list(set(not_hear_people)&set(not_meet_people))
print(len(not_person),*sorted(not_person),sep="\n")