public class EntradaMeia extends Entrada {
    public EntradaMeia(Espetaculo espetaculo, int numeroDoAssento) {
        super(espetaculo, numeroDoAssento);
    }

    @Override
    public double calculaValor() {
        return espetaculo.getPreco() * 0.5;
    }
}
