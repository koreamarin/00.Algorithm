import itertools

arr = [1, 2, 3]
for p in itertools.permutations(arr,2) :
  print(p, end=" ")

print() 

for c in itertools.combinations(arr,2) : 
  print(c, end=" ")
  
print()

for pp in itertools.product(arr, repeat=2) :
  print(pp, end=" ")

print()

for cc in itertools.combinations_with_replacement(arr, 2) :
  print(cc, end=" ")