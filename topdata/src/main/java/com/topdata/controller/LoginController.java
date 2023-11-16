package com.topdata.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topdata.service.Credentials;

@RestController
@RequestMapping("/api")
public class LoginController {

	@PostMapping("/login") // Mapeamento correto para o endpoint de login
    public ResponseEntity<String> login(@RequestBody Credentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        System.out.println("Login");
        return ResponseEntity.ok().build();

        // Lógica para fazer a validação das credenciais
//        if (/* credenciais válidas */) {
//            return ResponseEntity.ok("Login bem-sucedido");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
//        }
    }
   
}
