import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
 
        // fazer uma conexão http e buscar os top 250 filmes
        //String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        String url = "https://lpetillo-linguagens-app.herokuapp.com/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        // NASA
        //String url = "https://api.nasa.gov/planetary/apod?api_key=wX978m42XDPGwZSD40f72ovkzhdXheZHkcBXkgUT";
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        // exibir e manipular os dados
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        
        for (int i = 0; i < 3; i++) {
             
            Conteudo conteudo = conteudos.get(i);

             //String rank = conteudo.get("imDbRating") + "⭐";
             
             
             InputStream InputStream = new URL(conteudo.getUrlImagem()).openStream();
             String nomeArquivo ="../saida/" + conteudo.getTitulo().replace(":", "-") + ".png";
             System.out.println(conteudo.getTitulo());
             geradora.cria(InputStream, nomeArquivo);    
        
            
            System.out.println();
            //System.out.println(conteudo.get("imDbRating"));
            
            
        }
    }
}
