package com.fullness.ec.security;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootTest
public class PasswordEncodeTest {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    public void testPasswordEncode(){
        String password = "admin";
        // パスワードをハッシュ化する
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println("Encoded Password: " + encodedPassword);
        assertTrue(true);
    }
}