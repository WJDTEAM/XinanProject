package tqm.bianfeng.com.xinanproject.Util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by johe on 2017/4/21.
 */

public class HtmlHelper {
    public static byte[] readStream(InputStream inputStream) throws Exception {
        byte[] buffer = new byte[1024];
        int len = -1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        while ((len = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }

        inputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String testGetHtml(String urlpath) throws Exception {
        URL url = new URL(urlpath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(6 * 1000);
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() == 200) {
            InputStream inputStream = conn.getInputStream();
            byte[] data = readStream(inputStream);
            String html = new String(data);
            return html;
        }
        return null;
    }


}
