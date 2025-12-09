package com.ClinicaMedica.IFTM.controladores;

import com.ClinicaMedica.IFTM.dto.AuthenticationDTO;
import com.ClinicaMedica.IFTM.dto.LoginResponseDTO;
import com.ClinicaMedica.IFTM.dto.RegisterDTO;
import com.ClinicaMedica.IFTM.infra.security.TokenService;
import com.ClinicaMedica.IFTM.repository.UserRepository;
import com.ClinicaMedica.IFTM.user.User;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5137")
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager menager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @CrossOrigin(origins = "*" , allowedHeaders = "*")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth =  this.menager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @CrossOrigin(origins = "*" , allowedHeaders = "*")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
