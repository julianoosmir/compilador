import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AnalisadorSintatico {
    List<String> gramatica;
    List<String> codigoFonte;

    public AnalisadorSintatico(List<String> gramatica, List<String> codigoFonte) {
        this.gramatica = gramatica;
        this.codigoFonte = codigoFonte;
    }



    public void validar(String linha){
        for(String regex: this.gramatica){
            if (linha.matches(regex)){ // achou uma gramatica que a autoriza

            }
        }
    }

}
