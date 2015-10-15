package cdp.ci.blokhina;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {
    private static final String URL = "https://dl.dropboxusercontent.com/u/98396761/NewTxt.txt";

    public static void main(String[] args) throws IOException {
        URL url = new URL(URL);
        try (ReadableByteChannel rbc = Channels.newChannel(url.openStream());
             FileOutputStream fos = new FileOutputStream("target\\File.txt")) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            System.out.println("File was created!");
        } catch (IOException e) {
            System.out.println("Something was wrong during the download");
        }
    }
}
