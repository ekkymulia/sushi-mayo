package com.sushimayo.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootJBDC implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJBDC.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        String sql = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
//        int result = jdbcTemplate.update(sql, "Head First Java", "Kathy Sierra", 18.55f);
//
//        if (result > 0) {
//            System.out.println("Insert successfully.");
//        }
    }
}