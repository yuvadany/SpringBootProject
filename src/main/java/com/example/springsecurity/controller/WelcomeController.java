package com.example.springsecurity.controller;

import com.example.springsecurity.entity.Author;
import com.example.springsecurity.service.AuthorServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/yuvi/services")
public class WelcomeController {
    @Autowired
    private AuthorServices authorServices;
    @ApiOperation(value = "welcome")
    @GetMapping("/welcome")
    public String welcome(){
    return "welcome to Spring Security Spring Boot Project";
}

    @ApiOperation(value = "Api to  get all the Authors")
    @GetMapping("/getAllAuthors")
public ResponseEntity<List<Author>> getAllAuthors() {
        return new ResponseEntity<>(authorServices.findAll(), HttpStatus.OK);
    }
    @ApiOperation(value = "Api to  get a particular  Author by passing Author id")
    @GetMapping("/author/{authorId}")
        public ResponseEntity<Author> getAuthor(@PathVariable ("authorId") int authorId){
        var authorData = authorServices.findById(authorId).orElseThrow(
                  ()-> new NoSuchElementException());
            return new ResponseEntity<>(authorData,HttpStatus.ACCEPTED);
        }

}

