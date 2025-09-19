import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for registration and login functionality
 */
public class TestRegistrationLogin {
    
    @Test
    public void testUsernameCorrectlyFormatted() {
        Register user = new Register("John", "Doe", "j_doe", "Pass123!", "+27123456789");
        assertTrue("Username should be correctly formatted", user.checkUsername());
    }
    
    @Test
    public void testUsernameIncorrectlyFormattedNoUnderscore() {
        Register user = new Register("John", "Doe", "jdoe", "Pass123!", "+27123456789");
        assertFalse("Username should be incorrectly formatted (no underscore)", user.checkUsername());
    }
    
    @Test
    public void testUsernameIncorrectlyFormattedTooLong() {
        Register user = new Register("John", "Doe", "john_doe_long", "Pass123!", "+27123456789");
        assertFalse("Username should be incorrectly formatted (too long)", user.checkUsername());
    }
    
    @Test
    public void testPasswordCorrectlyFormatted() {
        Register user = new Register("John", "Doe", "j_doe", "Pass123!", "+27123456789");
        assertTrue("Password should be correctly formatted", user.checkPassword());
    }
    
    @Test
    public void testPasswordIncorrectlyFormattedNoCapital() {
        Register user = new Register("John", "Doe", "j_doe", "pass123!", "+27123456789");
        assertFalse("Password should be incorrectly formatted (no capital letter)", user.checkPassword());
    }
    
    @Test
    public void testPasswordIncorrectlyFormattedNoNumber() {
        Register user = new Register("John", "Doe", "j_doe", "Password!", "+27123456789");
        assertFalse("Password should be incorrectly formatted (no number)", user.checkPassword());
    }
    
    @Test
    public void testPasswordIncorrectlyFormattedNoSpecialChar() {
        Register user = new Register("John", "Doe", "j_doe", "Pass1234", "+27123456789");
        assertFalse("Password should be incorrectly formatted (no special character)", user.checkPassword());
    }
    
    @Test
    public void testPasswordIncorrectlyFormattedTooShort() {
        Register user = new Register("John", "Doe", "j_doe", "Pa1!", "+27123456789");
        assertFalse("Password should be incorrectly formatted (too short)", user.checkPassword());
    }
    
    @Test
    public void testCellphoneCorrectlyFormatted() {
        Register user = new Register("John", "Doe", "j_doe", "Pass123!", "+27123456789");
        assertTrue("Cellphone should be correctly formatted", user.checkCellphone());
    }
    
    @Test
    public void testCellphoneIncorrectlyFormattedNoInternationalCode() {
        Register user = new Register("John", "Doe", "j_doe", "Pass123!", "0712345678");
        assertFalse("Cellphone should be incorrectly formatted (no international code)", user.checkCellphone());
    }
    
    @Test
    public void testCellphoneIncorrectlyFormattedTooShort() {
        Register user = new Register("John", "Doe", "j_doe", "Pass123!", "+271234");
        assertFalse("Cellphone should be incorrectly formatted (too short)", user.checkCellphone());
    }
    
    @Test
    public void testRegistrationSuccessful() {
        Register user = new Register("John", "Doe", "j_doe", "Pass123!", "+27123456789");
        String result = user.registerUser();
        assertEquals("Registration should be successful", 
                     "Registration successful. Welcome John Doe - it is good to have you on board.", 
                     result);
    }
    
    @Test
    public void testRegistrationFailedUsername() {
        Register user = new Register("John", "Doe", "johndoe", "Pass123!", "+27123456789");
        String result = user.registerUser();
        assertEquals("Registration should fail due to username", 
                     "Username is incorrectly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", 
                     result);
    }
    
    @Test
    public void testRegistrationFailedPassword() {
        Register user = new Register("John", "Doe", "j_doe", "password", "+27123456789");
        String result = user.registerUser();
        assertEquals("Registration should fail due to password", 
                     "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", 
                     result);
    }
    
    @Test
    public void testLoginSuccessful() {
        // First register a user
        Login.registerUser("j_doe", "Pass123!");
        
        // Then test login
        Login login = new Login();
        String result = login.authenticate("j_doe", "Pass123!", "John", "Doe");
        assertEquals("Login should be successful", 
                     "Welcome John Doe - it is good to see you again.", 
                     result);
    }
    
    @Test
    public void testLoginFailed() {
        Login login = new Login();
        String result = login.authenticate("nonexistent", "wrongpass", "John", "Doe");
        assertEquals("Login should fail", 
                     "Username or password incorrect, please try again.", 
                     result);
    }
}

//DeepSeek. (2023). DeepSeek Chat (Version V2) [Large language model]. https://www.deepseek.com/
//Anthropic. (2023). Claude (Version 2.1) [Large language model]. https://claude.ai/