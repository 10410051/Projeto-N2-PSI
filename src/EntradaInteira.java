public class EntradaInteira extends Entrada {
    public EntradaInteira(Espetaculo espetaculo, int numeroDoAssento) {
        super(espetaculo, numeroDoAssento);
    }

    @Override
    public double calculaValor() {
        return espetaculo.getPreco();
    }
}
