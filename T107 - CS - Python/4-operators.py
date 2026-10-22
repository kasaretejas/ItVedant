#arithmatic : specifically to work with numbers, but also works with other data type
print(10+2) #12
print(10-2) #8
print(10*2) #20
print(10/2) #5.0 --> pyhton rule : any division will have float answer
print(10/3) #3.33333
print(50/5) #10.0
print(10%2) #0 --> % is reminder of division (% :remider operator/modulas)
print(10%3) #1
print(10%4) #2
print(50%5) #0

print("hi"+"bye")
print("hi"*3)
#print("hi"+5+3) ---> Error
#print(5+3+"hi") ---> Error

print(True+True) #pyhton considers True as 1 and False as 0

#Assignment : assignenig a value
marks = 65
marks = marks+10 #65+10 = 75

#but there is shortcut : marks+=10 --->marks = marks+10
marks-=20
print(marks)


#comparision : >,<,>=,<=,!=,==
print(10>2)
print(10<2)
print(2>=2)
print(2<=2)
print(10!=2)
print(10==2)

print(5.0==5)
print("5"==5)


print("a">"Apple") #comparision is based in ASCII code
#a ---> 97
#A ---> 65
# comparision is done based on character by character not its length
# 97>76 ----> True

#logical : and, or, not
#and : gives result as true if all conditions are true
#or  : gives result as true if at least one condition is true
#not : reverse the result 
print("----- logical -----")
print(5>2 and 5>1 and 5>3) #T
print(5>2 and 5>1 and 5<3) #F
print(5<2 and 5>1 and 5>3) #F


print(5<2 or 5<1 or 5>3) #T

print(5>3) #T
print(not 5>3) # not True ---> False
