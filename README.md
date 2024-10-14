<h1>Pokémon Battle API</h1>


Uma API desenvolvida em Spring Boot para avaliação da matéria de back-end, que permite que dois Pokémons lutem entre si, utilizando dados de uma API externa para determinar o HP e o ataque de cada Pokémon.

Funcionalidades
Permite realizar batalhas entre dois Pokémons através da rota /battle.
Realiza batalhas entre um pokemon buscado na API e um oponente que você pode escolher a partir de uma requisição, com rota /boss.
Integração com a API pública de Pokémons para obter informações de status (HP e Ataque) de cada Pokémon.
Retorna o vencedor da batalha com base nos atributos de cada Pokémon.

<h2>A aplicação estará acessível em:</h2>

```http://localhost:8080/api```

<h2>Informações sobre projeto</h2>

Método: GET

```http://localhost:8080/api/sobre```

<h2>Batalha entre dois pokemons</h2>

Neste endpoint é possivel colocar nome de dois pokemons por querry, ele ira buscar na base de dados da Api PokeApi, e retornará o vencedor.

Método: GET

```Exemplo: http://localhost:8080/api/battle?pokemon1=pikachu&pokemon2=bulbasaur```

<h2>Batalha entre pokemon e boss</h2>

Neste endpoint é possivel colocar nome de um pokemon, e enviar para o corpo da requisição um inimigo para enfrenta-lo, use sua criatividade.

Método: POST

```Exemplo: http://localhost:8080/api/boss?pokemon1=Pikachu ```

Ex. corpo Json:
```
{
    "name": "Charizard",
    "hp": 100,
    "attack": 50
}
```
Recomendado utilizar o Header:
```Key: content-type Value: application/json```

<h2>Comandos docker:</h2>

```docker build -t pokemon-battle-app```

```docker run -p 8080:8080 pokemon-battle-app```

Opcional: 
```docker-compose up --build```

