package com.spring.data.bug.demo.repo;

import com.spring.data.bug.demo.DemoApplication;
import com.spring.data.bug.demo.model.User;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
@Transactional
public class UserRepositoryTest {

	/**
	 * Check data.sql
	 */
	private static final int EXPECTED_NO_OF_USERS = 1;
	private static final int EXPECTED_NO_OF_CONTACTS = 3;
	private static final int EXPECTED_NO_OF_LANGUAGES = 2;

	@Autowired
	private JpaRepository<User, String> userRepository;

	@Autowired
	private EntityManager em;

	@Test
	public void testFindAll_success() {

		List<User> userList = userRepository.findAll();
		User user = userList.stream().findAny().orElseThrow(RuntimeException::new);
		SoftAssertions.assertSoftly(softly -> {
					softly.assertThat(userList).hasSize(EXPECTED_NO_OF_USERS);
					softly.assertThat(user.getContacts()).hasSize(EXPECTED_NO_OF_CONTACTS);
					softly.assertThat(user.getLanguages()).hasSize(EXPECTED_NO_OF_LANGUAGES);
				}
		);
	}

	@Test
	public void testFindById_success() {

		User user = userRepository.findById("user1").orElseThrow(RuntimeException::new);

		SoftAssertions.assertSoftly(softly -> {
					softly.assertThat(user.getContacts()).hasSize(EXPECTED_NO_OF_CONTACTS);
					softly.assertThat(user.getLanguages()).hasSize(EXPECTED_NO_OF_LANGUAGES);
				}
		);
	}

	@Test
	public void testEmBaseFindById_success() {

		User user = em.find(User.class,"user1");

		SoftAssertions.assertSoftly(softly -> {
					softly.assertThat(user.getContacts()).hasSize(EXPECTED_NO_OF_CONTACTS);
					softly.assertThat(user.getLanguages()).hasSize(EXPECTED_NO_OF_LANGUAGES);
				}
		);
	}
}
