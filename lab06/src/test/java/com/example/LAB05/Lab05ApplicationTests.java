package com.example.LAB05;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Thêm dòng này để vô hiệu hóa cấu hình Database khi Test
@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration")
class Lab05ApplicationTests {

    @Test
    void contextLoads() {
    }

}