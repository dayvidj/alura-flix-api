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

#### Categorias
 ```bash
GET /categorias: Recupera uma lista de todas as categorias.
GET /categorias/{id}: Recupera uma categoria específica pelo ID.
GET /categorias/{idCategoria}/videos : Recupera todos os vídeos associados a uma categoria específica
POST /categorias: Cria uma nova categoria.
PUT /categorias/{id}: Atualiza uma categoria existente pelo ID.
DELETE /categorias/{id}: Deleta uma categoria pelo ID.
```
#### Vídeos
```bash
GET /videos: Recupera uma lista de todos os vídeos.  
GET /videos/{id}: Recupera um vídeo específico pelo ID.
GET /videos/search recupera vídeos por título da categoria.
POST /videos: Cria um novo vídeo.
PUT /videos/{id}: Atualiza um vídeo existente pelo ID.
DELETE /videos/{id}: Deleta um vídeo pelo ID.

GET /videos/free: Endpoint público que lista vídeos disponíveis sem necessidade de autenticação. 
```

## Exemplos de Requisições
#### Request: POST/videos
```bash
{
  "titulo": "Boas Práticas em Java",
  "descricao": "Curso de Java com foco em boas práticas",
  "url": "https://www.alura.com.br/curso/java",
  "idCategoria": 1
}
```
#### Response: 
```bash
{
  "titulo": "Boas Práticas em Java",
  "descricao": "Curso de Java com foco em boas práticas",
  "url": "https://www.alura.com.br/curso/java",
  "idCategoria": 1
}
```


## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença
Este projeto está licenciado sob a Licença MIT
