package com.view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.*;

public class AddressView extends JFrame implements ActionListener{

	JFrame f = new JFrame("С�ݰ���ĵ�ַ");
	 JButton jb1 = new JButton("��ʼת��");
	 JTextArea jta = new JTextArea();
	 Font font = new Font("΢���ź�",1,20);
	public void view(){
		
		Image img=Toolkit.getDefaultToolkit().getImage("imgs/tutu.jpg"); //���Խ���ͼƬ��URL
	    f.setIconImage(img);//���ͼƬ
        f.setSize(800, 800);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());

        JLabel l = new JLabel("������Ҫת���ĵ�ַ:\n");
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
	         // �����ı���ʾЧ��
	         UIManager.put("OptionPane.messageFont", new FontUIResource(font));
	         JOptionPane.showMessageDialog(f, "ȥjson�ļ�������");
	         System.out.println(jta.getText());
	        } 
		
	}

}
