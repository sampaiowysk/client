import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {

        Client cli = new Client();
        cli.CriarBiblioteca();
        cli.AdicionarLivro();
        cli.AdicionarLivro("Java", "DJ", "Nada");
        cli.BuscaLivro(2);
        cli.ImprimirBiblioteca();

    }
}