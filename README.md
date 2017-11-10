# Bank Program 

This is a program that will simulate the services provided by a bank. The user can withdraw, deposit, and view their account balance.

This project was done using two java classes. First, a bank account object was created. Then, an account controller class was created to manipulate the bank account object. 

The main issue in this program was getting around invalid input. This was handled with an "amountHandler" method which caught invalid input and prompted the user for new input.


## Installation & Setup
- open terminal
- cd to home directory
- `$ git clone git@github.com:stephaniedefranco/bankservice.git`

## Execution
1) `$ javac bankservice/*.java`
2) `$ java bankservice/AccountController`


## Test Plan

Summary: QA will test the validity of input among the commands of the bank service.

##### Commands: 
- Main command prompt: "Withdraw", "Deposit", "Balance", "Exit"
    - Non-case sensitive
    - Will only accept these 4 values
- Withdraw & Deposit: 
    - Will only accept: non negative, two decimal points maximum, must be decimal number
- View Balance
    - Must be displayed in US currency format
- Exit
    - Must terminate the program

##### Additional Requirements: 
- User should be able to use the program until they type "exit" in the main prompt.
- User should be prompted with clear, easily understood directions.
- Account balance should be consistently updated and stored correctly while the program runs.

## Test Cases 

#### Test #1 - Negative values
- User provides a negative value for withdrawal and is prompted again for valid input
  - Priority: High
  - Purpose: prevent user from providing negative values that would contradict bank functions
  - Step 1: Run the program
     - Expected result: user is prompted to withdraw, deposit, view balance, or exit.
  - Step 2: User types "Withdraw"
     - Expected result: user is prompted to enter a value.
  - Step 3: User enters the value "-102"
     - Expected result: error message. User is prompted for value again. 
     - Expected result: balance is unchanged.

#### Test #2 - Non-numeric values
- User provides a non-numeric value for deposit and is prompted again for valid input
  - Priority: High
  - Purpose: prevent user from providing non-numeric values that would be incompatible with bank functions
  - Step 1: Run the program
     - Expected result: user is prompted to withdraw, deposit, view balance, or exit.
  - Step 2: User types "Deposit"
     - Expected result: user is prompted to enter a value.
  - Step 3: User enters the string "5%4dfs"
     - Expected result: error message. User is prompted for value again. 
     - Expected result: balance is unchanged.
     
#### Test #3 - Value with more than 2 decimal places
- User provides a value with more than two decimal places for withdrawal and is prompted again for valid input
  - Priority: High
  - Purpose: prevent user from providing values with too many decimal points that would not apply to regular currency format
  - Step 1: Run the program
     - Expected result: user is prompted to withdraw, deposit, view balance, or exit.
  - Step 2: User types "Withdraw"
     - Expected result: user is prompted to enter a value.
  - Step 3: User enters the string "99.00000002"
     - Expected result: error message. User is prompted for value again. 
     - Expected result: balance is unchanged. 
     
#### Test #4 - Capitalization in commands
- User types in commands with characters varying in lower and uppercase, but is nonetheless prompted for the same bank function
    - Priority: High
    - Purpose: ensure that the user can easily input commands regardless of capitalization
    - Step 1: Run the program
         - Expected result: user is prompted to withdraw, deposit, view balance, or exit.
    - Step 2: User types "WITHDRAW"
         - Expected result: user is prompted to enter a value for withdrawal.
    - Step 3: User types "500"
         - Expected result: user is prompted to withdraw, deposit, view balance, or exit.
    - Step 4: User types "Balance"
         - Expected result: user is presented with their balance. 
         - Expected result: user is prompted to withdraw, deposit, view balance, or exit.
    - Step 5: User types "deposit" 
         - Expected result: user is prompted to enter a value for deposit. 
         
 #### Test #5 - Invalid commands
 - User types in an invalid command and is prompted to enter a command again.
     - Priority: High
     - Purpose: ensure the user can still use the program after inputting a typo by accident. 
     - Step 1: Run the program
        - Expected result: user is prompted to withdraw, deposit, view balance, or exit.
     - Step 2: User types "7382nd"
        - Expected result: user is prompted to withdraw, deposit, view balance, or exit.
