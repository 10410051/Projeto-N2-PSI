import java.util.Scanner;

public class MackTheather {
    private static Teatro teatro = new Teatro();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            imprimeMenu();
            int opc = leInteiro("Selecione uma opção: ");
            switch (opc) {
                case 1:
                    cadastrarEspetaculo();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    compraDeEntradas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
        sc.close();
    }

    private static void imprimeMenu() {
        System.out.println();
        System.out.println("*** MACK THEATHER ***");
        System.out.println("1) Cadastrar Espetáculo");
        System.out.println("2) Cadastrar Cliente");
        System.out.println("3) Compra de Entradas");
        System.out.println("4) Sair");
    }

    private static void cadastrarEspetaculo() {
        System.out.println();
        System.out.println("*** CADASTRO DE ESPETÁCULO ***");
        System.out.print("Nome do Espetáculo: ");
        String nome = sc.nextLine();
        System.out.print("Data: ");
        String data = sc.nextLine();
        System.out.print("Hora: ");
        String hora = sc.nextLine();
        double preco = leDouble("Preço da Entrada Inteira: ");
        Espetaculo e = new Espetaculo(nome, data, hora, preco);
        teatro.adicionaEspetaculo(e);
        System.out.println("\n>>> Retorna ao menu principal <<<");
    }

    private static void cadastrarCliente() {
        System.out.println();
        System.out.println("*** CADASTRO DE CLIENTE ***");
        System.out.print("Nome do Cliente: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        Cliente c = new Cliente(nome, cpf);
        teatro.adicionaCliente(c);
        System.out.println("\n>>> Retorna ao menu principal <<<");
    }

    private static void compraDeEntradas() {
        System.out.println();
        System.out.println("*** VENDA DE ENTRADAS - ESPETÁCULOS ***");
        if (teatro.getEspetaculos().isEmpty()) {
            System.out.println("Não há espetáculos cadastrados.");
            return;
        }

        int i = 1;
        for (Espetaculo e : teatro.getEspetaculos()) {
            System.out.println(i + ") " + e.toString());
            i++;
        }
        int escolha = leInteiro("Selecione um espetáculo: ");
        Espetaculo selecionado = teatro.getEspetaculoPorIndice(escolha);
        if (selecionado == null) {
            System.out.println("Espetáculo inválido.");
            return;
        }


        Pedido pedido = new Pedido();

        boolean comprarMais = true;
        while (comprarMais) {
            System.out.println();
            selecionado.apresentaAssentos();
            int assento = leInteiro("Selecione um assento: ");
            if (!selecionado.isAssentoDisponivel(assento)) {
                System.out.println("Assento inválido ou já ocupado. Tente outro.");
                continue;
            }

            System.out.println();
            System.out.println("||| Tipos de Entrada |||");
            System.out.println("1) Inteira");
            System.out.println("2) Meia        50% do valor da entrada");
            System.out.println("3) Professor   40% do valor da entrada");
            int tipo = leInteiro("Selecione um tipo de entrada: ");

            Entrada nova = null;
            switch (tipo) {
                case 1:
                    nova = new EntradaInteira(selecionado, assento);
                    break;
                case 2:
                    nova = new EntradaMeia(selecionado, assento);
                    break;
                case 3:
                    nova = new EntradaProfessor(selecionado, assento);
                    break;
                default:
                    System.out.println("Tipo inválido. Voltando ao menu de seleção de assento.");
                    continue;
            }


            boolean marcou = selecionado.marcarAssento(assento);
            if (!marcou) {
                System.out.println("Falha ao marcar assento (talvez ocupada).");
            } else {
                pedido.adicionaEntrada(nova);
                System.out.println("Entrada adicionada: " + nova.toString());
            }

            System.out.print("Deseja comprar uma outra entrada (S/N)? ");
            String resposta = sc.nextLine().trim();
            if (!resposta.equalsIgnoreCase("S")) {
                comprarMais = false;
            }
        }

        System.out.print("Informe o CPF do Cliente Cadastrado: ");
        String cpf = sc.nextLine().trim();
        Cliente cliente = teatro.buscaClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado. Operação cancelada.");

            for (Entrada e : pedido.getEntradas()) {
                int num = e.getNumeroDoAssento();
            }
            return;
        }

        cliente.adicionaPedido(pedido);
        double total = pedido.calculaValorTotal();
        System.out.printf("Valor Total: R$ %.2f%n", total);
        System.out.println("\n>>> Retorna ao menu principal <<<");
    }

    private static int leInteiro(String prompt) {
        while (true) {
            System.out.print(prompt);
            String linha = sc.nextLine();
            try {
                return Integer.parseInt(linha.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    private static double leDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String linha = sc.nextLine();
            try {
                return Double.parseDouble(linha.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Valor inválido. Digite um número (ex: 30 ou 30.0).");
            }
        }
    }
}
