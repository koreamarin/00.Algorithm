bc={
    "A":0,
    "B":1,
    "C":2,
    "D":3,
    "E":4,
    "F":5,
    "G":6,
    "H":7,
    "I":8,
    "J":9,
    "K":10,
    "L":11,
    "M":12,
    "N":13,
    "O":14,
    "P":15,
    "Q":16,
    "R":17,
    "S":18,
    "T":19,
    "U":20,
    "V":21,
    "W":22,
    "X":23,
    "Y":24,
    "Z":25,
    "a":26,
    "b":27,
    "c":28,
    "d":29,
    "e":30,
    "f":31,
    "g":32,
    "h":33,
    "i":34,
    "j":35,
    "k":36,
    "l":37,
    "m":38,
    "n":39,
    "o":40,
    "p":41,
    "q":42,
    "r":43,
    "s":44,
    "t":45,
    "u":46,
    "v":47,
    "w":48,
    "x":49,
    "y":50,
    "z":51,
    "0":52,
    "1":53,
    "2":54,
    "3":55,
    "4":56,
    "5":57,
    "6":58,
    "7":59,
    "8":60,
    "9":61,
    "+":62,
    "/":63,

}

def conv_DeciToBinary(Deci_list):
    binary_list=[]
    for n in Deci_list:
        a=[]
        for i in range(5,-1,-1):
            if n//(2**i)==1:
                a.append(1)
                n-=(2**i)
            elif n//(2**i)==0:
                a.append(0)
        binary_list.append(a)
    return binary_list

T=int(input())
for t in range(1, T+1):
    enc_word=input()
    Deci_list=[bc[w] for w in enc_word]
    bit6_binary_list=conv_DeciToBinary(Deci_list)
    bit8_binary_list=[]
    for i in range(len(enc_word)//4):
        bit8_binary_list.append(f"{str(bit6_binary_list[0+(4*i)][0])}{str(bit6_binary_list[0+(4*i)][1])}{str(bit6_binary_list[0+(4*i)][2])}{str(bit6_binary_list[0+(4*i)][3])}{str(bit6_binary_list[0+(4*i)][4])}{str(bit6_binary_list[0+(4*i)][5])}{str(bit6_binary_list[1+(4*i)][0])}{str(bit6_binary_list[1+(4*i)][1])}")
        bit8_binary_list.append(f"{str(bit6_binary_list[1+(4*i)][2])}{str(bit6_binary_list[1+(4*i)][3])}{str(bit6_binary_list[1+(4*i)][4])}{str(bit6_binary_list[1+(4*i)][5])}{str(bit6_binary_list[2+(4*i)][0])}{str(bit6_binary_list[2+(4*i)][1])}{str(bit6_binary_list[2+(4*i)][2])}{str(bit6_binary_list[2+(4*i)][3])}")
        bit8_binary_list.append(f"{str(bit6_binary_list[2+(4*i)][4])}{str(bit6_binary_list[2+(4*i)][5])}{str(bit6_binary_list[3+(4*i)][0])}{str(bit6_binary_list[3+(4*i)][1])}{str(bit6_binary_list[3+(4*i)][2])}{str(bit6_binary_list[3+(4*i)][3])}{str(bit6_binary_list[3+(4*i)][4])}{str(bit6_binary_list[3+(4*i)][5])}")
    print(f'#{t}', end=" ")
    for i in bit8_binary_list:
        print(chr(int(i,2)), end="")
    print()