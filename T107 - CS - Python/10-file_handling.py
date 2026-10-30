#first open file then perform operations
#to open file in python, there are 2 ways
    #1. using open() function -----> easy, but we have to close file manually
    #2. open() using with -----------> more constructive and closes file automatically

# syntax : open("file_name_with_extension","mode")
# mode : in which format we havw to open a file
        # r ---> read
        # w ---> write ----> overrides previous/existing data
        # a ---> append ---> keeps previous/existing data
        # x ---> create
        # r+ --> read and write
        # w+ --> write and read
        # a+ --> append and read

# create file ----> x, if file already exists, then it will gives error
# open("demo.txt","x")
# print("file demo.txt is created!")


# write data into file using w ---> if file does not exists then it will create that file
# students_file=open("students.txt", "w")
# students_file.write("amit\n")
# students_file.write("sumit")
# students_file.close()
# to check how data get overridden, go and execute code inside 11-file_handling.py



# write data into file using a ---> if file does not exists then it will create that file
# employees_file=open("employees.txt","a")
# employees_file.write("mr. aniket\n")
# employees_file.write("mr. punit\n")
# employees_file.close()
# print("data written into employee file")
# to check how data NOT get overridden, go and execute code inside 12-file_handling.py

# read data from file using r ----> if file does not exists then it will gives error
# read() ----> reads entire file data at a time
# read(number)---> reads given number of characters
# readline() ----> read one line at a time
# readlines() ---> read all lines in a file and return data into a list

# employees_file=open("employees.txt","r")
# all_employees_data=employees_file.read()
# print(all_employees_data)
# employees_file.close()

# employees_file=open("employees.txt","r")
# employees_7_character_data=employees_file.read(7)
# print(employees_7_character_data)
# employees_file.close()

# employees_file=open("employees.txt","r")
# employees_line_one=employees_file.readline()
# print(employees_line_one)
# employees_line_two=employees_file.readline()
# print(employees_line_two)
# employees_file.close()

# employees_file=open("employees.txt","r")
# all_employees_data_into_list=employees_file.readlines()
# print(all_employees_data_into_list)
# employees_file.close()


#-------- opening file using with
# test_file=open("test.txt","w")
# print(test_file.closed)
# test_file.close()
# print(test_file.closed)

with open("test.txt","w") as test_file2:
    test_file2.write("hello")
    print(test_file2.closed)

print(test_file2.closed)



