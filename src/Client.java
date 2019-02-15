import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

//import org.apache.http.impl.client.DefaultHttpClient;

public class Client{

    public void CriarBiblioteca () throws ClientProtocolException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://localhost:8080/lib");
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void ImprimirBiblioteca () throws ClientProtocolException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8080/lib");
        HttpResponse response = client.execute(request);
        System.out.println(response.getStatusLine());
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void BuscaLivro (int id) throws ClientProtocolException, IOException, URISyntaxException {
//        URIBuilder builder = new URIBuilder("http://localhost:8080/book");
//        builder.setParameter("parts", "all").setParameter("action", "finish");

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8080/book/"+id);

        /*URI uri = new URIBuilder(request.getURI()).addParameter("bookId", Integer.toString(id)).build();
        ((HttpRequestBase) request).setURI(uri);*/

        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void AdicionarLivro () throws ClientProtocolException, IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://localhost:8080/book");

        String json = "{\"id\": 1,\"title\": \"title\",\"author\": \"author\",\"desc\": \"desc\"}";
        //System.out.println(json);
        StringEntity params = new StringEntity(json);
        post.setEntity(params);
        post.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void AdicionarLivro (String title, String autor, String desc) throws ClientProtocolException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://localhost:8080/book");

        String json = "{\"id\": 1,\"title\": \""+title+"\",\"author\": \""+autor+"\",\"desc\": \""+desc+"\"}";
        //System.out.println(json);
        StringEntity params = new StringEntity(json);
        post.setEntity(params);
        post.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

}
