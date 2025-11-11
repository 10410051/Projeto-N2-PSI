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

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public boolean isAssentoDisponivel(int numeroAssento) {
        if (numeroAssento < 1 || numeroAssento > 50) return false;
        return !assentos[numeroAssento - 1];
    }

    public boolean marcarAssento(int numeroAssento) {
        if (numeroAssento < 1 || numeroAssento > 50) return false;
        if (assentos[numeroAssento - 1]) return false;
        assentos[numeroAssento - 1] = true;
        return true;
    }

    public void apresentaAssentos() {
        System.out.println("||| Assentos Disponíveis |||");
        for (int linha = 0; linha < 5; linha++) {
            int inicio = 49 - linha * 10; 
            int fim = inicio - 9;
            StringBuilder sb = new StringBuilder();
            for (int n = inicio; n >= fim; n--) {
                int assentoNum = n + 1; 
                if (assentos[n]) {
                    sb.append("XX");
                } else {
                    
                    sb.append(String.format("%02d", assentoNum));
                }
                if (n > fim) sb.append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s R$ %.2f", nome, data, hora, preco);
    }
}
