package com.anuj.creatorstore.controllers;

import com.anuj.creatorstore.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @GetMapping
    public ApiResponse HomeControllerHandler(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Welcome to CreatorStore");
        return apiResponse;
    }
}
