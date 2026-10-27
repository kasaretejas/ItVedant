# check given numbver is positive or negative
number1 = 28
number1 = -45
if(number1>0):
    print(number1, " is positive")
else:
    print(number1, " is negative")

# check given age is eligible for voting
age = 23
age = 13
if(age>18):
    print(age, " eligible for voting")
else:
    print(age, " not eligible for voting")
    
# check given number  is even or odd
num = 13
num = 18
if(num%2==0):
    print(num, " is even")
else:
    print(num, " is odd")


# take marks from student and check if he is pass or failed
marks = int(input("Enter marks --->"))
if(marks>=35):
    print(marks, " pass!")
else:
    print(marks, " failed!")


# take two numbers from user and check which number is largest
n1 = int(input("Enter first number ---->"))
n2 = int(input("Enter second number ---->"))
if(n1>n2):
    print(n1, " is largest")
else:
    print(n2, " is largest")

print("----- three number problem starts --------")
# take three numbers from user and check which number is largest
a = int(input("Enter first number ---->"))
b = int(input("Enter second number ---->"))
c = int(input("Enter third number ---->"))


if(a>b and a>c):
    print(a, " is largets")
elif(b>a and b>c):
    print(b, " is largets")
else:
    print(c, " is largets")

