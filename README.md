# 🎶 Spotify API

Este projeto tem como objetivo explorar a API do Spotify, disponível no site [Spotify for Developers](https://developer.spotify.com/documentation/web-api). A plataforma é bastante intuitiva e oferece uma variedade de funcionalidades para integração com aplicações externas.


## ⚠️ Atenção!!

- Para utilizar este projeto, é necessário ter uma conta no Spotify — tanto contas gratuitas quanto premium são aceitas. Isso se deve ao fato de que, para estabelecer uma conexão com a API, o Spotify precisa gerar um **Client ID** e um **Client Secret**, que juntos permitirão a criação de um token de acesso.
- O link acima leva à documentação oficial, que fornece um passo a passo detalhado para configurar esse processo. A leitura é altamente recomendada para um melhor entendimento e aproveitamento da API.
- No projeto, nos arquivos da pasta **Controllers**, está indicado exatamente onde você deve inserir essas duas informações (Client ID e Client Secret).

> **NÃO compartilhe seu Client ID nem seu Client Secret**. Embora o token gerado por essas credenciais tenha validade de apenas 3600 segundos, essas informações são sensíveis e permitem acesso à sua conta. Por isso, mantenha-as em sigilo absoluto.

- É importante destacar a atenção necessária às rotas de chamada de cada **controller**. Ao criar suas credenciais na plataforma do Spotify, será solicitado o preenchimento de uma URL de redirecionamento — ela é essencial para que o token de autenticação funcione corretamente. Você pode utilizar a porta padrão do projeto: `http://localhost:8080/`.

## 🚀 Funcionalidades

✅ **Login**
  - Contém toda a estrutura de código responsável por estabelecer a conexão com a API do Spotify por meio do token de acesso.
  
✅ **Artista**
  - `http://localhost:8080/spotify/api/artist/{id}`
  - Insira o **ID do artista** no local indicado (no *path* da URL no seu `localhost`) para visualizar as informações do artista na sua timeline.

✅ **Album Track**
  - `http://localhost:8080/spotify/api/albums/{id}`
  - Funciona da mesma forma que o endpoint de artista — basta fornecer o **ID do álbum** no *path* da URL para obter os dados das faixas.

✅ **Albums Releases/albums"**
  - `http://localhost:8080/spotify/api`
  - Neste caso, não é necessário fornecer parâmetros adicionais na URL. As informações de lançamentos de álbuns são recuperadas dinamicamente conforme as atualizações na plataforma do Spotify.


## 🛠️ Tecnologias Utilizadas

Este projeto foi desenvolvido com as seguintes tecnologias:

- [JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) - Linguagem de programação
- [Spring](https://start.spring.io/) - Framework
- [Spotify API](https://developer.spotify.com) - API


## 📦 Instalação

### Pré-requisitos

Antes de começar, você precisará ter instalado:

- Git
- IDE - Utilizei a [Intellij](https://www.jetbrains.com/idea/)
- JDK 21

### Passo a passo

```bash
# Clone este repositório
git clone https://github.com/milenamorais20/spotify-api

# Instale as dependências
npm install  # ou pip install -r requirements.txt

# Inicie a aplicação
npm run dev  # ou outro comando específico
```
## Autor

| [Milena Morais](https://github.com/seu-usuario)          |
| -------------------------------------------------------  |
| 📧[milenamoraistech@gmail.com](mailto:milenamoraistech@gmail.com)  |

## 🤝 Contribuições
Contribuições são bem-vindas! Para contribuir:

- Fork este repositório

- Crie uma branch: git checkout -b minha-feature

- Commit suas mudanças: git commit -m 'feat: minha nova feature'

- Faça push: git push origin minha-feature

- Abra um Pull Request
