# take how many bikes are there(count) and ask their name and write into file
bikes_file=open("bikes.txt","a")
total_bikes = int(input("How many bikes do you have ----->"))
for i in range(1,total_bikes+1):
    bike_name=input("Enter bike "+str(i)+" name ---->")
    bikes_file.write(bike_name+"\n")

print("bike names added to the file")
bikes_file.close()
