package com.example.demo.external;

import com.example.demo.domain.dto.v1.ActivityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(name = "Activities", url = "https://www.boredapi.com/api/activity")
public interface FeignBoredApi {

    @GetMapping
    ActivityDto getActivity();
}
