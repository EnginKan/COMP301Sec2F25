package com.yeditepe.firstspingproject.controllers;


import com.yeditepe.firstspingproject.UserDTO;
import com.yeditepe.firstspingproject.entity.User;
import com.yeditepe.firstspingproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    private UserRepository userRepository;
    //We use this private Constructor for Dependecy Injection-So that Ioc container includes Impl. of this dependency
    private UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private ArrayList<String> users = new ArrayList<>(
            Arrays.asList("Name2", "Name2","Name3"
            ));

    private ArrayList<UserDTO> userDTOs = new ArrayList<>(
            Arrays.asList(new UserDTO(1,"Name1","name1@yeditepe.edu.tr"),
                    new UserDTO(2,"Name2","name2@yeditepe.edu.tr"),
                     new UserDTO(3,"Name3","name3@yeditepe.edu.tr")
                    ));

     @RequestMapping(path={"/welcome"},
             method = RequestMethod.GET)
    public String welcome() {
         return "Welcome";
     }

     @GetMapping(path="/users")
    public ArrayList<UserDTO> getAllUsers() {
        return userDTOs;
     }

     @GetMapping(path="/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
         Optional<UserDTO> u=
                 userDTOs.stream().filter(us->us.getId()==id).findFirst();

         if(u.isPresent()) {
             return  ResponseEntity.ok(u.get());
         }
         else{
             return  ResponseEntity.notFound().build();
         }
     }
     @GetMapping(path="/user")
    public ResponseEntity<UserDTO> getAllUsersByName(
        @RequestParam(name="name",
        required=true,
        defaultValue = "Name3") String name,
        @RequestParam(name="age"
        ,required = false)
        Integer age
     ) {
         Optional<UserDTO> user=userDTOs.stream()
                 .filter(s->s.getName().equals(name))
                 .findFirst();

         if(user.isPresent()){
             return  ResponseEntity.ok(user.get());
         }
         else
             return  ResponseEntity.notFound().build();
     }

     @GetMapping("searchbyname/{name}")
     public ResponseEntity<ArrayList<User>> getUsersByNameLike(
             @PathVariable(name = "name") String name){
         return ResponseEntity.ok((ArrayList<User>) userRepository.findByUsernameStartingWith(name));
     }
    @PostMapping(path = "createuser")
    public ResponseEntity<String> createUser(
            @RequestBody UserDTO user){
         User newuser = new User(user.getName(),user.getEmail());
         userRepository.save(newuser);
        return ResponseEntity.ok("<html>" +
                "<body><p>User is created:"+ user.toString()+"</p></body></html>");

    }

}


