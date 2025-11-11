public abstract class Entrada {
    protected int numeroDoAssento;
    protected Espetaculo espetaculo;

    public Entrada(Espetaculo espetaculo, int numeroDoAssento) {
        this.espetaculo = espetaculo;
        this.numeroDoAssento = numeroDoAssento;
    }

    public int getNumeroDoAssento() {
        return numeroDoAssento;
    }

    public abstract double calculaValor();

    @Override
    public String toString() {
        return String.format("Assento %02d - R$ %.2f", numeroDoAssento, calculaValor());
    }
}
