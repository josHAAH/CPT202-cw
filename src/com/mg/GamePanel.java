import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashSet;
import javax.swing.*;
import javax.sound.sampled.*;


public class GamePanel extends JPanel {
    private static final long serialVersionUID = 2L;
    private static final int sx = 400;
    private static final int sy = 200;
    private static final int w = 80;
    private static final int rw = 480;

    private int pj = 0, pi = 0;
    private int cc = 0;
    private int[][] map;
    private boolean isEnd = false;
    private JButton[][] btnMap;
    private int score=0;
    private int combo;
    private JButton restart;
    private Timer timer;
    private JButton mus;
    private int timestamp;
    private int time;
    public int color=3;
    public int voice=1;
    private static Clip bgm;
    private static Clip hit;
    private static AudioInputStream ais;


    public GamePanel() {

        setLayout(null);
    }


    public void start() {

        if (color==3){score=0;}
        map = MapTool.createMap(color);
        btnMap = new JButton[6][6];


        time = 0;
        timestamp = 60;
        isEnd = false;
        mus();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                JButton btn = new JButton(map[i][j] + "");
                btn.setBounds(sx + (j * w) + 2, sy + (i * w) + 2, w - 2, w - 2);
                btn.setForeground(Color.RED);
                btn.setFont(new Font("Arial", 0, 0));
                if(map[i][j]==1)btn.setBackground(new Color(255,240,245));
                else if (map[i][j]==2)btn.setBackground(new Color(240,255,240));
                else if (map[i][j]==3)btn.setBackground(new Color(187,255,255));
                else if (map[i][j]==4)btn.setBackground(new Color(193, 255 ,193));
                else if (map[i][j]==5)btn.setBackground(new Color(250,128,114));
                btn.setBorder(BorderFactory.createRaisedBevelBorder());
                btn.setFocusPainted(false);
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (isEnd) {
                            return;
                        }
                        for (int i = 0; i < btnMap.length; i++) {
                            for (int j = 0; j < btnMap[i].length; j++) {
                                if (e.getSource().equals(btnMap[i][j])) {

                                    cc++;
                                    compare(j, i);
                                }
                            }
                        }

                    }
                });
                btnMap[i][j]=btn;
                this.add(btn);
            }
        }
        if (restart != null) {
            restart.setVisible(false);
            this.remove(restart);
            restart = null;
        }
        repaint();


        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timestamp>=1) {
                    time++;
                    timestamp = 60 - time;
                    repaint();
                }else{
                    timestamp=0;
                }
            }
        });
        timer.start();
    }

    /**
     * Determine if the game is over
     * 1. Decide whether all elements in the two-dimensional array map are 0. If all elements are 0, return true, indicating that the game is over
     * 2. If any is not 0, judge whether there is any duplicate value in the two-dimensional array map. If no duplicate value returns true, the game is over
     * Otherwise return false to continue the game
     *
     * @param map A two-dimensional array of elements of type int
     * @return
     */
    public boolean isEnd(int[][] map) {
        int count_0 = 0;
        int count = 0;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int[] ms : map) {
            for (int m : ms) {
                count++;
                if (m != 0) {
                    hashSet.add(m);
                } else {
                    count_0++;
                }
            }
        }

        for (int[] ms : map) {
            if(timestamp<=0){
                return true;
            }
            for (int m : ms) {
                if (m != 0) {
                    if (hashSet.size() + count_0 == count) {
                        return true;
                    }
                    return false;
                }

            }
        }

        return true;
    }

    /**
     *
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {

            int min = timestamp / 60;

            int sec = timestamp % 60;

            if (isEnd) {

                g.setColor(Color.RED);
                g.setFont(new Font("微软雅黑", 0, 62));
                g.drawString("Game Over", 510, 200);
                g.setFont(new Font("微软雅黑", 0, 50));
                score=score+timestamp;
                g.drawString("Score：" + (score), 510, 280);
                g.drawString("Time：" + String.format("%02d", min) + ":" + String.format("%02d", 60-sec), 510, 350);
            } else {

                g.setFont(new Font("微软雅黑", Font.BOLD, 40));
                g.setColor(Color.BLACK);
                g.fillRect(400, 23, 120, 40);
                g.fillRect(880, 23, 100, 40);
                g.setColor(Color.RED);
                g.drawString("Time：", 280, 55);
                g.drawString(String.format("%02d", min) + ":" + String.format("%02d", sec), 405, 57);
                g.drawString("Score：", 750, 57);
                g.drawString(String.format("%03d", score) + "", 888, 57);
                g.setFont(new Font("微软雅黑", Font.BOLD, 40));
                g.drawString("Combo x"+combo, 100, 400);
                if(combo==0&&score!=0){
                    g.drawString("Combo failed " ,915,380);
                    g.drawString( "(╥╯^╰╥)",915,420);
                    g.drawString("Come on " ,915,460);
                }
                g.setFont(new Font("微软雅黑", Font.BOLD, 50));
                g.setColor(Color.RED);
                g.drawRect(sx, sy, rw, rw);
                for (int i = 1; i < 6; i++) {
                    g.drawLine(sx + (i * w), sy, sx + (i * w), sy + rw);

                    g.drawLine(sx, sy + (i * w), sx + rw, sy + (i * w));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param i
     * @param j
     */
    private void drawButton(int i, int j) {
        if (map[i][j] != 0) {
            btnMap[i][j].setVisible(true);
        } else {
            btnMap[i][j].setVisible(false);
        }
    }

    private  void mus(){
        mus = new JButton();
        ImageIcon icon = new ImageIcon("src/picture/on.png");
        ImageIcon icon1 = new ImageIcon("src/picture/on2.png");
        mus.setEnabled(true);
        mus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(voice==0) {
                    voice = 1;
                    mus.setIcon(icon);
                }else{
                    voice = 0;
                    mus.setIcon(icon1);

                }
            }
        });
        mus.setBounds(1000, 100, icon.getIconWidth(), icon.getIconHeight());
        this.add(mus);
        mus.setOpaque(false);
        mus.setContentAreaFilled(false);
        mus.setFocusPainted(false);
        mus.setBorderPainted(false);
        mus.setIcon(icon);
        repaint();
    }
    /**
     *
     * @param cj
     * @param ci
     */



    private void compare(int cj, int ci) {
        /**
         *
         */

        if (cc == 1) {
            pj = cj;
            pi = ci;
            printMap(ci, cj);
            drawButton(ci, cj);
            if(voice==1) {
                Thread t3 = new Thread(new Runnable() {
                    public void run() {
                        music.play("src/music/选择(select）_01.wav");
                    }

                });
                t3.start();
            }
            isEnd = isEnd(map);
            if (isEnd) {
                combo=0;
                timer.stop();
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        if (map[i][j] != 0) {
                            btnMap[i][j].setVisible(false);
                        }
                    }
                }
                restart = new JButton("restart");
                score=0;
                restart.setBackground(Color.WHITE);
                restart.setBounds(560, 530, 120, 40);
                restart.setBorder(BorderFactory.createRaisedBevelBorder());
                restart.setFocusPainted(false);
                restart.setForeground(Color.RED);
                restart.setFont(new Font("微软雅黑", 0, 20));
                restart.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        start();
                    }
                });
                this.add(restart);
                repaint();
            }

        } else {
            printMap(ci, cj);
            map = MapTool.removed(map, pi, pj, ci, cj);

            drawButton(pi, pj);
            cc = 0;
            if (map[pi][pj] == map[ci][cj]&& (pj != cj || pi != ci)) {
                score += 1;
                btnMap[ci][cj].setBackground(Color.WHITE);
                drawButton(ci, cj);
                btnMap[pi][pj].setBackground(Color.WHITE);
                if(voice==1) {
                    Thread t1 = new Thread(new Runnable() {
                        public void run() {
                            music.play("src/music/消除_01.wav");
                        }

                    });
                    t1.start();
                }
                combo++;

                //music.stop();

            }else{
                if(voice==1) {
                    Thread t2 = new Thread(new Runnable() {
                        public void run() {
                            music.play("src/music/错误.wav");
                        }

                    });
                    t2.start();
                }
                combo=0;
            }
            isEnd = isEnd(map);
            if (isEnd) {
                timer.stop();
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        if (map[i][j] != 0) {
                            btnMap[i][j].setVisible(false);
                        }
                    }
                }
                if (color<5){
                    restart = new JButton("next level");
                    color++;
                }
                else{
                    restart = new JButton("restart");
                    color=3;
                }
                restart.setBackground(Color.WHITE);
                restart.setBounds(560, 530, 144, 48);
                restart.setBorder(BorderFactory.createRaisedBevelBorder());
                restart.setFocusPainted(false);
                restart.setForeground(Color.RED);
                restart.setFont(new Font("微软雅黑", 0, 20));
                restart.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            start();

                    }
                });
                this.add(restart);
                repaint();

            }
        }

        repaint();
    }

    /**
     *
     *
     * @param ci
     * @param cj
     */
    private void printMap(int ci, int cj) {
        if (ci == pi && cj == pj) {
            System.out.println("ci:" + ci + ", cj:" + cj);
        } else {
            System.out.println("ci:" + ci + ", cj:" + cj + ", pi:" + pi + ", pj:" + pj);
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (ci == pi && cj == pj) {
                    System.out.print(((ci == i && cj == j) ? "[" + map[i][j] + "]" : " " + map[i][j] + " ") + "  ");
                } else {
                    System.out.print(
                            ((ci == i && cj == j || pi == i && pj == j) ? "[" + map[i][j] + "]" : " " + map[i][j] + " ")
                                    + "  ");
                }
            }
            System.out.println();
        }
    }




}