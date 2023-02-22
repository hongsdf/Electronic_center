package Electronic.Start.controller;

import Electronic.Start.entity.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; // 단위테스트 import
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

//@WebMvcTest(ElectronicController.class) // 경량화된 웹 단위 테스트
class ElectronicControllerTest {

    // 테스트는 @Autowired를 이용한 주입

    @Autowired
    private MockMvc mockMvc; // 웹 환경의 테스트를 하기 위한 클래스

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    void setUp() {


    }

    @Test
    void register() throws Exception {
        Location location = Location.ex();
        String content = objectMapper.writeValueAsString(location); // 샘플데이터를 json 변경
        mockMvc.perform(post("/locations")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON) // 타입지정
                .accept(MediaType.APPLICATION_JSON)) // 타입지정
                .andExpect(status().isOk()) // 상태코드 확인
                .andExpect(content().string(location.getId())) // 보낸값과 동일 여부
                .andDo(print()); // 결과를 호출하는 메서드 andDo
    }

    @Test
    void findbyId() {

    }

    @Test
    void findByAll() {
    }

    @Test
    void upDate() {
    }

    @Test
    void delete() {
    }


    @AfterEach
    void tearDown() {
    }
}