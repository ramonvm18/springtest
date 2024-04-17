package com.example.demo.external;

import com.example.demo.domain.dto.v1.ActivityDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestBoredApi {

    private final RestTemplate restTemplate;

    public ActivityDto activity() {
        return restTemplate
                .getForEntity("https://www.boredapi.com/api/activity", ActivityDto.class)
                .getBody();
    }
}
