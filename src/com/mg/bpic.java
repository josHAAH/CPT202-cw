import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class bpic {
    Image im;
    JFrame jf=new JFrame();




    public bpic() {
        jf.setTitle("Color Crush");
        jf.setBounds(100, 100, 515, 520);//Sets where the window appears
        jf.setSize(1280,800);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        JPanel contentPane=new JPanel();
        jf.setContentPane(contentPane);
        contentPane.setOpaque(false);//Set the panel background to transparent
        init();
    }




    public void init() {

        /*
         * Set window icon
         */
        ImageIcon ig = new ImageIcon("src/picture/title1.png");
        im = ig.getImage();
        jf.setIconImage(im);

        /*
         * Sets the window background image

         */
        ImageIcon img1 = new ImageIcon("src/picture/title1.png");
        JLabel imgLabel1 = new JLabel(img1);
        this.jf.getLayeredPane().add(imgLabel1, new Integer(Integer.MIN_VALUE));
        imgLabel1.setBounds(550, 250, img1.getIconWidth(), img1.getIconHeight());


        ImageIcon img2 = new ImageIcon("src/picture/Color crush.png");
        JLabel imgLabel2 = new JLabel(img2);
        this.jf.getLayeredPane().add(imgLabel2, new Integer(Integer.MIN_VALUE));
        imgLabel2.setBounds(390, 50, img2.getIconWidth(), img2.getIconHeight());



        ImageIcon img = new ImageIcon("src/picture/01.png");
        JLabel imgLabel = new JLabel(img);
        this.jf.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());



        /*
         *Set button
         */
        ImageIcon icon1 = new ImageIcon("src/picture/012.png");

        jf.setLayout(null);
        JButton startGame= new JButton();
        startGame.setEnabled(true);
        jf.add(startGame);

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                    ImageIcon icon11 = new ImageIcon("src/picture/Log in2.png");
                    startGame.setOpaque(false);
                    startGame.setContentAreaFilled(false);
                    startGame.setFocusPainted(false);
                    startGame.setIcon(icon11);

                new GameFrame().start();
                jf.dispose();

            }
        });


        startGame.setBounds(300,600, icon1.getIconWidth(), icon1.getIconHeight());

        startGame.setOpaque(false);


        startGame.setContentAreaFilled(false);


        startGame.setFocusPainted(false);


        startGame.setIcon(icon1);


        ImageIcon icon2 = new ImageIcon("src/picture/Rank1.png");
        jf.setLayout(null);
        JButton rank= new JButton();
        rank.setEnabled(true);
        jf.add(rank);
        rank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ImageIcon icon21 = new ImageIcon("src/picture/Rank2.png");
                rank.setOpaque(false);
                rank.setContentAreaFilled(false);
                rank.setFocusPainted(false);
                rank.setIcon(icon21);
                new rankframe();
                jf.dispose();
            }
        });

        rank.setBounds(700,600, icon2.getIconWidth(), icon2.getIconHeight());

        rank.setOpaque(false);


        rank.setContentAreaFilled(false);


        rank.setFocusPainted(false);



        rank.setIcon(icon2);








    }


    public static void main(String[] args) {

        new bpic();
    }

}
