package com.hansol.javapersistence.ch02;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldJpaTest {

    @Test
    public void storeLoadMessage() {
        // 영속성 단위
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch02");

        try {
            EntityManager em = emf.createEntityManager(); // entityManager 생성으로 세션 시작, 영속성 컨텍스트
            em.getTransaction().begin();

            Message message = new Message();
            message.setText("Hello World!");

            em.persist(message); // 영속성 컨텍스트 등록 (영속화)

            em.getTransaction().commit();
            // insert into message (id, text) values (1, 'Hello World!');

            em.getTransaction().begin();

            List<Message> messages = em
                    .createQuery("select m from Message m", Message.class)
                    .getResultList();
            // select * from message

            messages.get(messages.size() - 1)
                    .setText("Hello World from JPA!");

            em.getTransaction().commit();
            // update message set text = 'Hello World from JPA!" where id = 1;

            assertAll(
                    () -> assertEquals(1, messages.size()),
                    () -> assertEquals("Hello World from JPA!", messages.get(0).getText())
            );

            em.clear();
        } finally {
            emf.close();
        }
    }
}
