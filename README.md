# cp2-diploma

Projeto de api de diplomas para o checkpoint 2.

## Integrantes

### Leonardo Cordeiro Scotti- RM550769

### Enzo Ross Gallone- RM551754

### Vinicius de Araujo Camargo- RM99494

## Tecnologias

- [Java 21](https://docs.oracle.com/en/java/javase/21/)
- [GraalVM](https://www.graalvm.org/)
- [Gradle](https://gradle.org/)
- [Thymeleaf](https://www.thymeleaf.org/index.html)
- [Spring Boot 3.3.2](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/)
- [Spring Web Starter](https://docs.spring.io/spring-boot/reference/web/index.html)
- [Spring Validation Starter](https://docs.spring.io/spring-framework/reference/core/validation/beanvalidation.html)
- [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
- [JWT](https://jwt.io/introduction)
- [Spring HATEOAS](https://docs.spring.io/spring-hateoas/docs/current/reference/html/)
- [Springdoc OpenAPI + Swagger](https://springdoc.org/)
- [H2 Database](http://h2database.com/html/main.html)
- [REST](https://ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
- [DTO](https://martinfowler.com/eaaCatalog/dataTransferObject.html)

## Ferramentas

- [IntelliJ](https://www.jetbrains.com/pt-br/idea/)
- [Postman](https://www.postman.com/)

- ## API Reference e endpoints

- #### Registrar usuario

```http
  POST /auth/register
```

Body:

```json
{
     "login": "leonardo",
    "senha": "123456",
    "role": "ADMIN"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `login`    | `String` | Login do usuario a ser registrado   |
| `senha`   | `String` | Senha do usario a ser registrado |
| `role`   | `UserRole` | Role (atribuição) do usuario a ser registrado |


- #### Logar usuario

```http
  POST /auth/login
```

Body:

```json
{
     "login": "leonardo",
    "senha": "123456",
    "token": "1rf4g45g5h4"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `login`    | `String` | Login do usuario a ser logado   |
| `senha`   | `String` | Senha do usario a ser logado |
| `token`   | `String` | Token gerado a partir do regitro do usuario para autenticação do login  |

- #### Buscar todos os diplomados 

```http
  GET /diplomados
```

- #### Buscar diplomado por id 

```http
  GET /diplomados/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do diplomado a ser buscado |

- #### Criar diplomado

```http
  POST /diplomados
```

Body:

```json
{
     "nome": "Leonardo",
    "nacionalidade": "brasileira",
    "naturalidade": "São Paulo-SP",
    "rg": "12.345.678-9"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`    | `String` | Nome do diplomado a ser criado   |
| `nacionalidade`   | `String` | Nacionalidade do diplomado a ser criado |
| `naturalidade`   | `String` | Naturalidade do diplomado a ser criado  |
| `rg` | `String` | RG do diplomado a ser criado |

- #### Atualizar diplomado por id 

```http
  PUT /diplomados/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do diplomado a ser atualizado |

Body:

```json
{
     "nome": "Leonardo",
    "nacionalidade": "brasileira",
    "naturalidade": "São Paulo-SP",
    "rg": "12.345.678-9"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`    | `String` | Nome do diplomado a ser criado   |
| `nacionalidade`   | `String` | Nacionalidade do diplomado a ser criado |
| `naturalidade`   | `String` | Naturalidade do diplomado a ser criado  |
| `rg` | `String` | RG do diplomado a ser criado |

- #### Excluir diplomado por id 

```http
  DELETE /diplomados/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do diplomado a ser excluído |


- #### Buscar todos os cursos 

```http
  GET /cursos
```

- #### Buscar curso por id 

```http
  GET /cursos/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do curso a ser buscado |

- #### Criar curso

```http
  POST /cursos
```

Body:

```json
{
     "nome": "Ciencia da computacao",
    "tipo": "GRADUACAO"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`    | `String` | Nome do curso a ser criado   |
| `tipo`   | `TipoCurso` | Tipo do curso a ser criado |

- #### Atualizar curso por id 

```http
  PUT /cursos/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do curso a ser atualizado |

Body:

```json
{
     "nome": "Ciencia da computacao",
    "tipo": "GRADUACAO"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`    | `String` | Nome do curso a ser criado   |
| `tipo`   | `TipoCurso` | Tipo do curso a ser criado |

- #### Excluir curso por id 

```http
  DELETE /cursos/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do curso a ser excluído |


- #### Buscar diploma por id

```http
  GET /diplomas{id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `UUID` | **Obrigatório**. Id do diploma a ser buscado |

- #### Buscar diploma por id e texto gerado

```http
  GET /diploma/${id}/texto
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `UUID` | **Obrigatório**. Id do diploma a ser buscado |

- #### Criar diploma

```http
  POST /diplomas
```

Body:

```json
{
     "dataConclusao": "2024-12-15",
    "tituloReitor": "Prof. Dr.",
    "cargoReitor": "Reitor",
    "nomeReitor": "Carlos Eduardo",
    "sexo": "M",
    "idDiplomado": 1, 
    "idCurso": 2   
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `dataConclusao`    | `LocalDate` | Data de conclusão do curso do diploma a ser criado   |
| `tituloReitor`   | `String` | Titulo do reitor do diploma a ser criado |
| `cargoReitor`   | `String` | Cargo do reitor do diploma a ser criado |
| `nomeReitor`   | `String` | Nome do reitor do diploma a ser criado |
| `sexo`   | `Sexo` | Sexo do reitor do diploma a ser criado |
| `idDiplomado`   | `Long` | ID do diplomado do diploma a ser criado |
| `idCurso`   | `Long` | ID do curso do diploma a ser criado |
