# User Registration and Authentication System

## Overview
This Java application implements a user registration and authentication system with validation for username, password, and South African cellphone numbers.

## Requirements Implementation Reference

### User Registration (Page 6, 26)
- **Username Validation**: Must contain an underscore and be no more than 5 characters long
- **Password Complexity**: Must contain at least:
  - 8 characters
  - 1 capital letter
  - 1 number
  - 1 special character
- **Cellphone Validation**: South African numbers must start with +27 and contain at least 9 digits

### Authentication System (Page 1)
- **Login Functionality**: Validates credentials against registered users
- **Success Message**: "Welcome [first name] [last name] - it is good to see you again."
- **Error Message**: "Username or password incorrect, please try again."

### Validation Messages (Page 2)
- **Username Error**: "Username is incorrectly formatted, please ensure that your username contains an underscore and is no more than five characters in length."
- **Password Error**: "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character."
- **Cellphone Error**: "Cell phone number incorrectly formatted or does not contain international code."
- **Success Message**: "Registration successful. Welcome [first name] [last name]!"

### Test Cases (Pages 4, 10)
The test suite includes specific test cases mentioned in the requirements:
- Username "My." validation (Page 4)
- All validation scenarios for username, password, and cellphone
- Both successful and failed registration attempts
- Both successful and failed login attempts


### References

### DeepSeek. (2023). DeepSeek Chat (Version V2) [Large language model]. https://www.deepseek.com/

### Anthropic. (2023). Claude (Version 2.1) [Large language model]. https://claude.ai/