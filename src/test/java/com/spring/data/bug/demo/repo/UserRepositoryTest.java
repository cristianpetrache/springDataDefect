package com.spring.data.bug.demo.repo;

import com.spring.data.bug.demo.DemoApplication;
import com.spring.data.bug.demo.model.Contact;
import com.spring.data.bug.demo.model.Language;
import com.spring.data.bug.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
public class UserRepositoryTest {

    /**
     * Check data.sql
     */
    private static final int EXPECTED_NO_OF_USERS = 1;
    private static final int EXPECTED_NO_OF_CONTACTS = 3;
    private static final int EXPECTED_NO_OF_LANGUAGES = 2;

    @Autowired
    private JpaRepository<User, String> userRepository;

    @Test
    public void testFindAll_success() {

        List<User> userList = userRepository.findAll();
        User user = userList.stream().findAny().orElseThrow(RuntimeException::new);
        Assert.assertEquals("Number of users should match!", EXPECTED_NO_OF_USERS, userList.size());
        Assert.assertEquals("Number of contacts should match!", EXPECTED_NO_OF_CONTACTS, user.getContacts().size());
        Assert.assertEquals("Number of languages should match!", EXPECTED_NO_OF_LANGUAGES, user.getLanguages().size());
    }

    @Test
    public void testFindById_success() {

        User user = userRepository.findById("user1").orElseThrow(RuntimeException::new);
        Assert.assertEquals("Number of contacts should match!", EXPECTED_NO_OF_CONTACTS, user.getContacts().size());
        Assert.assertEquals("Number of languages should match!", EXPECTED_NO_OF_LANGUAGES, user.getLanguages().size());
    }
}
