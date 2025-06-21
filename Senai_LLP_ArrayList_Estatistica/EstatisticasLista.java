import java.util.*;

public class EstatisticasLista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> valores = new ArrayList<>();

        while (true) {
            System.out.print("Informe um valor (ou pressione Enter para finalizar): ");
            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) break;
            try {
                valores.add(Double.parseDouble(entrada.replace(",", ".")));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido, tente novamente.");
            }
        }

        if (valores.isEmpty()) {
            System.out.println("Nenhum valor informado.");
            return;
        }

        // Média
        double soma = 0;
        for (double v : valores) soma += v;
        double media = soma / valores.size();

        // Moda
        Map<Double, Integer> frequencias = new HashMap<>();
        for (double v : valores) {
            frequencias.put(v, frequencias.getOrDefault(v, 0) + 1);
        }
        int maxFreq = Collections.max(frequencias.values());
        double moda = valores.get(0);
        for (Map.Entry<Double, Integer> entry : frequencias.entrySet()) {
            if (entry.getValue() == maxFreq) {
                moda = entry.getKey();
                break;
            }
        }

        // Mínimo e Máximo
        double minimo = Collections.min(valores);
        double maximo = Collections.max(valores);

        // Desvio padrão
        double somaQuadrados = 0;
        for (double v : valores) somaQuadrados += Math.pow(v - media, 2);
        double desvioPadrao = Math.sqrt(somaQuadrados / valores.size());

        System.out.printf("média = %.3f\n", media);
        System.out.printf("moda = %.3f\n", moda);
        System.out.printf("mínimo = %.3f\n", minimo);
        System.out.printf("máximo = %.3f\n", maximo);
        System.out.printf("desvio padrão = %.3f\n", desvioPadrao);
    }
}