package com.CyberSoft.uniclubWeb.controller;

import com.CyberSoft.uniclubWeb.service.FakeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fake-data")
public class FakeDataController {

    @Autowired
    private FakeDataService fakeDataService;

    @GetMapping("/generate")
    public ResponseEntity<?> generateFakeData() {
        fakeDataService.generateFakeData();
        return new ResponseEntity<>("Fake data generated successfully!", HttpStatus.OK);
    }
}
