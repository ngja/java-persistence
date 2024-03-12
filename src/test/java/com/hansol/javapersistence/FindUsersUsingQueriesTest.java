package com.hansol.javapersistence;

import com.hansol.javapersistence.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindUsersUsingQueriesTest  extends JavaPersistenceApplicationTests {

    @Test
    void testFindAll() {
        List<User> users = userRepository.findAll();
        assertEquals(10, users.size());
    }
}
