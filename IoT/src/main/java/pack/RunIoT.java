package pack;

import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.VideoInputFrameGrabber;

import static org.bytedeco.javacpp.opencv_core.IplImage;
import static org.bytedeco.javacpp.opencv_core.cvFlip;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;


/**
 * Created by gtiwari on 1/3/2017.
 */

public class RunIoT {
    private final int INTERVAL = 5000;
    private String typeContent;
    private Integer idClient;

    public RunIoT(String typeContent, Integer idClient) {
        this.idClient = idClient;
        this.typeContent = typeContent;
    }

    public void run() {
        FrameGrabber grabber = new VideoInputFrameGrabber(0); // 1 for next camera
        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        IplImage img;
        int i = 0;
        try {
            grabber.start();
            while (true) {
                Frame frame = grabber.grab();

                img = converter.convert(frame);



                //the grabbed frame will be flipped, re-flip to make it right
                cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise
                System.out.println("Image with index " + i);
                //save
                cvSaveImage((i++) + "-aa.jpg", img);

                Thread.sleep(INTERVAL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
