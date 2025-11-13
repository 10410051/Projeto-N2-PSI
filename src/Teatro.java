import java.util.ArrayList;
import java.util.Scanner;

public class Teatro {
    private Pedido carrinho = null;
    private Espetaculo espetaculoSelecionado = null;
    private ArrayList<Espetaculo> espetaculos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public Teatro() {
        Espetaculo espetaculoPadrao = new Espetaculo(
            "O Fantasma da Ópera",
            "25/12/2025",
            "20:00",
            120.00
        );
        this.adicionarEspetaculo(espetaculoPadrao);

        Espetaculo espetaculo2 = new Espetaculo(
            "O Rei Leão", 
            "30/12/2025", 
            "21:00", 
            150.00
        );
        this.adicionarEspetaculo(espetaculo2);
    }

    public void novaCompra() {
        carrinho = new Pedido();
        apresentaEspetaculos();
        System.out.print("Selecione um espetáculo: ");
        int numero = Integer.parseInt(sc.nextLine());
        selecionaEspetaculo(numero);

        boolean continuar = true;
        while (continuar) {
            espetaculoSelecionado.apresentaAssentos();
            System.out.print("Selecione o assento: ");
            int assento = Integer.parseInt(sc.nextLine());
            System.out.println("1) Inteira\n2) Meia\n3) Professor");
            System.out.print("Selecione o tipo de entrada: ");
            int tipo = Integer.parseInt(sc.nextLine());

            novaEntrada(tipo, assento);

            System.out.print("Deseja comprar outra entrada (S/N)? ");
            continuar = sc.nextLine().equalsIgnoreCase("S");
        }

        System.out.print("Informe o CPF do cliente: ");
        String cpf = sc.nextLine();
        double valorTotal = finalizaCompra(cpf);
        System.out.printf("Valor Total: R$ %.2f%n", valorTotal);
    }

    public void apresentaEspetaculos() {
        if (espetaculos.isEmpty()) {
            System.out.println("Nenhum espetáculo cadastrado.");
            return;
        }
        for (int i = 0; i < espetaculos.size(); i++) {
            System.out.println((i + 1) + ") " + espetaculos.get(i));
        }
    }

    public void selecionaEspetaculo(int numero) {
        if (numero >= 1 && numero <= espetaculos.size()) {
            espetaculoSelecionado = espetaculos.get(numero - 1);
        } else {
            espetaculoSelecionado = null;
        }
    }

    public void novaEntrada(int tipo, int assento) {
        if (espetaculoSelecionado == null) return;
        Entrada e = espetaculoSelecionado.novaEntrada(tipo, assento);
        if (e != null) carrinho.adicionaEntrada(e);
    }

    public double finalizaCompra(String cpf) {
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado. Compra cancelada.");
            for (Entrada e : carrinho.getEntradas()) {
                espetaculoSelecionado.desmarcarAssento(e.getNumeroDoAssento());
            }
            return 0;
        }

        cliente.adicionaPedido(carrinho);
        return carrinho.calculaValorTotal();
    }

    public void adicionarEspetaculo(Espetaculo e) {
        espetaculos.add(e);
    }

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }
}