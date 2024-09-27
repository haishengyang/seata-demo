package com.distribution.transaction.storage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storage")
public class StorageController {
    @GetMapping("demo")
    public String demo() {
        return "demo";
    }
}
