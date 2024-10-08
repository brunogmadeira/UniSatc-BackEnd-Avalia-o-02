<h1>Pokémon Battle API</h1>


Uma API desenvolvida em Spring Boot que permite que dois Pokémons lutem entre si, utilizando dados de uma API externa para determinar o HP e o ataque de cada Pokémon.

Funcionalidades
Permite realizar batalhas entre dois Pokémons através da rota /battle.
Integração com a API pública de Pokémons para obter informações de status (HP e Ataque) de cada Pokémon.
Retorna o vencedor da batalha com base nos atributos de cada Pokémon.

<h2>A aplicação estará acessível em:</h2>
```http://localhost:8080/api```

Endpoints da API
```/battle?pokemon1={nome}&pokemon2={nome}:```
Método: GET
Descrição: Faz a batalha entre dois Pokémons e retorna o vencedor.
```Exemplo: http://localhost:8080/battle?pokemon1=pikachu&pokemon2=bulbasaur```

<h2>Comandos docker:</h2>

```docker build -t pokemon-battle-app```

```docker run -p 8080:8080 pokemon-battle-app```

Opcional: 
```docker-compose up --build```

