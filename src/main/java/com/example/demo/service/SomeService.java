package com.example.demo.service;

import com.example.demo.model.MyResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SomeService {

    private final JdbcTemplate jdbcTemplate;

    public List<MyResult> getMyResult() {
        List<MyResult> myResultList = jdbcTemplate.query("SELECT * FROM my_table", new BeanPropertyRowMapper<>(MyResult.class));
        log.debug(myResultList.toString());
        return myResultList;
    }
}
