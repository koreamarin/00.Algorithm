def recursion(word, l, r):
    global n
    n += 1
    if l >= r:
        return 1
    elif word[l] != word[r]:
        return 0
    else:
        return recursion(word, l + 1, r - 1)


def isPalindrome(word):
    return recursion(word, 0, len(word) - 1)


T = int(input())
for t in range(1, T + 1):
    word = input()
    n = 0
    print(isPalindrome(word), n)
