public class EntradaInteira extends Entrada {
    private Espetaculo espetaculo;

    public EntradaInteira(Espetaculo espetaculo, int numeroDoAssento) {
        super(numeroDoAssento);
        this.espetaculo = espetaculo;
    }

    @Override
    public double calculaValor() {
        return espetaculo.getPreco();
    }
}
