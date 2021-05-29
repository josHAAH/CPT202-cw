import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    GamePanel panel;
    Image im;

    /**
     * GameFrame
     */


    public GameFrame() {
        setTitle("Color Cursh");
        setBounds(100, 100, 515, 520);
        setSize(1280, 800);
        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        panel = new GamePanel();
        setContentPane(panel);
        panel.setOpaque(false);
        setVisible(true);
        init("01.png");


    }

    public void init(String path) {

        /*
         * Set window icon
         */
        ImageIcon ig = new ImageIcon("src/picture/title1.png");
        im = ig.getImage();
        setIconImage(im);


        ImageIcon imgf = new ImageIcon("src/picture/+031.png");
        JLabel imgLabelf = new JLabel(imgf);
        this.getLayeredPane().add(imgLabelf, new Integer(Integer.MIN_VALUE));
        imgLabelf.setBounds(1000, 550, imgf.getIconWidth(), imgf.getIconHeight());

        imgLabelf.setVisible(false);

        ImageIcon imgh = new ImageIcon("src/picture/+041.png");
        JLabel imgLabelh = new JLabel(imgh);//将背景图放在标签里。
        this.getLayeredPane().add(imgLabelh, new Integer(Integer.MIN_VALUE));
        imgLabelh.setBounds(1100, 560, imgh.getIconWidth(), imgh.getIconHeight());

        imgLabelh.setVisible(false);

        ImageIcon imgg = new ImageIcon("src/picture/+021.png");
        JLabel imgLabelg = new JLabel(imgg);//将背景图放在标签里。
        this.getLayeredPane().add(imgLabelg, new Integer(Integer.MIN_VALUE));
        imgLabelg.setBounds(50,500, imgg.getIconWidth(), imgg.getIconHeight());
        imgLabelg.setVisible(false);

        ImageIcon imgi = new ImageIcon("src/picture/+011.png");
        JLabel imgLabeli = new JLabel(imgi);
        this.getLayeredPane().add(imgLabeli, new Integer(Integer.MIN_VALUE));
        imgLabeli.setBounds(1000,30, imgi.getIconWidth(), imgg.getIconHeight());
        imgLabeli.setVisible(false);

        ImageIcon imgj = new ImageIcon("src/picture/+05.png");
        JLabel imgLabelj = new JLabel(imgj);//将背景图放在标签里。
        this.getLayeredPane().add(imgLabelj, new Integer(Integer.MIN_VALUE));
        imgLabelj.setBounds(500,20, imgg.getIconWidth(), imgg.getIconHeight());
        imgLabelj.setVisible(false);

        ImageIcon img = new ImageIcon("src/picture/"+path);
        JLabel imgLabel = new JLabel(img);//将背景图放在标签里。
        this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());




        ImageIcon icon3 = new ImageIcon("src/picture/Back1.png");
        setLayout(null);
        JButton BackGame= new JButton();
        BackGame.setEnabled(true);
        add(BackGame);

        BackGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ImageIcon icon31 = new ImageIcon("src/picture/Back2.png");
                BackGame.setOpaque(false);
                BackGame.setContentAreaFilled(false);
                BackGame.setFocusPainted(false);
                BackGame.setIcon(icon31);
                new bpic();
                dispose();




            }
        });

        BackGame.setBounds(1029,680, icon3.getIconWidth(), icon3.getIconHeight());
        BackGame.setOpaque(false);
        BackGame.setContentAreaFilled(false);
        BackGame.setFocusPainted(false);
        BackGame.setIcon(icon3);


        Thread t = new Thread(new Runnable(){
            public void run(){
                while(panel.color==3){
                    System.out.println("");
                }
                imgLabelf.setVisible(true);
                imgLabelh.setVisible(true);
                while(panel.color==4){
                    System.out.println("");
                }
                imgLabelf.setVisible(false);
                imgLabelh.setVisible(false);
                imgLabelg.setVisible(true);
                imgLabeli.setVisible(true);
                while(panel.color==5){
                    System.out.println("");
                }
                imgLabelg.setVisible(false);
                imgLabeli.setVisible(false);
                run();

            }
        });
        t.start();


    }

    /**
     * Start game
     */
    public void start() {
        panel.start();

    }
}