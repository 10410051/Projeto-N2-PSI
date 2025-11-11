import java.util.ArrayList;
import java.util.List;

public class Teatro {
    private List<Espetaculo> espetaculos;
    private List<Cliente> clientes;

    public Teatro() {
        espetaculos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void adicionaEspetaculo(Espetaculo e) {
        espetaculos.add(e);
    }

    public void adicionaCliente(Cliente c) {
        clientes.add(c);
    }

    public List<Espetaculo> getEspetaculos() {
        return espetaculos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Espetaculo getEspetaculoPorIndice(int indice1Based) {
        int idx = indice1Based - 1;
        if (idx < 0 || idx >= espetaculos.size()) return null;
        return espetaculos.get(idx);
    }

    public Cliente buscaClientePorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }
}
