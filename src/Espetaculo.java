import java.util.Arrays;

public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos = new boolean[50];

    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        Arrays.fill(assentos, false);
    }

    public void apresentaAssentos() {
        System.out.println("||| Assentos Disponíveis |||");
        for (int linha = 0; linha < 5; linha++) {
            int inicio = 49 - linha * 10;
            int fim = inicio - 9;
            StringBuilder sb = new StringBuilder();
            for (int n = inicio; n >= fim; n--) {
                int assentoNum = n + 1;
                if (assentos[n]) sb.append("XX");
                else sb.append(String.format("%02d", assentoNum));
                if (n > fim) sb.append(" ");
            }
            System.out.println(sb);
        }
    }

    public Entrada novaEntrada(int tipo, int assento) {
        if (assento < 1 || assento > 50 || assentos[assento - 1]) {
            System.out.println("Assento inválido ou já ocupado.");
            return null;
        }
        marcarAssento(assento);
        
        switch (tipo) {
            case 1:
                return new EntradaInteira(this, assento);
            case 2:
                return new EntradaMeia(this, assento);
            case 3:
                return new EntradaProfessor(this, assento);
            default:
                return null;
        }
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s R$ %.2f", nome, data, hora, preco);
    }

    public void marcarAssento(int assento) {
        if (assento >= 1 && assento <= 50)
            assentos[assento - 1] = true;
    }

    public void desmarcarAssento(int assento) {
        if (assento >= 1 && assento <= 50)
            assentos[assento - 1] = false;
    }
}
