package aoc.cubes.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

class Download{
    public static URL getUrl(String rawTextUrl) throws IOException{
        URL url = new URL(rawTextUrl);
        try {
            url.openStream();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return url;
}
}

