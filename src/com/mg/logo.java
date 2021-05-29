import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class logo {
    Image im;
    JFrame jf3 = new JFrame();


    public logo() throws IOException {
        jf3.setTitle("Color Crush");
        jf3.setBounds(100, 100, 515, 520);
        jf3.setSize(1280, 800);
        jf3.setResizable(false);
        jf3.setVisible(true);
        jf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf3.setLayout(null);
        JPanel contentPane = new JPanel();
        jf3.setContentPane(contentPane);
        contentPane.setOpaque(false);
        ImageIcon img0 = new ImageIcon("src/picture/logo.png");
        JLabel imgLabel0 = new JLabel(img0);
        this.jf3.getLayeredPane().add(imgLabel0, new Integer(Integer.MIN_VALUE));
        imgLabel0.setBounds(15, 0, 1280, 800);

        ImageIcon img = new ImageIcon("src/picture/04.jpg");
        JLabel imgLabel = new JLabel(img);//将背景图放在标签里。
        this.jf3.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("1");
        }
        new newstart();
        jf3.dispose();
    }


    public static void main(String[] args) throws IOException {

        new logo();
    }
}
