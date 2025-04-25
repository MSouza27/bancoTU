package br.com.api.bancoTU.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "recebimento")
@Getter
@Setter
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bancoDestino;
    private String nomeCliente;
    private BigDecimal saldoContaAtual;
    private BigDecimal saldoRecebimentoConta;
    private BigDecimal saldoDepoisDoDeposito;

}
