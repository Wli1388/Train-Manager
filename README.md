# Train-Manager

A train car manager for a commercial train.

##Menu Options 

F - Move Cursor Forward\
Moves the cursor forward one car (if a next car exists).

B - Move Cursor Backward\
Moves the cursor backward one car (if a previous car exists).

I - Insert Car After Cursor <Length> <Weight>\
Inserts a new empty car after the cursor. If the cursor is null (i.e. the train is empty), the car is set as the head of the train. After insertion, the cursor is set to the newly inserted car.

R - Remove Car At Cursor\
Removes the car at current position of the cursor. After deletion, the cursor is set to the next car in the list if one exists, otherwise the previous car. If there is no previous car, the list is empty and the cursor is set to null.

L - Set Load At Cursor <Name> <Weight> <Value> <Is Dangerous>
Sets the product load at the current position in the list.

S - Search For Product <name>\
Searches the train for all the loads with the indicated name and prints out the total weight and value, and whether the load is dangerous or not. If the product could not be found, indicate to the user that the train does not contain the indicated product.

T - Print Train\
Prints the String value of the train to the console.

M - Print Manifest\
Prints the train manifest - the loads carried by each car.

D - Remove Dangerous Cars\
Removes all the dangerous cars from the train.

Q - Quit\
Terminates the program.
