#1. find index of each number in given list
#expected output  : 23 is at index 0
numbers = [23, 89, 45, 18, 99] 

print("----- way 1--------")
print(numbers.index(23))
for number in numbers:
    print(str(number)+" is at index "+ str(numbers.index(number)))


print("----- way 2--------")
#print(len(numbers)) # len tells us total items/elements inside numbers list
for i in range(0, len(numbers)):  #range(0,5)
    #print(i,numbers[i])
    print(str(numbers[i]) + " is at index "+ str(i))


#2. display only 2 digit numbers from given list
print("--------------------")
numbers = [6, 98, 421, 99, 3, 45]
#expected output : 98   99  45
for number in numbers:
    if number>9 and number<100:
        print(number)

#3. display numbers those are divisible by 3 and also even
print("-------------")
numbers = [6, 9, 12, 15, 23, 22]
#expected output : 6     12  
for number in numbers:
    if number%3==0 and number%2==0:
        print(number)

#4. display even and odd numbers from given list
print("---- even odd --------")
numbers = [78, 97, 45, 22, 46]
# expected 78 is even number
for number in numbers:
    if number%2==0:
        print(number ," is even")
    else:
        print(number ," is odd")


#5. sum of values in given list
print("----- sum of list -----")
numbers = [2, 7, 3, 1, 7]
#expected output : 20
sum = 0 #2  9  12   13  20
for number in numbers:
    sum = sum+number 
          #0+2 = 2
          #2+7 = 9
          #9+3 = 12
          #12+1 = 13
          #13+7 = 20
print("sum of list is ", sum)
