import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {
    private  Button btnLeft = new Button("left");
    private  Button btnRight = new Button("right");
    private  Button btnFire = new Button("Fire");
    private  Button btnStop = new Button("Stop");
    private  Button btnAuto = new Button("Automove");

    private Label lab1 = new Label("SUN");
    private Label lab2 = new Label("GUN");

    private int n = 0,labX=185,labY=50,labXx=185,labYy=150;

    private Timer t1;
    private Timer t2;

    public MainFrame(){
        initComp();
    }
    private void initComp(){
        this.setBounds(100,120,400,300);
        this.setLayout(null);
        MainFrame.this.setTitle("Game");


        btnLeft.setBounds(70,200,80,30);
        this.add(btnLeft);
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lab2.setLocation(labXx -=10,labYy);

            }
        });

        btnRight.setBounds(250,200,80,30);
        this.add(btnRight);
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lab2.setLocation(labXx +=10,labYy);
            }
        });

        btnFire.setBounds(160,200,80,30);
        this.add(btnFire);




        btnStop.setBounds(310,260,80,30);
        this.add(btnStop);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.stop();
                t2.stop();

            }
        });

        btnAuto.setBounds(10,260,80,30);
        this.add(btnAuto);
        btnAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t2.start();
            }
        });


        lab1.setBounds(185,50,80,30);
        this.add(lab1);
//            lab.setText(Integer.toString(lab.getX())+","+Integer.toString(lab.getY()));
        lab2.setBounds(185,150,80,30);
        this.add(lab2);


        t1=new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labX +=5;
                lab1.setLocation(labX,labY);
                if(labX>=370){
                    t1.stop();
                    t2.start();
                }
            }
        });
        t2=new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labX -=5;
                lab1.setLocation(labX,labY);
                if(labX<=0) {
                    t2.stop();
                    t1.start();
                }
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
