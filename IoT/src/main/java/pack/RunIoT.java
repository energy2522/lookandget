package pack;

import org.bytedeco.javacv.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.bytedeco.javacpp.opencv_core.IplImage;


/**
 * Created by gtiwari on 1/3/2017.
 */

public class RunIoT {
    private final int INTERVAL = 10000;
    private final String INFO_CLIENT;

    public RunIoT(String typeContent, Integer idClient) throws IOException {
        INFO_CLIENT = "{ \"typeOfContent\" : \"" + typeContent + "\", \"idClient\" : \"" + idClient + "\"";
    }

    public void run() throws IOException {

        FrameGrabber grabber = new VideoInputFrameGrabber(0); // 1 for next camera
        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        IplImage img;
        int i = 0;
        try {
            grabber.start();
            while (true) {
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

                //the grabbed frame will be flipped, re-flip to make it right
//                cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise

                new Thread(new Submit(array, INFO_CLIENT)).start();

                //save
//                cvSaveImage((i++) + "-aa.jpg", img);

                Thread.sleep(INTERVAL);
            }
        } catch (Exception e) {
            System.out.println("End working!");
        }
    }

}
