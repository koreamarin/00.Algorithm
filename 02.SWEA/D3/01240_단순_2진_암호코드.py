def row_decode(arr,M):
    row=[i for i in arr]
    A=[]
    B=[]
    for i in range(M):
        if B and i%7==0:
            C=B.copy()
            if C==[0,0,0,1,1,0,1]:
                A.append(0)
            elif C==[0,0,1,1,0,0,1]:
                A.append(1)
            elif C==[0,0,1,0,0,1,1]:
                A.append(2)
            elif C==[0,1,1,1,1,0,1]:
                A.append(3)
            elif C==[0,1,0,0,0,1,1]:
                A.append(4)
            elif C==[0,1,1,0,0,0,1]:
                A.append(5)
            elif C==[0,1,0,1,1,1,1]:
                A.append(6)
            elif C==[0,1,1,1,0,1,1]:
                A.append(7)
            elif C==[0,1,1,0,1,1,1]:
                A.append(8)
            elif C==[0,0,0,1,0,1,1]:
                A.append(9)
            B.clear()
        B.append(int(row[i]))
    return A

def arr_decoder(ARR):
    dicode_ARR=[]
    for l in ARR:
        A=row_decode(l,M)
        if A:
            dicode_ARR.append(A)
    return dicode_ARR

T=int(input())
for t in range(1,T+1):
    N,M=map(int,input().split())
    ARR=[input() for _ in range(N)]
    dicode_ARR=arr_decoder(ARR)
    for code in dicode_ARR[0]:
        
