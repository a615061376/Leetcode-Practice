//package Demo02;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//
//public class GameFrame extends JFrame {
//
//    public GameFrame {
//        this.setSize(500,700);
//        this.setTitle("雷霆戰機");
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true) {
//                    repaint();
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//    }
//
//    public void paint(Graphics g) {
//        System.out.println("繪製面板");
//        BufferedImage image = (BufferedImage) this.createImage(this.getSize().width, this.getSize().height);
//        Graphics bi = image.getGraphics();
//
//        g.drawImage(image, 0,0,null);
//    }
//
//    public static void main(String[] args) {
//        GameFrame gf = new GameFrame();
//
//    }
//}
