package com.example.demo.controller;

import com.example.demo.service.RequestValidatorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/validate")
public class RequestController {

    private final RequestValidatorService validatorService;

    public RequestController(RequestValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @PostMapping
    public List<String> validateRequests(@RequestBody ValidationRequest request) {
        return validatorService.getResponses(request.getValidAuthTokens(), request.getRequests());
    }

    // DTO
    public static class ValidationRequest {
        private List<String> validAuthTokens;
        private List<List<String>> requests;

        public List<String> getValidAuthTokens() {
            return validAuthTokens;
        }

        public void setValidAuthTokens(List<String> validAuthTokens) {
            this.validAuthTokens = validAuthTokens;
        }

        public List<List<String>> getRequests() {
            return requests;
        }

        public void setRequests(List<List<String>> requests) {
            this.requests = requests;
        }
    }
}