public class EntradaProfessor extends Entrada {
    private Espetaculo espetaculo;

    public EntradaProfessor(Espetaculo espetaculo, int numeroDoAssento) {
        super(numeroDoAssento);
        this.espetaculo = espetaculo;
    }

    @Override
    public double calculaValor() {
        return espetaculo.getPreco() * 0.6;
    }
}
