import copy

def result_num_pt(copy_num) :
    result_num=0
    for n in range(len(copy_num)) :
        result_num += copy_num[n]*(10**(len(copy_num)-n-1))
    return result_num

T = int(input())

for t in range(1, T+1) :
    num, chance = input().split()
    chance = int(chance)
    cases=[]
    num=list(map(int, num))
    cases.append(num)
    c=0

    while c!=chance :
        c_list=[]
        for i in range(len(num)-1) :
            for j in range(i+1, len(num)) :
                copy_num = copy.deepcopy(cases)
                for co in copy_num :
                    co[i], co[j] = co[j],co[i]
                    if co not in c_list :
                        c_list.append(co)
        cases = c_list
        c+=1


    print(f"#{t} {result_num_pt(max(cases))}")