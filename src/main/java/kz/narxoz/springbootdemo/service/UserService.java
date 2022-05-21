package kz.narxoz.springbootdemo.service;

import kz.narxoz.springbootdemo.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Users getUserByEmail(String email);
}
