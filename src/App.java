import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        Path exemplo = Paths.get("../Compilador/src/exemplo.txt");
        Path dicionario = Paths.get("../Compilador/src/dicionario.txt");
        Path gramatica = Paths.get("../Compilador/src/gramatica.txt");

        List<String> linhasDoExemplo = Files.lines(exemplo).collect(Collectors.toList());
        List<String> linhasDoDicionario = Files.lines(dicionario).collect(Collectors.toList());
        List<String> linhasGramatica = Files.lines(gramatica).collect(Collectors.toList());

        AnalisadorLexico analisadorLexico = new AnalisadorLexico(linhasDoExemplo, linhasDoDicionario);
        // analisadorLexico.validar(analisadorLexico.converterParaToken());

        AnalisadorSintatico analisadorSintatico = new AnalisadorSintatico(linhasGramatica, linhasDoExemplo);
        analisadorSintatico.validar();
    }
}
