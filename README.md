🎬 Movie App - Interação com a API do TMDB
Este projeto é um aplicativo Android que consome a API do The Movie Database (TMDB) para exibir informações sobre filmes, como filmes populares, filmes em cartaz, avaliações e detalhes. O aplicativo foi desenvolvido seguindo boas práticas de desenvolvimento Android, como MVVM, Clean Architecture, e utilizando tecnologias modernas como Corrotinas, Koin e Try-Catch para tratamento de erros.
________________________________________
🚀 Funcionalidades
•	4 Listagem de filmes
•	Detalhes do filme (sinopse, avaliação, elenco, etc.)
•	Avaliações dos usuários
•	Filmes em cartaz
•	Pesquisa de filmes
•	Tratamento de erros com feedback ao usuário
________________________________________
🛠 Tecnologias e Bibliotecas
•	Kotlin: Linguagem principal do projeto.
•	Corrotinas: Para operações assíncronas e chamadas à API.
•	Retrofit: Cliente HTTP para consumir a API do TMDB.
•	Koin: Injeção de dependências.
•	MVVM (Model-View-ViewModel): Arquitetura para separação de responsabilidades.
•	Clean Architecture: Divisão do projeto em camadas (Data, Domain, Presentation).
•	LiveData: Para observar mudanças nos dados e atualizar a UI.
•	ViewBinding: Para vincular views de forma segura.
•	Glide: Carregamento e exibição de imagens.
•	Try-Catch: Tratamento de exceções em chamadas à API e operações assíncronas.
________________________________________
🏗 Estrutura do Projeto (Clean Architecture)
O projeto está organizado em três camadas principais:
1. Data
•	Repositórios: Implementação concreta dos repositórios.
•	API: Chamadas à API do TMDB usando Retrofit.
•	Modelos de Dados: Classes de dados (DTOs) para mapear as respostas da API.
2. Domain
•	Casos de Uso: Lógica de negócio do aplicativo.
•	Modelos de Domínio: Entidades que representam os dados do aplicativo.
•	Repositórios: Interfaces que definem os contratos para acesso aos dados.
3. Presentation
•	ViewModels: Responsáveis por fornecer dados para a UI.
•	Views: Activities, Fragments e componentes de UI.
•	Binding Adapters: Extensões para facilitar a vinculação de dados à UI.
________________________________________
🚨 Tratamento de Erros
O projeto utiliza Try-Catch para capturar exceções durante chamadas à API e operações assíncronas. Em caso de erro, uma mensagem é exibida ao usuário por meio de um LiveData de errorMessage.
________________________________________
📝 Como Executar o Projeto
1.	Clone o repositório:
git clone https://github.com/seu-usuario/seu-repositorio.git
2.	Abra o projeto no Android Studio.
3.	Adicione sua chave de API do TMDB no arquivo local.properties:
TMDB_API_KEY=sua_chave_aqui
4.	Execute o aplicativo em um dispositivo ou emulador Android.
________________________________________
📄 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.
________________________________________
🙌 Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.
