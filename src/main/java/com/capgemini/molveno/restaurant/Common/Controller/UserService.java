package com.capgemini.molveno.restaurant.Common.Controller;

import com.capgemini.molveno.restaurant.Common.Model.User;
import com.capgemini.molveno.restaurant.Config.SimpleSecurityController;
import com.capgemini.molveno.restaurant.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;

@Controller
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final SimpleSecurityController securityController;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, SimpleSecurityController securityController, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.securityController = securityController;
        this.encoder = encoder;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        User result = userRepository.findByUsername(username);
        if (result != null) {
            return result;
        } else {
            throw new UserNotFoundException("[username : " + username + "] - User not found");
        }
    }

    public User addUser(User user) {
        try {
            getUserByUsername(user.getUsername());
            return new User();
        } catch (UserNotFoundException e) {
            User savedUser = userRepository.save(user.setPassword(encoder.encode(user.getPassword())));
            if (savedUser != null) {
                //Adding user to simpleSecurityController to let the user to be able to use his/her account
                securityController.add(savedUser.getUsername(), savedUser.getPassword(), savedUser.getRole());
            }
            return savedUser;
        }
    }
    public String deleteUser(String username) {
        if (isUserExists(username)) {
            userRepository.deleteById(
                    userRepository
                            .findByUsername(username)
                            .getId());
            securityController.remove(username);
            return "User deleted [username: " + username + "]";
        } else {
            return "Delete user request can not proceed because of non existing user [username: " + username + "]";
        }

    }

    //Init user is for adding all the users on the database to simpleSecurityController when application restarts
    public void initUsers() {
        System.out.println("<----- User Initialization Started ----->");
        try {
            getUserByUsername("dev");
            for (User u : getAllUsers()) {
                securityController.add(u.getUsername(), u.getPassword(), u.getRole());
            }
        }
        catch (UserNotFoundException e){

            String username = "Admin";
            String password = "";
            String role = "Admin";
            User u = addUser(new User(username, password, role));
            if(! isUserExists(u.getUsername())) {
                securityController.add(u.getUsername(), u.getPassword(), u.getRole());
            }
        }
        System.out.println("<----- User Initialization Finished ----->");
    }

    public boolean isUserExists(String username) {
        return securityController.userExists(username);
    }
}
