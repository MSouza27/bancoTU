```markdown
# 💸 Banco TU - Sistema de Transferências Bancárias

Este é um projeto backend desenvolvido em **Java com Spring Boot**, que simula um sistema de transferências bancárias (PIX, TED e DOC). Ele realiza validações, registra transações e fornece relatórios de contagem por tipo de transferência e banco de origem.

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- RESTful API
- Jakarta Validation
- MySQL (ou H2 para testes locais)
- Maven

## 📦 Funcionalidades

✅ Validação de saldo e tipo de transferência  
✅ Registro de transferências com horário e saldo atualizado  
✅ Consulta de transferências por ID ou todas as registradas  
✅ Contagem de transferências por tipo (PIX, TED, DOC)  
✅ Contagem de transferências por banco de origem

## 📁 Estrutura do Projeto

```
src
├── controller          # Camada de controle (UserController)
├── service             # Regra de negócio (UserService)
├── repository          # Repositórios JPA
├── model               # Entidades JPA (User)
├── dto                 # Data Transfer Objects
├── enums               # Tipos de Transferência (PIX, TED, DOC)
```

## 🧪 Exemplos de Uso

### 🔄 Registrar Transferência (POST)

```
POST /transferencia
```

**Exemplo de JSON:**

```json
{
  "bancoOrigem": "Banco TU",
  "nomeCliente": "João Silva",
  "tipoDeTransferencia": "PIX",
  "saldoContaAtual": 1000.00,
  "saldoSaidaConta": 250.00
}
```

### 📊 Contagem por Tipo de Transferência

```
GET /transferencia/contagem/transferencia
```

### 📈 Contagem por Banco de Origem

```
GET /transferencia/contagem/banco
```

## ⚠️ Validações

- Verifica se o saldo disponível é suficiente para realizar a transferência
- Somente tipos válidos: `PIX`, `TED`, `DOC`
- Em caso de saldo insuficiente, a operação é rejeitada com erro 400

## 🧠 Motivação

Este projeto foi criado com foco em **práticas modernas de desenvolvimento backend** e pode ser adaptado para casos reais em sistemas bancários ou fintechs.

## 📍 Localização

Projeto desenvolvido com carinho diretamente de **Recife - PE**, de olho nas oportunidades do ecossistema **Porto Digital**. 💙

## 🤝 Contato

📧 Seu Nome – [magnoapt@gmail.com]  
💼 LinkedIn – [www.linkedin.com/in/magno-souza-dos-santos]

---

**⭐ Dê uma estrela se achou útil!**  
Sinta-se à vontade para abrir issues ou contribuir com melhorias!
```
