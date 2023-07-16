import sys
N=int(sys.stdin.readline())

d={}

for _ in range(N) :
    name, entry_status = sys.stdin.readline().split()
    if entry_status == 'enter' :
        d[name]=True
    else :
        d[name]=False

attendance=[]
for key, value in d.items() :
    if value == True :
        attendance.append(key)
attendance.sort(reverse=True)
print(*attendance, sep='\n')