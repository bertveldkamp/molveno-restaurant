package com.capgemini.molveno.restaurant.Common.Controller;

import com.capgemini.molveno.restaurant.Common.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
