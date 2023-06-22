def command_div(cmd_OL):
    cmd_L=[]
    for i in range(len(cmd_OL)):
        if cmd_OL[i]=='A':
            y=int(cmd_OL[i+1])
            L=[cmd_OL[i],y]
            for j in range(y):
                L.append(int(cmd_OL[i+2+j]))
            cmd_L.append(L)

        elif cmd_OL[i]=='D':
            cmd_L.append([cmd_OL[i],int(cmd_OL[i+1]),int(cmd_OL[i+2])])
        
        elif cmd_OL[i]=='I':
            x=int(cmd_OL[i+1])
            y=int(cmd_OL[i+2])
            L=[cmd_OL[i],x,y]
            for j in range(y):
                L.append(int(cmd_OL[i+3+j]))
            cmd_L.append(L)
    return cmd_L

def command_perform(org_C, cmd_L):
    L=org_C
    for c in cmd_L:
        if c[0]=='I':
            x=c[1]
            S_L=c[3:]
            for i in range(len(S_L)-1,-1,-1):
                L.insert(x+1,S_L[i])
        elif c[0]=='D':
            x=c[1]
            y=c[2]
            for i in range(y):
                L.pop(x+1)
        elif c[0]=='A':
            y=c[1]
            S_L=c[2:]
            for l in S_L:
                L.append(l)

    return org_C[:10]

for t in range(1,11):
    N=int(input())
    org_C=list(map(int,input().split()))
    cmd_N=int(input())
    cmd_L=command_div(list(input().split()))
    L=command_perform(org_C, cmd_L)
    print(f'#{t} {L}')