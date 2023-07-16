N,i=int(input()),1
while i<N:
    i *= 2
print(2*N-i)

# 2번째 방법
# N=int(input())
# i=0
# while N-(2**i) > (2**i) :
#     i+=1
# if N==1 :
#     print(1)
# else :
#     print(2*(N-(2**i)))