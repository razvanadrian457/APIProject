package com.fasttrackit.web;

import com.fasttrackit.dto.UserDTO;
import com.fasttrackit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user/(id)", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") long id)
    {
        return userService.getUserById(id);
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO)
    {
        userService.saveUser(userDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/user/(id)", method = RequestMethod.PUT)
    public UserDTO updateUser(@PathVariable long id, @RequestBody UserDTO dto)
    {
        return userService.updateUser(id, dto);
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public UserDTO getUserByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password)
    {
        return userService.getUserByEmailAndPassword(email, password);
    }
}
