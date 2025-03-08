package com.kaike.filesAgenda.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kaike.filesAgenda.email.domain.Email;
import com.kaike.filesAgenda.email.service.EmailService;
import com.kaike.filesAgenda.user.domain.User;
import com.kaike.filesAgenda.user.repository.UserRepository;
import com.kaike.filesAgenda.utils.dtos.ServiceResponseDTO;

@Service
public class UserService {
    
    private UserRepository userRepository;    

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public ServiceResponseDTO createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        Email email = new Email(user.getEmail(), "Bem-vindo", "Olá, " + user.getName() + " seja bem-vindo ao nosso sistema");
        emailService.sendEmail(email);
        return new ServiceResponseDTO(200, "Usuário criado com sucesso");
    }

    public ServiceResponseDTO listUsers() {
        List<User> users = userRepository.findAll();
        return new ServiceResponseDTO(200, users);
    }
}
