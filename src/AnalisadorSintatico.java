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

    public Boolean validar(){
        System.out.println("-------------------------");
        System.out.println("ANALISE SINTÁTICA:");
        int numerolinha =0;
        Boolean erros = false;
        for(String linha: this.codigoFonte){

            Boolean resultado = validar(linha.trim());

            if (!resultado){
                System.out.print("Validando linha: " + numerolinha + "  => ");
                System.out.println("**** Erro de sintaxe na linha: " + numerolinha +" => " + linha);
                erros = true;
            }
            numerolinha++;
        }
        return !erros;
    }

    public boolean validar(String linha){
        for(String regex: this.gramatica){
            if (linha.matches(regex)){ // achou uma gramatica que a autoriza
                return true;
            }
        }
        System.out.println("Erro na linha: " + linha);
        return false;
    }

}
