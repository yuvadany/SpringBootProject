package com.example.springsecurity.controller;

import com.example.springsecurity.entity.Author;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.model.AuthRequest;
import com.example.springsecurity.model.AuthResponse;
import com.example.springsecurity.service.AuthorServices;
import com.example.springsecurity.utils.JwtTokenUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/yuvi/services")
public class WelcomeController {
    @Autowired
    private AuthorServices authorServices;

    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody   AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword()));
            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
            return ResponseEntity.ok().body(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @ApiOperation(value = "welcome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class)
    })
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to Spring Security Spring Boot Project";
    }

    @ApiOperation(value = "Api to  get all the Authors")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Author.class)
    })
    @GetMapping("/getAllAuthors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        //List<String> testArrayList = new ArrayList<>();
        //testArrayList.
        return new ResponseEntity<>(authorServices.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Api to  get a particular  Author by passing Author id")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted", response = Author.class),
            @ApiResponse(code = 404, message = "Please try with different Author Id - The author for this id is not available ",
                    response = String.class)
    })
    @GetMapping("/author/{authorId}")
    public ResponseEntity<Author> getAuthor(@PathVariable("authorId") int authorId) {
        var authorData = authorServices.findById(authorId).orElseThrow(
                () -> new NoSuchElementException());
        return new ResponseEntity<>(authorData, HttpStatus.ACCEPTED);
    }

}

