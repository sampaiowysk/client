import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import org.apache.http.impl.client.DefaultHttpClient;

public class Client{

    public void CriarBiblioteca () throws ClientProtocolException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://virtserver.swaggerhub.com/dtidigital/biblioteca/1.0.0/lib/");
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void ImprimirBiblioteca () throws ClientProtocolException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://virtserver.swaggerhub.com/dtidigital/biblioteca/1.0.0/lib");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void BuscaLivro (int id) throws ClientProtocolException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8080/lib/"+id);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void AdicionarLivro () throws ClientProtocolException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://localhost:8080/lib/");
//        StringEntity input = new StringEntity("python");
//        post.setEntity(input);
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void AdicionarLivro (String title, String autor, String desc) throws ClientProtocolException, IOException {
        //HttpClient client = new DefaultHttpClient(); //Descontinuado
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://localhost:8080/lib/"+title+"&"+autor+"&"+desc);
//        StringEntity params =new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
//        post.addHeader("content-type", "application/x-www-form-urlencoded");
//        post.setEntity(params);
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

}
