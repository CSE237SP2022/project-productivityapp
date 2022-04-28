# CSE 237--SPR 2022: Productivity App
by Jordan Stone, Nadia Myrie, Jared Stier, and Destiny King

Our project is a productivity app that allows you to keep track of the tasks you need to do in an organized fashion.  

- - - -

#### How to Run Program: ####

1. git clone https://github.com/CSE237SP2022/project-productivityapp.git <br />
2. cd project-productivityapp <br />
3. ./todosScript.sh  <br />

#### Commands for Using Program: ####

1. type "create" to create a new todo <br/>
2. type "print" to show all created todos <br />
    * to __filter alphabetically__, type "print filter alphabetical"
    * to __filter in reverse alphabetical order__, type "print filter reverse alphabetical"
3. type "exit" to exit program <br />

- - - -

## Iteration 1: ##

* Initialized a hash map that will store our list of todo's. The key for this map will be the timestamp at which the ToDo was added. <br />
* Added functionality to add/remove todo's from the overall list <br />
* Added function to sort todos alphabetically <br />

## Iteration 2: ##

1. What user stories were completed this iteration?

    * A user can now sort todos alphabetically  <br />
    * A user can now filter todos in reverse alphabetical order  <br />
    * A user can now edit a todo  <br />
    * A user can now add sub-todos to each existing todo  <br />

2. What user stories do you intend to complete next iteration?

    * A user will be albe to filter todos by date created  <br />
    * A user will be able to assing a level of urgency to todos  <br />
    * A user will be able to see the completion percentage of each todo based on the number of sub-todos completed  <br />

## Iteration 3: ##

1. What user stories were completed this iteration?

    * A user can filter todos by date created <br />
    * A user can see updated progress of main todo based on progress of its subtodos <br />
    * A user will get an error message when formatting date and progress percentage incorrectly  <br />

