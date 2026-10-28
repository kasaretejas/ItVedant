# undertanding for loop with range() fyunction
for i in range(1,5):
    print(i)

print("------------")

for i in range(1,6):
    print(i)


print("------------")

for i in range(1,10,2):
    print(i)

print("------------")

for i in range(25,30,1):
    print(i)

print("------------")

for i in range(25,30,-1):
    print(i)

print("----- for loop with collection ------")
# undertanding for loop with collection - list, tuple, set
# display all elements in given list
marks_list = [98,56,90,34]
marks_tuple = (98,56,90,34)
marks_set = {98,56,90,34}

for mark in marks_list: #marks_tuple, marks_set
    print(mark)

#display even numbers from given list
print("---------------")

numbers = [4,5,8,2,1,9,8]
for number in numbers:
    if(number%2==0):
        print(number)


#display all characters in given string
print("---------------------")
city = "thane"
for character in city:
    print(character)
