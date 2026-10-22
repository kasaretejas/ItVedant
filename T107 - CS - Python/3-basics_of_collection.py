# collection data type : used to store multiple values at a time in single variable
# in python we have following colletion data types
# list, tuple,set, frozenset and dict (dictionary)

print([10,20,10], type([10,20,10]))   #[10,20,10] --> list
print((10,20,10), type((10,20,10)))   #(10,20,10) --> tuple
print({10,20,10}, type({10,20,10}))   #{10,20} -----> set
print(frozenset({10,20,10}), type(frozenset({10,20,10}))) #frozenset({10,20})
print({"name":"raj", "age":20}, type({"name":"raj", "age":20})) 
                                    #{"name":"raj", "age":20} ---> dict

#list
    # inside []
    # duplicate allowed
#tuple
    # inside ()
    # duplicate allowed
#set
    # inside {}
    # duplicate not allowed
#frozenset
    # inside frozenset({})
    # duplicate not allowed
#dict
    # inside {} but in key-value pair
    # duplicate keys are not allowed

# if we have empty {} ---> it is dict, not set
# for empty set we have to use built in fuction ---> set()
