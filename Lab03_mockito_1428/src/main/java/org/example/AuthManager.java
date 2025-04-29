package org.example;

public class AuthManager {

    private final UserRepository userRepository;
    private final HashLib hashLib;

    public AuthManager(UserRepository userRepository, HashLib hashLib) {
        this.userRepository = userRepository;
        this.hashLib = hashLib;
    }

    public boolean login(String email, String password) {
        try {
            User user = userRepository.findByEmail(email);
            if (user == null) {
                return false;
            }
            String hashedPass = hashLib.hashFunc(password);
            return hashedPass.equals(user.getPassword());
        } catch (Exception e) {
            System.out.println("Login error: " + e);
            return false;
        }
    }
}
