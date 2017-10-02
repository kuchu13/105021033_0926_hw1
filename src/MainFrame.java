import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {
    private  Button btnAdd = new Button("left");
    private  Button btnSub = new Button("right");
    private  Button btnStop = new Button("Fire");
    private  Button btnExit = new Button("Exit");
    private Label lab = new Label("FLY");
    private int n = 0,labX=185,labY=50;
    private Timer t1;
    private Timer t2;

    public MainFrame(){
        initComp();
    }
    private void initComp(){
        this.setBounds(100,120,400,300);
        this.setLayout(null);


        btnAdd.setBounds(70,200,80,30);
        this.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.setTitle(Integer.toString(++n));
//                lab.setText(Integer.toString(n));
                t1.start();
            }
        });


        btnSub.setBounds(250,200,80,30);
        this.add(btnSub);
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.setTitle(Integer.toString(--n));
//                lab.setText(Integer.toString(n));
                t2.start();
            }
        });


        btnStop.setBounds(160,200,80,30);
        this.add(btnStop);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.stop();
                t2.stop();
            }
        });


        btnExit.setBounds(150,250,80,30);
        this.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        lab.setBounds(185,50,80,30);
        this.add(lab);
//            lab.setText(Integer.toString(lab.getX())+","+Integer.toString(lab.getY()));


        t1=new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labX +=5;
                lab.setLocation(labX,labY);
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
                lab.setLocation(labX,labY);
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
