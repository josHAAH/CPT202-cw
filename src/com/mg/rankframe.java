import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class rankframe {
    JFrame jf1=new JFrame();
    Image im2;


    public rankframe(){
        jf1.setTitle("Rank");
        jf1.setBounds(100, 100, 515, 520);
        jf1.setSize(1280,800);
        jf1.setResizable(false);
        jf1.setVisible(true);
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf1.setLayout(null);
        JPanel contentPane=new JPanel();
        jf1.setContentPane(contentPane);
        contentPane.setOpaque(false);
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"http://139.196.38.67/");
        } catch (IOException e) {
            System.out.println("open error");
        }

        init2();
    }
    public void init2() {
        ImageIcon ig = new ImageIcon("src/picture/title1.png");
        im2 = ig.getImage();
        jf1.setIconImage(im2);

        ImageIcon imgRank = new ImageIcon("src/picture/Rank1.png");
        JLabel imgRankLabel = new JLabel(imgRank);
        this.jf1.getLayeredPane().add(imgRankLabel, new Integer(Integer.MIN_VALUE));
        imgRankLabel.setBounds(500, 40, imgRank.getIconWidth(), imgRank.getIconHeight());


        ImageIcon imgRank1 = new ImageIcon("src/picture/No1.png");
        JLabel imgRankLabel1 = new JLabel(imgRank1);
        this.jf1.getLayeredPane().add(imgRankLabel1, new Integer(Integer.MIN_VALUE));
        imgRankLabel1.setBounds(200, 180, imgRank1.getIconWidth(), imgRank1.getIconHeight());


        ImageIcon imgRank2 = new ImageIcon("src/picture/No2.png");
        JLabel imgRankLabel2 = new JLabel(imgRank2);
        this.jf1.getLayeredPane().add(imgRankLabel2, new Integer(Integer.MIN_VALUE));
        imgRankLabel2.setBounds(200, 300, imgRank2.getIconWidth(), imgRank2.getIconHeight());


        ImageIcon imgRank3 = new ImageIcon("src/picture/No3.png");
        JLabel imgRankLabel3 = new JLabel(imgRank3);
        this.jf1.getLayeredPane().add(imgRankLabel3, new Integer(Integer.MIN_VALUE));
        imgRankLabel3.setBounds(200, 420, imgRank3.getIconWidth(), imgRank3.getIconHeight());

        ImageIcon imgRank4 = new ImageIcon("src/picture/other.png");
        JLabel imgRankLabel4 = new JLabel(imgRank4);
        this.jf1.getLayeredPane().add(imgRankLabel4, new Integer(Integer.MIN_VALUE));
        imgRankLabel4.setBounds(200, 540, imgRank4.getIconWidth(), imgRank4.getIconHeight());



        ImageIcon img = new ImageIcon("src/picture/01.png");
        JLabel imgLabel = new JLabel(img);
        this.jf1.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());



        ImageIcon icon3 = new ImageIcon("src/picture/Back1.png");
        jf1.setLayout(null);
        JButton BackGame= new JButton();
        BackGame.setEnabled(true);
        jf1.add(BackGame);

        BackGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ImageIcon icon31 = new ImageIcon("src/picture/Back2.png");
                BackGame.setOpaque(false);
                BackGame.setContentAreaFilled(false);
                BackGame.setFocusPainted(false);
                BackGame.setIcon(icon31);
                new bpic();
                jf1.dispose();



            }
        });

        BackGame.setBounds(1029,680, icon3.getIconWidth(), icon3.getIconHeight());
        BackGame.setOpaque(false);
        BackGame.setContentAreaFilled(false);
        BackGame.setFocusPainted(false);
        BackGame.setIcon(icon3);
    }

}

