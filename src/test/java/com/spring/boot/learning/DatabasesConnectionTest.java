package com.spring.boot.learning;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.learning.event.model.Change;
import com.spring.boot.learning.event.repository.ChangeRepository;
import com.spring.boot.learning.vams.model.Claim;
import com.spring.boot.learning.vams.repository.ClaimRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class DatabasesConnectionTest {
    @Autowired
    private ClaimRepository userRepository;

    @Autowired
    private ChangeRepository productRepository;

    @Test
    @Transactional("vamsTransactionManager")
    public void whenCreatingUser_thenCreated() {
        Claim user = new Claim();
        user.setDescription("hi");
        user.setClaimId(1);
        user = userRepository.save(user);

        assertNotNull(user);
    }

    @Test
    @Transactional("eventsTransactionManager")
    public void whenCreatingProduct_thenCreated() {
        Change product = new Change();
        product.setType("type");
        product.setId(1);

        product = productRepository.save(product);

        assertNotNull(product);
    }
}
