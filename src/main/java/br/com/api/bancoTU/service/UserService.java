package br.com.api.bancoTU.service;

import br.com.api.bancoTU.dto.UserDTO;
import br.com.api.bancoTU.enums.TipoTransferencia;
import br.com.api.bancoTU.model.User;
import br.com.api.bancoTU.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO validarTransferencia(UserDTO dto) {

        var permisao = dto.saldoContaAtual().compareTo(dto.saldoSaidaConta()) >= 0;
        var debitoConta = dto.saldoContaAtual().subtract(dto.saldoSaidaConta());

        if (TipoTransferencia.valueOf(dto.tipoDeTransferencia()) == TipoTransferencia.PIX && permisao) {

            var transferencia = new User();

            transferencia.setBancoOrigem(dto.bancoOrigem());
            transferencia.setNomeCliente(dto.nomeCliente());
            transferencia.setTipoDeTransferencia(dto.tipoDeTransferencia());
            transferencia.setSaldoContaAtual(dto.saldoContaAtual());
            transferencia.setSaldoSaidaConta(dto.saldoSaidaConta());
            transferencia.setSaldoDepoisDaSaida(debitoConta);
            transferencia.setHoraTransferencia(LocalDateTime.now());

            var validar = userRepository.save(transferencia);

            return new UserDTO(
                    validar.getBancoOrigem(),
                    validar.getNomeCliente(),
                    validar.getTipoDeTransferencia(),
                    validar.getSaldoContaAtual(),
                    validar.getSaldoSaidaConta(),
                    validar.getSaldoDepoisDaSaida(),
                    validar.getHoraTransferencia()
            );

        }

        if (TipoTransferencia.valueOf(dto.tipoDeTransferencia()) == TipoTransferencia.DOC && permisao){

            var transferencia = new User();

            transferencia.setBancoOrigem(dto.bancoOrigem());
            transferencia.setNomeCliente(dto.nomeCliente());
            transferencia.setTipoDeTransferencia(dto.tipoDeTransferencia());
            transferencia.setSaldoContaAtual(dto.saldoContaAtual());
            transferencia.setSaldoSaidaConta(dto.saldoSaidaConta());
            transferencia.setSaldoDepoisDaSaida(debitoConta);
            transferencia.setHoraTransferencia(LocalDateTime.now());

            var validar = userRepository.save(transferencia);

            return new UserDTO(
                    validar.getBancoOrigem(),
                    validar.getNomeCliente(),
                    validar.getTipoDeTransferencia(),
                    validar.getSaldoContaAtual(),
                    validar.getSaldoSaidaConta(),
                    validar.getSaldoDepoisDaSaida(),
                    validar.getHoraTransferencia()
            );

        }

        if (TipoTransferencia.valueOf(dto.tipoDeTransferencia()) == TipoTransferencia.TED && permisao){

            var transferencia = new User();

            transferencia.setBancoOrigem(dto.bancoOrigem());
            transferencia.setNomeCliente(dto.nomeCliente());
            transferencia.setTipoDeTransferencia(dto.tipoDeTransferencia());
            transferencia.setSaldoContaAtual(dto.saldoContaAtual());
            transferencia.setSaldoSaidaConta(dto.saldoSaidaConta());
            transferencia.setSaldoDepoisDaSaida(debitoConta);
            transferencia.setHoraTransferencia(LocalDateTime.now());

            var validar = userRepository.save(transferencia);

            return new UserDTO(
                    validar.getBancoOrigem(),
                    validar.getNomeCliente(),
                    validar.getTipoDeTransferencia(),
                    validar.getSaldoContaAtual(),
                    validar.getSaldoSaidaConta(),
                    validar.getSaldoDepoisDaSaida(),
                    validar.getHoraTransferencia()
            );

        }

        throw new IllegalArgumentException("Saldo Insuficiente");
    }

    public List<UserDTO> listarTodos(){
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(
                        user.getBancoOrigem(),
                        user.getNomeCliente(),
                        user.getTipoDeTransferencia(),
                        user.getSaldoContaAtual(),
                        user.getSaldoSaidaConta(),
                        user.getSaldoDepoisDaSaida(),
                        user.getHoraTransferencia()
                )).collect(Collectors.toList());
    }

    public UserDTO buscarPorId(Long id){
        var user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        return new UserDTO(
                user.getBancoOrigem(),
                user.getNomeCliente(),
                user.getTipoDeTransferencia(),
                user.getSaldoContaAtual(),
                user.getSaldoSaidaConta(),
                user.getSaldoDepoisDaSaida(),
                user.getHoraTransferencia()
        );
    }

    public Map<TipoTransferencia, Long> contarPorTipo(){
        var resultado = userRepository.contarTransferenciasPorTipo();

        Map<TipoTransferencia, Long> contagem = new HashMap<>();
        for (Object[] linha: resultado){
            TipoTransferencia tipo = TipoTransferencia.valueOf((String) linha[0]);
            Long total1 = (Long) linha[1];
            contagem.put(tipo, total1);
        }
        return contagem;
    }

    public Map<String, Long> contarBancoOrigem(){
        var resultado = userRepository.contarBancoDeOrigem();

        Map<String, Long> contagem = new HashMap<>();
        for (Object[] linha : resultado){
            String banco = (String) linha[0];
            Long total1 = (Long) linha[1];
            contagem.put(banco, total1);
        }
        return contagem;
    }
}