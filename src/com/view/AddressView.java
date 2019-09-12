package com.view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.*;

public class AddressView extends JFrame implements ActionListener{

	JFrame f = new JFrame("小容帮你改地址");
	 JButton jb1 = new JButton("开始转化");
	 JTextArea jta = new JTextArea();
	 Font font = new Font("微软雅黑",1,20);
	public void view(){
		
		Image img=Toolkit.getDefaultToolkit().getImage("imgs/tutu.jpg"); //用以接收图片的URL
	    f.setIconImage(img);//获得图片
        f.setSize(800, 800);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());

        JLabel l = new JLabel("输入你要转化的地址:\n");
        l.setBounds(50, 50, 280, 30);
       
        l.setFont(font);
        
        
        jta.setPreferredSize(new Dimension(700,600));
        jta.setFont(font);
        jta.setLineWrap(true);
       
        jb1.addActionListener(this);
        
        jb1.setFont(font);
        f.add(l);
        f.add(jta);
        f.add(jb1);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if (e.getSource() == jb1) {
	         UIManager.put("OptionPane.buttonFont", new FontUIResource(font));
	         // 设置文本显示效果
	         UIManager.put("OptionPane.messageFont", new FontUIResource(font));
	         JOptionPane.showMessageDialog(f, "去json文件看看！");
	         System.out.println(jta.getText());
	        } 
		
	}

}
