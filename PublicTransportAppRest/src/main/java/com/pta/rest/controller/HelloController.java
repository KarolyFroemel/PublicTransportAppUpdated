package com.pta.rest.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@SecurityRequirement(name = "Keycloak")
public class HelloController {

    @GetMapping("/greeting")
    @PreAuthorize("hasRole('app-admin')")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @GetMapping("/greetingAdmin")
    @PreAuthorize("hasRole('app-admin')")
    public String greetingAdmin(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello admin " + name;
    }

    @GetMapping("/greetingPassenger")
    @PreAuthorize("hasRole('app-passenger')")
    public String greetingPassenger(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello passenger " + name;
    }

    @GetMapping("/greetingValidator")
    @PreAuthorize("hasRole('app-validator')")
    public String greetingValidator(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello validator " + name;
    }
}
