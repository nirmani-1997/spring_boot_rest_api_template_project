package com.example.demo.demo.controller;

//import com.example.demo.demo.Service.UserService;
import com.example.demo.demo.entity.User;
import com.example.demo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")

public class UserController {


//    @Autowired
//    private UserService service;

    @Autowired
    UserRepository userRepository;

//    @GetMapping("/getuserlist")
//    public List<User> userList(){
//        List<User> users = new ArrayList<User>();
//
//
//        users = service.userList();
//        return users;
//    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(required = false) String userName) {
        try {
            List<User> userList = new ArrayList<>();
            if (null == userName) {
                userRepository.findAll().forEach(userList::add);
            } else {
                userRepository.findByName(userName).forEach(userList::add);
            }
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((List<User>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    //Create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User _user = userRepository.save(new User(user.getName(), user.getAddress(), user.getContactNo(), user.getEmail(), user.getNic(), user.getDateOfBirth(), user.getJoinedDate(), user.getUserRoll(), user.getPassword()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((User) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        try {
            Optional<User> userData = userRepository.findById(id);
            if (userData.isPresent()) {
                User _user = userData.get();

                _user.setName(user.getName());
                _user.setAddress(user.getAddress());
                _user.setContactNo(user.getContactNo());
                _user.setEmail(user.getEmail());
                _user.setNic(user.getNic());
                _user.setDateOfBirth(user.getDateOfBirth());
                _user.setJoinedDate(user.getJoinedDate());
                _user.setUserRoll(user.getUserRoll());
                _user.setPassword(user.getPassword());


                return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
            } else {
                return new ResponseEntity<>((User) null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((User) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>((User) null, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((User) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
