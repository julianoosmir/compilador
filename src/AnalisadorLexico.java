import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class AnalisadorLexico {
    List<String> codigoFonte;
    List<String> dicionario;
   
    public AnalisadorLexico(List<String> codigoFonte, List<String> dicionario) {
        this.codigoFonte = codigoFonte;
        this.dicionario = criarDicionario(dicionario);
    }

    public  List<String>  criarDicionario( List<String> dicionarioTexto){
        List<String> dicionarioCridado = new ArrayList<>();
        dicionarioTexto.forEach(palavras ->{
            String[] vetor = palavras.split("\\|");
            for (String s: vetor){
                dicionarioCridado.add(s);
            }
         });
        return dicionarioCridado;
    }

    public List<String> converterParaToken() {
        List<String> tokens = new ArrayList();
        codigoFonte.forEach(linha -> {
            String termos[] = linha.trim().split("\\s");
            if (linha.contains("\"")) {
                tokens.add(termos[0]);
                String novalinha = linha.replace(termos[0], "").trim();
                tokens.add(novalinha);
            } else {
                for (String t : termos) {
                    tokens.add(t);
                }
            }

        });

        return tokens;
    }


    public void validar(List<String> tokens){
     
        
        Stream<String> valido = tokens.stream().filter(e-> this.dicionario.contains(e));

        Stream<String> invalido = tokens.stream().filter(e-> !this.dicionario.contains(e));
   
        valido.forEach(variavel-> System.out.println("variavel valida: " + variavel));
   
        invalido.forEach(variavel-> System.out.println("variavel invalido: " + variavel));
   
    }
   
}
