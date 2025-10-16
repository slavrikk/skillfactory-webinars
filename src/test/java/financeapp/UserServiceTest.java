package financeapp;

import skillfactory.financeapp.model.User;
import skillfactory.financeapp.service.UserService;
import skillfactory.financeapp.exception.UserNotFoundException;
import skillfactory.financeapp.exception.InvalidCredentialsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    
    private UserService userService;
    
    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }
    
    @Test
    public void testRegisterUser() {
        // Проверка успешной регистрации
        assertDoesNotThrow(() -> userService.registerUser("testuser", "password123"));
        
        // Проверка, что пользователь действительно зарегистрирован
        assertThrows(InvalidCredentialsException.class, () -> {
            userService.authenticateUser("testuser", "wrongpassword");
        });
    }
    
    @Test
    public void testRegisterDuplicateUser() {
        // Регистрируем пользователя
        assertDoesNotThrow(() -> userService.registerUser("testuser", "password123"));
        
        // Пытаемся зарегистрировать того же пользователя еще раз
        assertThrows(IllegalArgumentException.class, () -> {
            userService.registerUser("testuser", "password456");
        });
    }
    
    @Test
    public void testAuthenticateUser() throws UserNotFoundException, InvalidCredentialsException {
        // Регистрируем пользователя
        userService.registerUser("testuser", "password123");
        
        // Проверка успешной аутентификации
        User user = userService.authenticateUser("testuser", "password123");
        assertNotNull(user);
        assertEquals("testuser", user.getUsername());
    }
    
    @Test
    public void testAuthenticateNonExistentUser() {
        assertThrows(UserNotFoundException.class, () -> {
            userService.authenticateUser("nonexistent", "password123");
        });
    }
    
    @Test
    public void testAuthenticateWithWrongPassword() {
        // Регистрируем пользователя
        userService.registerUser("testuser", "password123");
        
        // Пытаемся аутентифицироваться с неправильным паролем
        assertThrows(InvalidCredentialsException.class, () -> {
            userService.authenticateUser("testuser", "wrongpassword");
        });
    }
    
    @Test
    public void testGetCurrentUser() throws UserNotFoundException, InvalidCredentialsException {
        // Регистрируем и аутентифицируем пользователя
        userService.registerUser("testuser", "password123");
        User user = userService.authenticateUser("testuser", "password123");
        
        // Проверяем, что текущий пользователь установлен правильно
        User currentUser = userService.getCurrentUser();
        assertNotNull(currentUser);
        assertEquals(user, currentUser);
    }
    
    @Test
    public void testLogout() throws UserNotFoundException, InvalidCredentialsException {
        // Регистрируем и аутентифицируем пользователя
        userService.registerUser("testuser", "password123");
        userService.authenticateUser("testuser", "password123");
        
        // Проверяем, что пользователь залогинен
        assertTrue(userService.isUserLoggedIn());
        
        // Выполняем выход
        userService.logout();
        
        // Проверяем, что пользователь больше не залогинен
        assertFalse(userService.isUserLoggedIn());
        assertNull(userService.getCurrentUser());
    }
}