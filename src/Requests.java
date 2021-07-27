import java.io.IOException;
import java.net.MalformedURLException;

public class Requests
{
    public ResponseObject get(String url, String data, String[][] headers, String encoding) throws IOException, MalformedURLException
    {
        Request request = new Request();
        return request.doRequest("GET", url, data, headers, encoding);
    }

    public ResponseObject post(String url, String data, String[][] headers, String encoding) throws IOException, MalformedURLException
    {
        Request request = new Request();
        return request.doRequest("POST", url, data, headers, encoding);
    }

    public ResponseObject head(String url, String data, String[][] headers, String encoding) throws IOException, MalformedURLException
    {
        Request request = new Request();
        return request.doRequest("HEAD", url, "", headers, encoding);
    }
}




