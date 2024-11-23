package app;

import java.util.Scanner;
import entities.Administrador;
import entities.Cliente;
import entities.Filme;
import entities.Usuario;
import service.AdministradorService;
import service.ClienteService;
import service.UsuarioService;

public class app {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AdministradorService administradorService = new AdministradorService();
    private static final ClienteService clienteService = new ClienteService();
    private static final UsuarioService usuarioService = new UsuarioService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBem-vindo à Locadora LocNacionais!");
            System.out.print("1 - Login\n2 - Cadastro\n0 - Sair\n: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    realizarLogin();
                    break;
                case 2:
                    realizarCadastro();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void realizarLogin() {
        System.out.println("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = usuarioService.buscarUsuario(email, senha);
        if (usuario == null) {
            System.out.println("Email ou senha incorretos. Tente novamente.");
            return;
        }

        System.out.println("Login efetuado com sucesso!");
        if (usuario instanceof Administrador) {
            menuAdministrador((Administrador) usuario);
        } else if (usuario instanceof Cliente) {
            menuCliente((Cliente) usuario);
        }
    }

    private static void realizarCadastro() {
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("Digite seu telefone: ");
        String telefone = scanner.nextLine();
        System.out.println("Digite seu endereço: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(endereco, email, senha, cpf, endereco, telefone, nome);
        clienteService.cadastrar(cliente);

        System.out.println("Cadastro efetuado com sucesso!");
    }


    // METODOS ADMINISTRADORES
    private static void menuAdministrador(Administrador administrador) {
        int opcao;
        do {
            System.out.println("\n=== Menu Administrador ===");
            System.out.print("1 - Cadastrar Filme\n2 - Remover Filme\n3 - Alterar Preço\n4 - Listar Filmes\n5 - Cadastrar Cliente\n6 - Remover Cliente\n7 - Listar Clientes\n8 - Adicionar Administrador\n9 - Remover Administrador\n10 - Listar Administradores\n0 - Sair\n: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarFilme();
                    break;
                case 2:
                    removerFilme();
                    break;
                case 3:
                    alterarPreco();
                    break;
                case 4:
                    administradorService.listarFilmes();
                    break;
                case 5:
                    realizarCadastro();
                    break;
                case 6:
                    removerCliente();
                    break;
                case 7:
                    administradorService.listarClientes();
                    break;
                case 8:
                    adicionarAdministrador();
                    break;
                case 9:
                    removerAdministrador();
                    break;
                case 10:
                    administradorService.listarAdministradores();
                    break;
                case 0:
                    System.out.println("Saindo do menu administrador.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
        } while (opcao != 0);
    }

    private static void cadastrarFilme() {
        System.out.println("Digite os dados do filme:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Sinopse: ");
        String sinopse = scanner.nextLine();
        System.out.print("Duração: ");
        String duracao = scanner.nextLine();
        System.out.print("Classificação: ");
        String classificacao = scanner.nextLine();
        System.out.print("Diretor: ");
        String diretor = scanner.nextLine();
        System.out.print("Data de Lançamento: ");
        String dataLancamento = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        administradorService.cadastrarFilme(titulo, genero, sinopse, duracao, classificacao, diretor, dataLancamento, true, false, preco);
        System.out.println("Filme cadastrado com sucesso!");
    }

    private static void removerFilme() {
        System.out.print("Digite o ID do filme a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        administradorService.removerFilme(id);
        System.out.println("Filme removido com sucesso!");
    }

    private static void alterarPreco() {
        System.out.print("Digite o ID do filme para alterar o preço: ");
        int id = scanner.nextInt();
        System.out.print("Digite o novo preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        administradorService.alterarPreco(id, preco);
        System.out.println("Preço alterado com sucesso!");
    }

    private static void removerCliente() {
        System.out.print("Digite o ID do cliente a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        administradorService.removerCliente(id);
        System.out.println("Cliente removido com sucesso!");
    }

    private static void adicionarAdministrador() {
        System.out.println("Digite os dados do novo administrador:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Administrador administrador = new Administrador(email, senha, nome);
        administradorService.adicionarAdministrador(administrador);
        System.out.println("Administrador cadastrado com sucesso!");
    }

    private static void removerAdministrador() {
        System.out.print("Digite o ID do administrador a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        administradorService.removerAdministrador(id);
        System.out.println("Administrador removido com sucesso!");
    }

    // METODOS CLIENTES

    public static void menuCliente(Cliente cliente){
        int opcao;
        do{
            System.out.println("=== Menu Cliente ===");
            System.out.print("1 - Listar Filmes\n2 - Reservar Filme\n3 - Devolver Filme\n 0 - Sair\n: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    clienteService.listarFilmes();
                    break;
                case 2:
                    System.out.print("Digite o ID do filme a ser reservado: ");
                    int idFilme = scanner.nextInt();
                    scanner.nextLine();
                    clienteService.reservarFilme(cliente.getIdUsuario(), idFilme);
                    break;
                case 3:
                    System.out.print("Digite o ID do filme a ser devolvido: ");
                    idFilme = scanner.nextInt();
                    Filme filme = clienteService.buscarFilme(idFilme);
                    scanner.nextLine();
                    clienteService.devolverFilme(cliente, filme);
                    break;
                case 0:
                    System.out.println("Saindo do menu cliente.");
                    break;
                default:
                    break;
            }

        }while(opcao != 0);
    }

    public static void listarFilmes(){
        
    }
}
