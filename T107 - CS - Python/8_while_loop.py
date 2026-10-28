#we use while loop when we dont know end
actual_password = "abcd@123"
entered_password = ""

while(actual_password!=entered_password):
    entered_password = input("Enter your password---->")
    if(actual_password==entered_password):
        print("Welcome!")

#display 1 to 5 numbers using while
print("------------------")
start = 1
end = 5
while(start <= end):
    print(start)
    start+=1
