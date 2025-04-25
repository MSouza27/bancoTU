package br.com.api.bancoTU.repository;

import br.com.api.bancoTU.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.tipoDeTransferencia, COUNT(u) FROM User u GROUP BY u.tipoDeTransferencia")
    List<Object[]> contarTransferenciasPorTipo();

    @Query("SELECT u.bancoOrigem, COUNT(u) FROM User u GROUP BY u.bancoOrigem")
    List<Object[]> contarBancoDeOrigem();
}
