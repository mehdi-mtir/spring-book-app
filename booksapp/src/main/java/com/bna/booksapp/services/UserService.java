package com.bna.booksapp.services;

import com.bna.booksapp.AppException;
import com.bna.booksapp.dtos.CreadentialsDto;
import com.bna.booksapp.dtos.SignUpDto;
import com.bna.booksapp.dtos.UserDto;
import com.bna.booksapp.entities.User;
import com.bna.booksapp.mappers.UserMapper;
import com.bna.booksapp.respositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto login(CreadentialsDto credentialsDto){
        User user = userRepository.findByEmail(credentialsDto.email())
                .orElseThrow(()->new AppException("Utilisateur introuvable", HttpStatus.NOT_FOUND));

        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())){
            return userMapper.toUserDto(user);
        }
        throw new AppException("Mot de passe incorrect", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto signUpDto){
        Optional<User> optionalUser = userRepository.findByEmail(signUpDto.email());
        if(optionalUser.isPresent()){
            throw new AppException("Utilisateur existant", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpDtoToUser(signUpDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.password())));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }


}
