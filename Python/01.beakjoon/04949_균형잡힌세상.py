while True:
    l=[]
    S=input()
    A=True
    if S=="." :
        break

    for s in S :
        if s == "(" :
            l.append('(')
        elif s == "[" :
            l.append('[')
        elif s == ")" :
            if len(l) > 0 :
                if l[-1] == "(" :
                    del l[-1]
                    continue
            A=False
            break
        elif s == "]" :
            if len(l) > 0 :
                if l[-1] == "[" :
                    del l[-1]
                    continue
            A=False
            break

    if len(l)>0 :
        A=False

    print('yes' if A==True else 'no')