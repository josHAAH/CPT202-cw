import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


@SuppressWarnings("serial")
public class newstart {
    Image im;
    JFrame jf2 = new JFrame();


    public newstart() throws IOException {
        jf2.setTitle("Color Crush");
        jf2.setBounds(100, 100, 515, 520);
        jf2.setSize(1280, 800);
        jf2.setResizable(false);
        jf2.setVisible(true);
        jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf2.setLayout(null);
        JPanel contentPane = new JPanel();
        jf2.setContentPane(contentPane);
        contentPane.setOpaque(false);
        init();
    }


    public void init() {

        ImageIcon ig = new ImageIcon("src/picture/title1.png");
        im = ig.getImage();
        jf2.setIconImage(im);





        ImageIcon img1 = new ImageIcon("src/picture/title1.png");
        JLabel imgLabel1 = new JLabel(img1);
        this.jf2.getLayeredPane().add(imgLabel1, new Integer(Integer.MIN_VALUE));
        imgLabel1.setBounds(550, 250, img1.getIconWidth(), img1.getIconHeight());


        ImageIcon img2 = new ImageIcon("src/picture/Color crush.png");
        JLabel imgLabel2 = new JLabel(img2);//将背景图放在标签里。
        this.jf2.getLayeredPane().add(imgLabel2, new Integer(Integer.MIN_VALUE));
        imgLabel2.setBounds(390, 50, img2.getIconWidth(), img2.getIconHeight());


        ImageIcon img = new ImageIcon("src/picture/01.png");
        JLabel imgLabel = new JLabel(img);
        this.jf2.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());





        ImageIcon icon1 = new ImageIcon("src/picture/Log in1.png");

        jf2.setLayout(null);
        JButton startGame = new JButton();
        startGame.setEnabled(true);
        jf2.add(startGame);

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    ImageIcon icon11 = new ImageIcon("src/picture/Log in2.png");
                    startGame.setOpaque(false);
                    startGame.setContentAreaFilled(false);
                    startGame.setFocusPainted(false);
                    startGame.setIcon(icon11);
                    try {
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"http://139.196.38.67/login/");
                    } catch (IOException e) {
                        System.out.println("open error");
                    }
                jf2.dispose();
                new bpic();

            }
        });

        startGame.setBounds(300, 600, icon1.getIconWidth(), icon1.getIconHeight());

        startGame.setOpaque(false);


        startGame.setContentAreaFilled(false);


        startGame.setFocusPainted(false);


        startGame.setIcon(icon1);


        ImageIcon icon2 = new ImageIcon("src/picture/Rigister1.png");
        jf2.setLayout(null);
        JButton Rigister = new JButton();
        Rigister.setEnabled(true);
        jf2.add(Rigister);
        Rigister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                ImageIcon icon21 = new ImageIcon("src/picture/Rank2.png");
                Rigister.setOpaque(false);
                Rigister.setContentAreaFilled(false);
                Rigister.setFocusPainted(false);
                Rigister.setIcon(icon21);
                try {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"http://139.196.38.67/register/");
                } catch (IOException e) {
                   System.out.println("open error");
                }

                jf2.dispose();
                new bpic();

            }
        });

        Rigister.setBounds(700, 600, icon2.getIconWidth(), icon2.getIconHeight());

        Rigister.setOpaque(false);

        Rigister.setContentAreaFilled(false);

        Rigister.setFocusPainted(false);


        Rigister.setIcon(icon2);


    }


    public static void main(String[] args) throws IOException {
        new newstart();
    }
}



