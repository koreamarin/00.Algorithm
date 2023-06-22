A,B,V=map(int,input().split())
C=A-B
V-=A
i=V//C+1
if V%C !=0 :
    i+=1
print(i)