while True :
    A,B,C=map(int, input().split())

    if A==B==C==0 :
        break

    elif A+B+C > 2*max(A,B,C) :
        if A==B==C :
            print("Equilateral")
        elif A!=B and B!=C and C!=A :
            print("Scalene")
        else :
            print("Isosceles")
    else :
        print("Invalid")