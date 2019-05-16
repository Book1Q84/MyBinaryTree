//package com.github.TianWuJun.MyBinaryTree;
//
//import java.awt.CardLayout;
//import java.awt.GridLayout;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
///**
// * 
// *用户操作界面 
// * 
// * 
// */
//public class UserInterface extends JFrame{
//	private void initFrame() {
//		this.setTitle("测试卡片式布局管理器");
//		JPanel p1=new JPanel(new GridLayout(4,3,0,0)); 
//		JPanel p2=new JPanel();
//		JPanel cards=new JPanel(new CardLayout());
//		p1.add(new JButton("登录按钮"));
//        p1.add(new JButton("注册按钮"));
//        p1.add(new JButton("找回密码按钮"));
//        p2.add(new JTextField("用户名文本框",20));
//        p2.add(new JTextField("密码文本框",20));
//        p2.add(new JTextField("验证码文本框",20));
//        cards.add(p1,"card1");    //向卡片式布局面板中添加面板1
//        cards.add(p2,"card2");    //向卡片式布局面板中添加面板2
//        CardLayout cl=(CardLayout)(cards.getLayout());
//        cl.show(cards,"card1");    //调用show()方法显示面板2
//        this.add(cards);
//        this.setBounds(300, 200, 300, 200);
//		this.setVisible(true);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//	
//	public static void main(String[] args) {
//		UserInterface ui=new UserInterface();
//		ui.initFrame();
//	}
//}
