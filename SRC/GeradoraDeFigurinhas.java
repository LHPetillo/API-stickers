import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    /**
     * @throws Exception
     */
    public void cria (InputStream InputStream, String nomeArquivo) throws Exception {

        // leitura da imagem
        //InputStream InputStream = new FileInputStream(new File("entrada/filme-maior.jpg"));
        //InputStream InputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage ImagemOriginal = ImageIO.read(InputStream);
        

        // criar nova imagem em memória com transpârencia e com tamanho novo
        int largura = ImagemOriginal.getWidth();
        int altura = ImagemOriginal.getHeight();
        int novaAltura = altura + 100;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(ImagemOriginal, 0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 32);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA    ", 35, novaAltura - 75);
        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo));


    }

}
