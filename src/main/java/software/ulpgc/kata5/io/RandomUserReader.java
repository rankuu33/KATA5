package software.ulpgc.kata5.io;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

import static org.jsoup.Connection.Method.GET;

public class RandomUserReader implements UserReader {
    @Override
    public String read() {
        try {
            return read("https://randomuser.me/api/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String read(String url) throws IOException {
        Connection.Response response = Jsoup.connect(url)
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(GET)
                .execute();
        if (response.statusCode() != 200) throw new RuntimeException("Error: " + response.statusCode());{}
        return response.body();
    }
}
