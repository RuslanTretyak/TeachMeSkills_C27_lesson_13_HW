TeachMeSkills_C27_lesson_13_HW
Homework for the thirteenth lesson

This program checks the username and password entered by the client during registration.
Checking is carried out by static methods "registerFirstWay" and "registerSecondWay" located in the class "Authorization". 
These methods take three parameters as input: Login, Password, confirmPassword. Checks: The length of login must be less 
than 20 characters, login must not contain spaces; password must be less than 20 characters long, password must not contain 
a space and must contain at least one digit; password and confirmPassword must be equal. If login does not meet the 
requirements, then a WrongLoginException is thrown. If password does not meet the requirements, then a 
WrongPasswordException is thrown.
Classes "RunnerFirstWay" and "RunnerSecondWay" test class Authorization methods.

