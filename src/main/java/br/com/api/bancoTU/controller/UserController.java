package br.com.api.bancoTU.controller;

import br.com.api.bancoTU.dto.UserDTO;
import br.com.api.bancoTU.enums.TipoTransferencia;
import br.com.api.bancoTU.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transferencia")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserDTO> registrar(@RequestBody UserDTO dto) {
        var dados = userService.validarTransferencia(dto);
        return ResponseEntity.status(201).body(dados);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<UserDTO>> listarTodos() {
        return ResponseEntity.ok(userService.listarTodos());
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<UserDTO> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(userService.buscarPorId(id));
    }

    @GetMapping("/contagem/transferencia")
    @Transactional
    public ResponseEntity<Map<TipoTransferencia, Long>> contarTransferenciasPorTipo() {
        return ResponseEntity.ok(userService.contarPorTipo());
    }

    @GetMapping("/contagem/banco")
    @Transactional
    public ResponseEntity<Map<String, Long>> contarTransferenciasPorBancoOrigem() {
        return ResponseEntity.ok(userService.contarBancoOrigem());

    }
}
