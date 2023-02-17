# API de Cadastro de Denúncia
Esta é uma API Spring Boot que permite o cadastro de denúncias, incluindo informações do denunciante (nome e CPF) e da denúncia (título e descrição), bem como a localização geográfica do denunciante (latitude e longitude) que é utilizada para buscar o endereço correspondente e persistir no banco de dados. A aplicação utiliza o banco de dados Postgres para persistência de dados.

### Funcionalidades
A API permite que os usuários realizem as seguintes operações:

- Cadastro de uma nova denúncia (nome do denunciante, CPF, título, descrição, latitude e longitude), onde fazemos a busca do endereço a partir da longitude e latitude informada;
- Por questão de otimização e performace foi utilizado o cache para fazer a requisição para buscar o endereço do denunciante;

### Para executar a aplicação, é necessário ter as seguintes ferramentas instaladas:

- Java 11
- Maven
- Docker
- Postgres
### Executando a aplicação com Docker
Você pode executar a aplicação como um contêiner Docker com o seguinte comando:

````
docker-compose up
````
Isso irá criar e iniciar um contêiner com a aplicação, banco de dados e outras dependências.

### Documentação da API com Swagger
A API é documentada utilizando o Swagger. Para acessar a documentação da API, execute a aplicação e acesse o seguinte URL em um navegador web:

bash
Copy code
http://localhost:8080/swagger-ui.html
A partir da documentação do Swagger, é possível testar a API e ver exemplos de requisições e respostas.
