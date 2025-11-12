import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void adicionaPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
