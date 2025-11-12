import java.util.Scanner;

public class MackTheather {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Teatro teatro = new Teatro();
        boolean sair = false;

        while (!sair) {
            System.out.println("\n*** MACK THEATHER ***");
            System.out.println("1) Cadastrar Espetáculo");
            System.out.println("2) Cadastrar Cliente");
            System.out.println("3) Compra de Entradas");
            System.out.println("4) Sair");
            System.out.print("Selecione uma opção: ");
            int opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> {
                    System.out.println("*** CADASTRO DE ESPETÁCULO ***");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Data: ");
                    String data = sc.nextLine();
                    System.out.print("Hora: ");
                    String hora = sc.nextLine();
                    System.out.print("Preço da Entrada Inteira: ");
                    double preco = Double.parseDouble(sc.nextLine());
                    teatro.adicionarEspetaculo(new Espetaculo(nome, data, hora, preco));
                }
                case 2 -> {
                    System.out.println("*** CADASTRO DE CLIENTE ***");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    teatro.adicionarCliente(new Cliente(nome, cpf));
                }
                case 3 -> teatro.novaCompra();
                case 4 -> sair = true;
                default -> System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
