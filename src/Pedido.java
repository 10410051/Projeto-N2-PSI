import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Entrada> entradas;

    public Pedido() {
        entradas = new ArrayList<>();
    }

    public void adicionaEntrada(Entrada e) {
        entradas.add(e);
    }

    public double calculaValorTotal() {
        double total = 0.0;
        for (Entrada e : entradas) {
            total += e.calculaValor();
        }
        return total;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido com ").append(entradas.size()).append(" entradas:\n");
        for (Entrada e : entradas) {
            sb.append("  ").append(e.toString()).append("\n");
        }
        sb.append(String.format("Total: R$ %.2f\n", calculaValorTotal()));
        return sb.toString();
    }
}
