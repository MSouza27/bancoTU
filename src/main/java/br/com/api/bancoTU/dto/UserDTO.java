package br.com.api.bancoTU.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UserDTO(
        String bancoOrigem,
        String nomeCliente,
        String tipoDeTransferencia,
        BigDecimal saldoContaAtual,
        BigDecimal saldoSaidaConta,
        BigDecimal saldoDepoisDaSaida,
        LocalDateTime horaTransferencia
) {

}
