# list -
    #1. used to store multiple values in the siungle variable
    #2. store inside []
    #3. duplicates are allowed
    #4. after creating list we can add,update, delete elements : mutable
numbers_list = []
print(numbers_list)
numbers_list = [79,6,79]
print(numbers_list)
numbers_list.append(9)
print(numbers_list)

#[79,6,79,9]---> here 79 is at position/index 0,6 at index 1, 79 at index 2 and so on....
# 0, 1,2, 3

numbers_list.insert(0, 42) #add 42 at index 0
print(numbers_list)

numbers_list_copy=numbers_list.copy()
print(numbers_list_copy)

count_9=numbers_list.count(9)
print(count_9)

count_79=numbers_list.count(79)
print(count_79)

numbers_list.extend([33,44,55])
print(numbers_list)

index_of_6=numbers_list.index(6)
print(index_of_6)

index_of_79=numbers_list.index(79)
print(index_of_79)


numbers_list.pop() # removes last element
print(numbers_list)

numbers_list.remove(42) # removes given element with its first occurance
print(numbers_list)

numbers_list.remove(79) # removes given element with its first occurance
print(numbers_list)

numbers_list.reverse()
print(numbers_list)

numbers_list.sort()
print(numbers_list)

numbers_list.clear()
print(numbers_list)

