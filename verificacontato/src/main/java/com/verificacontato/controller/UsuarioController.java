package com.verificacontato.controller;

import com.verificacontato.model.Usuario;
import com.verificacontato.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Cadastro de novo usuário
    @PostMapping("/usuarios")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
            return ResponseEntity.ok(novoUsuario);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Login (base inicial)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        // Aqui ainda não implementamos a autenticação JWT completa
        // Você pode chamar um serviço que valide a senha e gere token depois
        return ResponseEntity.ok("Login funcionando - implementar autenticação JWT");
    }
}

