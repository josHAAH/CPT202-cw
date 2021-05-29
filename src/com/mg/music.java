import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

/**
 *
 */

public class music {
    private static File file = null;
    private static AudioClip audioClip = null;
    public static void play(String fileUrl) {
        file = new File(fileUrl);

        try {
            audioClip = Applet.newAudioClip(file.toURI().toURL());
        } catch (MalformedURLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        audioClip.play();

    }

    public static void playloop(String fileUrl) {

        file = new File(fileUrl);

        try {
            audioClip = Applet.newAudioClip(file.toURI().toURL());
        } catch (MalformedURLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        audioClip.loop();


    }
    public static void stop() {
        audioClip.stop();
    }

}







