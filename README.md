![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

# AluraFlix API
## Challenges de Back-end da Alura
Implementação de uma API Rest para gerenciamento de vídeos que permite a interação com recursos através de endpoints definidos, onde o usuário consegue realizar todas as operações de um CRUD e relacionar diferentes entidades dentro do sistema. 
Construído utilizando Java com Spring Boot, sistema de gerenciamento de banco de dados com mysql dentre outros recursos.

## Instruções de Instalação 
Para utilizar esta API, siga os passos abaixo:

1. Clone o repositório:
```bash
git clone https://github.com/dayvidj/alura-flix-api.git
```
2. Instale dependências com Maven
3. Configure o Banco de Dados MySQL
4. Contrua o build da aplicação com o maven
5. Execute o arquivo JAR gerado

A API estará acessível no endereço http://localhost:8080

Utilize o Swagger para acessar todas requisições no endereço http://localhost:8080/swagger-ui/index.html

## Como Usar
A API fornece os seguintes endpoints:

#### Autenticação

```bash 
POST /login: Realiza a autenticação de um usuário com base nos dados fornecidos e retorna um token JWT válido para acesso das demais requisições.
```

#### Vídeos
```bash
GET /videos: Recupera uma lista de todos os vídeos.  
GET /videos/{id}: Recupera um vídeo específico pelo ID.
POST /videos: Cria um novo vídeo.
PUT /videos: Atualiza as informações de um vídeo existente pelo ID informado no corpo da requisição.
DELETE /videos/{id}: Deleta um vídeo pelo ID. 
```

#### Categorias
 ```bash
GET /categorias: Recupera uma lista de todas as categorias.
GET /categorias/{id}: Recupera uma categoria específica pelo ID.
POST /categorias: Cria uma nova categoria.
PUT /categorias: Atualiza uma categoria existente pelo ID informado no corpo da requisição.
DELETE /categorias/{id}: Deleta uma categoria pelo ID.
```

#### Rotas específicas
```bash
GET /videos/free: Endpoint público que retorna uma lista vídeos que podem ser acessados sem auteticação.
GET /videos/search?nome=exemplo: recupera vídeos por título da categoria informado no enrereço.
GET /categorias/{idCategoria}/videos : Recupera todos os vídeos associados a uma categoria específica selecionada pelo ID.
```

## Exemplos de Requisições

#### Request: POST /login
A requisição deve conter um corpo (body) no formato JSON com os seguintes campos:

```bash
{
  "login": "string",
  "senha": "string"
}
```
#### Response:
Em caso de sucesso, o endpoint retorna um token JWT que deve ser utilizado para autenticar requisições subsequentes:

```bash 
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY0NzIxMjQ0MiwiaWF0IjoxNjQ3MjA5MjQyfQ.Bsz9jGmzsg48c8SujErT1oFmKYd43Z7dROzne1N-JQ"
}
```

#### Request: GET /videos/search?nome=educacao:

#### Response: 
```bash
{
 "id": 1,
 "titulo": "Introdução ao Spring Boot",
 "descricao": "Aprenda os fundamentos do Spring Boot",
 "url": "https://www.alura.com.br/curso/spring-boot",
 "idCategoria": 1
},
{
 "id": 1,
 "titulo": "APIs RESTful com Spring",
 "descricao": "Desenvolvimento de APIs RESTful utilizando Spring Framework",
 "url": "https://www.alura.com.br/curso/apis-restful-spring",
 "idCategoria": 1
}
```

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.
