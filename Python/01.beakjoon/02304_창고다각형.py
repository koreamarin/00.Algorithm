N=int(input())
pillar=[0] * 1001

for _ in range(N) :
    L, H = map(int,input().split())
    pillar[L] = H

max_L = pillar.index(max(pillar))
Wh_H=0
for l in range(max_L) :
    if Wh_H < pillar[l] :
        Wh_H=pillar[l]
    elif Wh_H >= pillar[l] :
        pillar[l]=Wh_H

Wh_H=0
for l in range(len(pillar)-1, max_L, -1) :
    if Wh_H < pillar[l] :
        Wh_H=pillar[l]
    elif Wh_H >= pillar[l] :
        pillar[l]=Wh_H

print(sum(pillar))