package com.prac26102026.prac1.practice.TranscationalPrac.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionStatus;


@Configuration
public class TranscationMangerConfig {

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory wmf) {
        return new JpaTransactionManager(wmf) {
            @Override
            public void doBegin(Object transaction, TransactionDefinition definition) {
                super.doBegin(transaction, definition);
                System.out.println("TXN Logger --> New Transaction started: (Progation behavior = "
                        + definition.getPropagationBehavior() + ")"
                        + "(new =" + definition.getName()
                );
            }
            @Override
            public void doCommit(DefaultTransactionStatus status) {
                super.doCommit(status);
                System.out.println("TXN Logger --> Transaction committed"
                        + "(name = " + status.getTransactionName() + ")");
            }

            @Override
            public void doRollback(DefaultTransactionStatus status) {
                super.doRollback(status);
                System.out.println("TXN Logger --> Transaction rolled back"
                        + "(name = " + status.getTransactionName() + ")");
            }

        };
    }
}

