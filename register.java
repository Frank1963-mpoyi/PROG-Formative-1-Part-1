import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Registration class that handles user registration with validation
 * for username, password, and South African cell phone number
 */
public class Register {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellphone;
    
    // Constructor
    public Register(String firstName, String lastName, String username, 
                   String password, String cellphone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellphone = cellphone;
    }
    
    /**
     * Validates username format
     * @return true if username contains underscore and is <= 5 characters
     */
    public boolean checkUsername() {
        return username.contains("_") && username.length() <= 5;
    }
    
    /**
     * Validates password complexity
     * @return true if password meets all complexity requirements
     */
    public boolean checkPassword() {
        // At least 8 characters
        if (password.length() < 8) return false;
        
        // Contains at least one capital letter
        if (!Pattern.compile("[A-Z]").matcher(password).find()) return false;
        
        // Contains at least one number
        if (!Pattern.compile("[0-9]").matcher(password).find()) return false;
        
        // Contains at least one special character
        if (!Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]").matcher(password).find()) return false;
        
        return true;
    }
    
    /**
     * Validates South African cellphone number format
     * @return true if cellphone starts with international code and is 10+ digits
     */
    public boolean checkCellphone() {
        // Check if it starts with international code for South Africa (+27)
        if (!cellphone.startsWith("+27")) return false;
        
        // Remove + and check if the remaining part is numeric and has at least 9 digits
        String digitsOnly = cellphone.substring(1).replaceAll("\\s+", "");
        if (!digitsOnly.matches("\\d+") || digitsOnly.length() < 9) return false;
        
        return true;
    }
    
    /**
     * Main registration method that validates all fields
     * @return validation message
     */
    public String registerUser() {
        if (!checkUsername()) {
            return "Username is incorrectly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        if (!checkPassword()) {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        if (!checkCellphone()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        
        // If all validations pass
        return "Registration successful. Welcome " + firstName + " " + lastName + " - it is good to have you on board.";
    }
    
    // Getters for unit testing
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getCellphone() { return cellphone; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}


//DeepSeek. (2023). DeepSeek Chat (Version V2) [Large language model]. https://www.deepseek.com/
//Anthropic. (2023). Claude (Version 2.1) [Large language model]. https://claude.ai/