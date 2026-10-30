import java.util.Scanner;

public class FormatadorTelefoneAvancado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== DETECTOR E FORMATADOR DE TELEFONES ===");
        System.out.println("Digite um número ou texto:");
        String entrada = scanner.nextLine().trim();

        processarEntrada(entrada);

        scanner.close();
    }

    public static void processarEntrada(String entrada) {
        if (entrada.isEmpty()) {
            System.out.println("Entrada inválida: Nenhuma informação foi digitada.");
            return;
        }

        // Extrai apenas os dígitos numéricos da entrada
        String apenasNumeros = entrada.replaceAll("\\D", "");
        int qtdDigitos = apenasNumeros.length();

        // Valida se a quantidade de dígitos corresponde aos formatos aceitos (8, 9, 10 ou 11)
        if (qtdDigitos < 8 || qtdDigitos > 11) {
            System.out.println("Entrada inválida: Não se trata de um número de telefone válido (contém "
                    + qtdDigitos + " dígitos aproveitáveis).");
            return;
        }

        String tipoDispositivo = identificarTipo(qtdDigitos);
        String numeroFormatado = aplicarMascara(apenasNumeros);

        boolean ehApenasNumeros = entrada.matches("\\d+");
        boolean estaFormatadoCorretamente = entrada.equals(numeroFormatado);

        System.out.println("\n--- RESULTADO DA ANÁLISE ---");

        if (estaFormatadoCorretamente) {
            System.out.println("Situação: Número recebido já com a máscara correta.");
            System.out.println("Tipo: " + tipoDispositivo);
            System.out.println("Resultado: " + numeroFormatado);

        } else if (ehApenasNumeros) {
            System.out.println("Situação: Recebido apenas números sem formatação.");
            System.out.println("Tipo: " + tipoDispositivo);
            System.out.println("Resultado Formatado: " + numeroFormatado);

        } else {
            System.out.println("Situação: Entrada com máscara incorreta ou caracteres extras.");
            System.out.println("Tipo: " + tipoDispositivo);
            System.out.println("Resultado Corrigido: " + numeroFormatado);
        }
    }

    private static String identificarTipo(int qtdDigitos) {
        switch (qtdDigitos) {
            case 8:  return "Telefone Fixo (sem DDD)";
            case 9:  return "Telefone Celular (sem DDD)";
            case 10: return "Telefone Fixo (com DDD)";
            case 11: return "Telefone Celular (com DDD)";
            default: return "Desconhecido";
        }
    }

    private static String aplicarMascara(String numeros) {
        switch (numeros.length()) {
            case 8:  return numeros.replaceFirst("(\\d{4})(\\d{4})", "$1-$2");
            case 9:  return numeros.replaceFirst("(\\d{5})(\\d{4})", "$1-$2");
            case 10: return numeros.replaceFirst("(\\d{2})(\\d{4})(\\d{4})", "($1)$2-$3");
            case 11: return numeros.replaceFirst("(\\d{2})(\\d{5})(\\d{4})", "($1)$2-$3");
            default: return numeros;
        }
    }
}