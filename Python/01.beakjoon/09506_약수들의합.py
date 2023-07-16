while True :
    num = int(input())
    if num == -1 :
        break

    list=[i for i in range(1, num) if num%i==0]
    total=0
    for l in list :
        total+=l
    if total == num :
        print(f"{num} = ", end="")
        for i in range(len(list)) :
            print(f"{list[i]}", end="")
            if i != len(list)-1 :
                print(" + ", end="")
        print()
    elif total != num :
        print(f"{num} is NOT perfect.")