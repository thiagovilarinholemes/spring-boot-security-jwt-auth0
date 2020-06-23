# spring-boot-security-jwt-auth0

Repositório exemplo de como implementar API de autenticação com ATH0 com as entidades Roles, Permissions e Authorizations.

1) Roles = Funções dos usuários - Admin, Manager, User, etc...
2) Permissions = URI's 
3) Authorizations = Permissões adicionais as Roles.

URI para gerar o token, o mesmo é retornado no cabeçalho da página na tag **Authorization**:
> localhost:8080/login

URI's para navegação:
> localhost:8080/test1

> localhost:8080/test2

> localhost:8080/test3

> localhost:8080/reports

> localhost:8080/users

***OBS.: estas URI's podem variar devido as refatorações. Para mais informações acesse a pasta */resources* nela contém as classes com os devidos endereços.***

Na pasta */security* contém a classe *SecurityConfiguration.java* que permite fazer as configurações de permissões das URI's.

***Lembrete: este repositório estará em constantes atualizações(refatorações) devido as implementações.***
