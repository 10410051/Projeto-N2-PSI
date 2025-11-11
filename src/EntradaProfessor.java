public class EntradaProfessor extends Entrada {
    public EntradaProfessor(Espetaculo espetaculo, int numeroDoAssento) {
        super(espetaculo, numeroDoAssento);
    }

    @Override
    public double calculaValor() {
        return espetaculo.getPreco() * 0.6; 
    }
}
