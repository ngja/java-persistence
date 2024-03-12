package com.hansol.javapersistence;

import com.hansol.javapersistence.model.User;
import com.hansol.javapersistence.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class JavaPersistenceApplicationTests {

    @Autowired
    UserRepository userRepository;

    @BeforeAll
    void beforeAll() {
        userRepository.saveAll(generateUsers());
    }

    private static List<User> generateUsers() {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Random random = new Random(System.currentTimeMillis());
            User randomUser= new User(RandomStringUtils.random(random.nextInt(5)), LocalDate.now());
            users.add(randomUser);
        }

        return users;
    }

    @AfterAll
    void afterAll() {
        userRepository.deleteAll();
    }
}
