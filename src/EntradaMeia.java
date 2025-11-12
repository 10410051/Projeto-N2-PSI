public class EntradaMeia extends Entrada {
    private Espetaculo espetaculo;

    public EntradaMeia(Espetaculo espetaculo, int numeroDoAssento) {
        super(numeroDoAssento);
        this.espetaculo = espetaculo;
    }

    @Override
    public double calculaValor() {
        return espetaculo.getPreco() * 0.5;
    }
}
