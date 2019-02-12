package com.capgemini.molveno.restaurant.Common.API;

import com.capgemini.molveno.restaurant.Common.Controller.UserService;
import com.capgemini.molveno.restaurant.Common.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

@RequestMapping("/api/user")
@Controller
public class UserEndpoint {
    private final UserService userService;

    @Autowired
    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity getUserByUsername(@PathParam("username") @NotBlank String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @GetMapping("/exist/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity isUserExist(@PathParam("username") @NotBlank String username) {
        return ResponseEntity.ok(userService.isUserExists(username));
    }

    @PostMapping("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity addUser(@RequestBody @Valid User user) {
        User savedUser = userService.addUser(user);
        System.out.println(savedUser.getId() + " " + savedUser.getUsername() + " " + savedUser.getPassword() + " " + savedUser.getRole());
        return ResponseEntity.ok(savedUser);
    }

    @DELETE
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity deleteUser(@PathParam("username") @NotBlank String username) {
        return ResponseEntity.ok(userService.deleteUser(username));
    }
}

