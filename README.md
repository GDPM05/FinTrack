PT
# FinTrack #

O FinTrack é um projeto concebido para demonstrar de forma prática as minhas capacidades em programação, neste caso, Java. Segue o padrão MVC (Model - View - Controller), implementando uma série de funcionalidades, todas desenvolvidas do zero. O 
objetivo principal é apresentar uma aplicação bem estruturada, modular, e que destaque a minha capacidade de desenvolver um sistema completo, utilizando boas práticas de desenvolvimento.

# Tecnologias utilizadas #
- Linguagem de programação: Java
- Base de dados local: SQLite
- Paradigma: Orientação a objetos
- Arquitetura: MVC (Model - View - Controller)
- Ferramentas de Desenvolvimento: Netbeans IDE

# Funcionalidades do Projeto #
  1. Singleton para gestão da App e da  Base de dados:
    - A classe `App` e Database, implementam o padrão de desenho Singleton, de forma a garantir que ambas as classes tenham apenas uma instância, o que é essencial visto que ambas classes são o núcleo da aplicação.
  2. Sistema de Rotas:
    - A aplicação possui um sistema de rotas modular, o que possibilita a adição de novas rotas, sem a necessidade de alterar o código físico. Isto é feito com um ficheiro de configuração `config`, cujo consta com um array de rotas, onde
      cada rota é composta por um nome, um tipo (GET, POST) e o controlador/método a ser chamados.
  3. Listagem e configuração dinâmica de controladores:
    - A classe `App` contém um método destinado a listar e instanciar todos os controladores da aplicação, mais uma vez, evitando a necessidade de alterar o código da classe a cada vez que um novo controlador é criado.
  4. Navegação entre rotas:
    - Suporte para navegação entre páginas.
    - Histórico de rotas para as funcionalidades de "Voltar" e "Avançar".
  5. Integração de Views:
    - A aplicação carrega componenetes visuais de forma dinâmica, permitindo uma maior flexibilidade na UI.

# Como funciona #
  1. __Instância da Aplicação__: A aplicação inicia através da instância da classe `App`, que inicializa a base de dados, o roteador e os controladores.
  2. __Rotas e Navegação__: As rotas são mapeadas no ficheiro `config` e processadas pela classe `Router`. Ao chamar uma rota com o método `callRoute`, o controlador e a ação correspondente são chamados.
  3. __Execução de Controladores__:
    - O sistema usa reflexão para identificar os métodos a serem executados nos controladores.
    - Suporte para métodos que recebem parametros (e.g., via POST) ou que não exigem argumentos.
  4. __Views e Componentes__: A interface principal da aplicação, é gerida pela classe `MainView`, que permite a adição e manipulação de elementos visuais.

# Como executar #

1. Clone o repositório:
    `https://github.com/GDPM05/FinTrack.git`.
2. Importe o projeto para o seu IDE de preferência.
3. Compile e execute.

EN
# FinTrack

The FinTrack project was designed to practically demonstrate my programming skills, particularly in Java. It follows the MVC (Model-View-Controller) pattern, implementing a variety of features entirely from scratch. The primary objective is to present a well-structured, modular application that highlights my ability to develop a complete system using best practices.

## Technologies Used

- **Programming Language:** Java
- **Database:** SQLite (local database)
- **Paradigm:** Object-Oriented Programming
- **Architecture:** MVC (Model-View-Controller)
- **Development Tools:** NetBeans IDE

## Project Features

1. **Singleton for Application and Database Management:**
   - The `App` and `Database` classes implement the Singleton design pattern to ensure only one instance exists. This is essential as both classes serve as the core of the application.

2. **Routing System:**
   - The application features a modular routing system, allowing the addition of new routes without modifying the core code. This is achieved through a configuration file (`config`) containing an array of routes, where each route includes a name, type (GET, POST), and the corresponding controller/method to be called.

3. **Dynamic Controller Configuration:**
   - The `App` class includes a method to list and instantiate all controllers dynamically, again avoiding changes to the class code whenever a new controller is created.

4. **Navigation Between Routes:**
   - Supports navigation between pages.
   - Includes a route history for "Back" and "Forward" functionalities.

5. **Integration of Views:**
   - The application dynamically loads visual components, offering greater flexibility in the user interface.

## How It Works

1. **Application Instance:** The application starts by instantiating the `App` class, which initializes the database, router, and controllers.
2. **Routes and Navigation:** Routes are mapped in the `config` file and processed by the `Router` class. When calling a route with the `callRoute` method, the corresponding controller and action are invoked.
3. **Controller Execution:**
   - The system uses reflection to identify the methods to be executed in the controllers.
   - Supports methods that accept parameters (e.g., via POST) or require no arguments.
4. **Views and Components:** The application's main interface is managed by the `MainView` class, enabling the addition and manipulation of visual elements.

## How to Run

1. Clone the repository:
    `git clone https://github.com/GDPM05/FinTrack.git`

2. Import the project into your preferred IDE.
3. Compile and run.

