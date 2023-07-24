package com.blogify.blogapi.service;

import com.blogify.blogapi.entity.User;
import com.blogify.blogapi.enums.UserType;
import com.blogify.blogapi.repository.UserRepository;
import com.blogify.blogapi.security.JWTUtil;
import com.blogify.blogapi.utils.Result;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImp implements AuthService {

    private UserRepository userRepository;

    private JWTUtil jwtUtil;
    private AuthenticationManager authManager;
    private PasswordEncoder passwordEncoder;


    @Override
    public Result<String> login(String email, String password) throws AccessDeniedException {

        Optional<User> userRes = userRepository.findFirstByEmail(email);

        if (userRes.isEmpty()) {
            return new Result<>(false, "error", "User not found");
        }

        User user = userRes.get();

        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(user.getId(), password);
        authManager.authenticate(authInputToken);
        String token = jwtUtil.generateToken(user.getId());
        System.out.println(token);

        return new Result<>(true, "success", token);


    }

    @Override
    public Result<String> register(String email, String password, String name, String surname, String username) throws AccessDeniedException {

        Optional<User> userRes = userRepository.findFirstByEmail(email);

        if (userRes.isPresent()) {
            System.out.println(userRes.get());
            return new Result<>(false, "error", "User already exists");
        }

        User user = new User();


        String encodedPass = passwordEncoder.encode(password);


        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(encodedPass);
        user.setName(name);
        user.setSurname(surname);
        user.setUserType(UserType.USER);
        userRepository.save(user);

        return new Result<>(true, "success", "User created");

    }
}


