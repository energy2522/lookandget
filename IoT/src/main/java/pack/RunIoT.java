package pack;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;

import static org.bytedeco.javacpp.opencv_core.IplImage;
import static org.bytedeco.javacpp.opencv_core.cvFlip;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;


/**
 * Created by gtiwari on 1/3/2017.
 */

public class RunIoT {
    private static final String urlString = "http://192.168.0.101:8080/server/admin/image/iot";
    private final int INTERVAL = 5000;
    private String typeContent;
    private Integer idClient;
    private HttpURLConnection urlConnection;

    public RunIoT(String typeContent, Integer idClient) throws IOException {
        this.idClient = idClient;
        this.typeContent = typeContent;
        URL url = new URL(urlString);

        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "application/json");
        urlConnection.setConnectTimeout(50000);
    }

    public void run() throws IOException {

        FrameGrabber grabber = new VideoInputFrameGrabber(0); // 1 for next camera
        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        IplImage img;
        int i = 0;
        try {
            grabber.start();
            while (true) {
                StringBuilder sb = new StringBuilder("{");
                sb.append("\"typeOfContent\" : \"" + typeContent + "\"").append(",");
                sb.append("\"idClient\" : \"" + idClient + "\"").append(",");
                Frame frame = grabber.grab();

                img = converter.convert(frame);

                BufferedImage im = new Java2DFrameConverter().convert(new OpenCVFrameConverter.ToIplImage().convert(img));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] array = null;

                try {
                    ImageIO.write(im, "jpg", baos);
                    baos.flush();
                    array = baos.toByteArray();
                } finally {
                    baos.close();
                }

                System.out.println(array);


                //the grabbed frame will be flipped, re-flip to make it right
                cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise
                System.out.println("Image with index " + i);

                ByteBuffer byteBuffer = img.asByteBuffer();

                array = new byte[] {1,2,3,4,5,6,6};

                sb.append("\"image\" : \"" + new String(array)  + "\"").append("}");

                send(sb.toString());
                //save
                cvSaveImage((i++) + "-aa.jpg", img);

                Thread.sleep(INTERVAL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void send(String json) {
       OutputStreamWriter outputStreamWriter = null;
        InputStreamReader inputStreamReader = null;
        System.out.println(json);

       try {
           outputStreamWriter = new OutputStreamWriter(urlConnection.getOutputStream());

           outputStreamWriter.write(json);
           outputStreamWriter.close();
       } catch (IOException e) {
           e.printStackTrace();
       }

       try {
           inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
           BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
           StringBuilder sb = new StringBuilder();

           String str = null;
           while((str = bufferedReader.readLine()) != null) {
               if (sb.length() == 0) {
                   sb.append(str);
               } else {
                   sb.append(str).append("\n");
               }
           }

           System.out.println(sb);
       } catch (IOException e) {
           e.printStackTrace();
       }


    }
}
