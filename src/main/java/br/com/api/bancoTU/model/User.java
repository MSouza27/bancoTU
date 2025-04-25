package br.com.api.bancoTU.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = ("transferencia"))
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bancoOrigem;
    private String nomeCliente;
    private String tipoDeTransferencia;
    private BigDecimal saldoContaAtual;
    private BigDecimal saldoSaidaConta;
    private BigDecimal saldoDepoisDaSaida;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(nullable = false, updatable = false)
    private LocalDateTime horaTransferencia;
}
