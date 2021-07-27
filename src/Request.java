import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;

public class Request
{

    public ResponseObject doRequest(String method, String url, String body, String[][] headers, String encoding) throws IOException
    {
        // START TIME
        Long timeStart         = System.currentTimeMillis();

        // URL OBJECT
        URL url_               = new URL(url);

        // ENCODE INCOMING DATA
        String encodedData     = URLEncoder.encode( body, encoding); // "UTF-8"

        // OPEN URL CONNECTION
        HttpURLConnection conn = (HttpURLConnection) url_.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod(method);

        // PROCESS HEADERS
        for (String[] e: headers){
            conn.setRequestProperty( e[0], e[1] );
        }

        // SET CONTENT LENGTH
        conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));

        // PIPE OUTPUT STREAM
        OutputStream os = conn.getOutputStream();
        os.write(encodedData.getBytes());

        // GET STATUS CODE
        BufferedReader br = null;
        boolean errCode;
        if (100 <= conn.getResponseCode() && conn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            errCode = false;
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            errCode = true;
        }

        // END TIME
        Long timeEnd                  = System.currentTimeMillis();
        Long elapsedMillis            = timeEnd - timeStart;

        // RETURN RESPONSE OBJECT
        return new ResponseObject(errCode, br.lines().collect(Collectors.joining()), conn.getResponseCode(), elapsedMillis, conn);

    }
}
