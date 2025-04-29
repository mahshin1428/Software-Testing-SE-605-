package org.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AuthManagerTest {

    private AuthManager authManager;
    private UserRepository userRepository;
    private HashLib hashLib;

    @Before
    public void setUp() {
        userRepository = mock(UserRepository.class);
        hashLib = mock(HashLib.class);
        authManager = new AuthManager(userRepository, hashLib);

        User mockUser = new User("test@example.com", "hashedPassword123");
        when(userRepository.findByEmail("test@example.com")).thenReturn(mockUser);

        when(hashLib.hashFunc("password123")).thenReturn("hashedPassword123");
        when(userRepository.findByEmail("test@example.com")).thenReturn(mockUser);
        when(hashLib.hashFunc("wrongPassword")).thenReturn("wrongHashedPassword");

        when(userRepository.findByEmail("notfound@example.com")).thenReturn(null);
    }

    @Test
    public void testLogin_Success() {
        boolean result = authManager.login("test@example.com", "password123");
        assertTrue(result);
    }

    @Test
    public void testLogin_Failure_WrongPassword() {
        boolean result = authManager.login("test@example.com", "wrongPassword");
        assertFalse(result);
    }

    @Test
    public void testLogin_Failure_UserNotFound() {
        boolean result = authManager.login("notfound@example.com", "password123");
        assertFalse(result);
    }
}
