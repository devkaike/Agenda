# Projeto Agenda

Este projeto é uma aplicação de agenda que permite aos usuários criar, listar e deletar eventos. Além disso, o sistema envia um e-mail quando uma nova agenda é criado.

## Funcionalidades Implementadas

### Usuários
- **Criação de Usuário**: Os usuários podem ser criados com um e-mail, senha e nome. A senha é criptografada antes de ser armazenada no banco de dados.
- **Listagem de Usuários**: Todos os usuários cadastrados podem ser listados.
- **Deleção de Usuário**: Usuários podem ser deletados pelo seu ID.

### Agenda
- **Criação de Evento**: Os usuários podem criar eventos com título, descrição, data, hora e o usuário associado.
- **Listagem de Eventos**: Todos os eventos cadastrados podem ser listados.
- **Deleção de Evento**: Eventos podem ser deletados pelo seu ID.

### E-mail
- **Envio de E-mail a cada agenda criada**: Quando uma nova agenda é criada, um email é enviado para cada usuario.

## Estrutura do Projeto

### Pacotes
- `com.kaike.filesAgenda.user.domain`: Contém a entidade `User`.
- `com.kaike.filesAgenda.user.service`: Contém a lógica de negócios relacionada aos usuários.
- `com.kaike.filesAgenda.user.repository`: Contém a interface do repositório de usuários.
- `com.kaike.filesAgenda.agenda.domain`: Contém a entidade `Agenda`.
- `com.kaike.filesAgenda.email.domain`: Contém o record `Email`.
- `com.kaike.filesAgenda.email.service`: Contém a interface `EmailService`.
- `com.kaike.filesAgenda.email.service.impl`: Contém a implementação do serviço de e-mail.
- `com.kaike.filesAgenda.utils.dtos`: Contém a classe `ServiceResponseDTO`.

### Dependências
- **Spring Boot**: Framework principal para a construção da aplicação.
- **Spring Data JPA**: Para interações com o banco de dados.
- **Spring Security**: Para criptografia de senhas.
- **Spring Mail Sender**: Para envio de email.
- **Lombok**: Para reduzir o boilerplate de código.
- **Jakarta Persistence**: Para mapeamento objeto-relacional.


## Como Executar

1. Clone o repositório:
   ```sh
   git clone https://github.com/devkaike/Agenda.git