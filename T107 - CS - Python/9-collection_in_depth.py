# list -
    #1. used to store multiple values in the siungle variable
    #2. store inside []
    #3. duplicates are allowed
    #4. after creating list we can add,update, delete elements : mutable
    #5. indexing is  allowed
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


#------------------------------------------------------------
#tuple 
    #1. used to store multiple values in the single variable
    #2. store inside ()
    #3. duplicates are allowed
    #4. after creating tuple we can not add,update, delete elements : immutable
    #5. indexing is  allowed
print("----  tuple ------")
numbers_tuple = ()
print(numbers_tuple)
numbers_tuple = (79,6,79)
print(numbers_tuple)

#numbers_tuple.append(9) # 'tuple' object has no attribute 'append'
print(numbers_tuple.count(6))
print(numbers_tuple.count(79))
print(numbers_tuple.index(79))


#------------------------------------------------------------
#set
    #1. used to store multiple values in the single variable
    #2. store inside {}
    #3. duplicates are not allowed
    #4. after creating set we can  add,update, delete elements : mutable
    #5. indexing is not allowed
print("----  set ------")
#important : how to create empty set
# []----> list, ()----> tuple, {}----> dictionary
numbers_set = set() #---> using set() function we create empty set, not {}
test = {}
print(numbers_set, type(numbers_set))
print(test, type(test))

numbers_set = {79,6,79}
print(numbers_set)
#numbers_set.append(9)
numbers_set.add(9)
print(numbers_set)

numbers_set_copy=numbers_set.copy()
print(numbers_set_copy)

numbers_set.update({56,90,87,90})
print(numbers_set)

numbers_set.remove(87)
print(numbers_set)


set1 = {4,9,5,3}
set2 = {9,4,1,7}
print(set1.difference(set2)) #unique elements of set1, not present in set 2
print(set1.symmetric_difference(set2)) #elemnets of both set excluding common elemenst'
print(set1.intersection(set2))
set1.intersection_update(set2)
print(set1)


#------------------------------------------------------------
#frozenset
    #1. used to store multiple values in the single variable
    #2. store inside frozenset({})
    #3. duplicates are not allowed
    #4. after creating frozenset we can not add,update, delete elements : immutable
    #5. indexing is not allowed
print("----  frozenset ------")

numbers_frozenset = frozenset()
print(numbers_frozenset, type(numbers_frozenset))
numbers_frozenset = frozenset({79,6,79})
print(numbers_frozenset)
#since frozenset is immutable, we can only do set theory oprations like - 
#difference, symmetric_difference , intersection etc like we do in the set

#------------------------------------------------------------
#dictionary
    #1. used to store multiple values in the single variable as key value pair
    #2. store inside {}
    #3. duplicates key are not allowed
    #4. after creating dictionary we can  add,update, delete elements : mutable
    #5. indexing is not allowed because we use keys
print("----  dictionary ------")
students_dictionary = {}
print(students_dictionary)
students_dictionary = {"name":"raj", "age":25}
print(students_dictionary)

students_dictionary.update({"city":"pune"})
print(students_dictionary)

students_dictionary.update({"name":"sumit"})
print(students_dictionary)

print(students_dictionary.get("city"))

students_dictionary_copy = students_dictionary.copy()
print(students_dictionary_copy)

print(students_dictionary.items())
print(students_dictionary.keys())
print(students_dictionary.values())

students_dictionary.update({"age":30})
print(students_dictionary)
students_dictionary.setdefault("age",35)
print(students_dictionary)
students_dictionary.setdefault("class","10th")
print(students_dictionary)

