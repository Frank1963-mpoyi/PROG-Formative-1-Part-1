import java.util.HashMap;
import java.util.Map;

/**
 * Login class that handles user authentication
 */
public class Login {
    // In-memory storage for registered users (username -> password)
    private static Map<String, String> userDatabase = new HashMap<>();
    
    /**
     * Adds a user to the database (simulates registration)
     * @param username the username
     * @param password the password
     */
    public static void registerUser(String username, String password) {
        userDatabase.put(username, password);
    }
    
    /**
     * Authenticates a user
     * @param username the username to authenticate
     * @param password the password to verify
     * @param firstName user's first name for welcome message
     * @param lastName user's last name for welcome message
     * @return authentication result message
     */
    public String authenticate(String username, String password, String firstName, String lastName) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            return "Welcome " + firstName + " " + lastName + " - it is good to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
    /**
     * Checks if a username exists in the database
     * @param username the username to check
     * @return true if username exists
     */
    public boolean userExists(String username) {
        return userDatabase.containsKey(username);
    }
}

//DeepSeek. (2023). DeepSeek Chat (Version V2) [Large language model]. https://www.deepseek.com/
//Anthropic. (2023). Claude (Version 2.1) [Large language model]. https://claude.ai/