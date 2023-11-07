#  👨‍💻 Prova Técnica 

## Índice
-  <a>Arquitetura e modelagem </a>
-  <a>Estratégias Possíveis </a>
-  <a>Escolha da Estratégia </a>

## 🏗️Arquitetura e modelagem 

O projeto adota uma arquitetura em camadas seguindo o padrão MVC, com a separação clara das responsabilidades entre os componentes. O modelo de dados é bem estruturado, utilizando classes DTO para transferência de dados e seguindo o princípio de encapsulamento. A arquitetura é fácil de entender e seguir.

└── com
    └── provateTecnica
        └── Api
            ├── config
            │   ├── AppConfig.java
            │   └── CacheConfig.java
            ├── controller
            │   └── UserController.java
            ├── DTO
            │   ├── ApiResponseDTO.java
            │   ├── UserDTO.java
            │   └── dto
            │       ├── CoordinatesDto.java
            │       ├── DobDto.java
            │       ├── IdDto.java
            │       ├── LoginDto.java 
            │       ├── LocationDto.java 
            │       ├── NameDto.java 
            │       ├── PageInfoDto.java 
            │       ├── PictureDto.java 
            │       ├── RegisteredDto.java 
            │       ├── StreetDto.java 
            │       └── TimezoneDto.java 
            ├── exception
            │   ├── ApiErroException.java
            │   ├── CustomException.java
            │   └── GlobalException.java
            ├── model
            │   └── UserModel.java
            ├── service
            │   └── UserService.java
            └── util
                ├── CellFormatUtil.java
                ├── DataUtil.java
                └── StaticsUtil.java

## 🔍Estratégias Possíveis 
    Foram consideradas diferentes estratégias para caching, incluindo o uso de Caffeine e Ehcache, além do Redis como um mecanismo de cache distribuído. Também foram considerados padrões de projeto como o Circuit Breaker para lidar com falhas em chamadas de API externas.

##   💻  Escolha da Estratégia 
    A escolha da estratégia de caching utilizando o Caffeine foi adequada para o projeto, considerando a simplicidade de configuração e integração com o Spring Boot. A implementação do Circuit Breaker não foi feita nesse nomento devido ao pouco tempo disponivel por conta do serviço atual.