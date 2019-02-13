import java.io.IOException;
import org.apache.http.client.ClientProtocolException;

public class Main {
    public static void main(String[] args) throws ClientProtocolException, IOException {

        Client cli = new Client();
        cli.CriarBiblioteca();
        /*cli.AdicionarLivro();
        cli.AdicionarLivro("Java", "DJ", "Nada");
        cli.BuscaLivro(2);*/
        cli.ImprimirBiblioteca();

    }
}