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
// *�û��������� 
// * 
// * 
// */
//public class UserInterface extends JFrame{
//	private void initFrame() {
//		this.setTitle("���Կ�Ƭʽ���ֹ�����");
//		JPanel p1=new JPanel(new GridLayout(4,3,0,0)); 
//		JPanel p2=new JPanel();
//		JPanel cards=new JPanel(new CardLayout());
//		p1.add(new JButton("��¼��ť"));
//        p1.add(new JButton("ע�ᰴť"));
//        p1.add(new JButton("�һ����밴ť"));
//        p2.add(new JTextField("�û����ı���",20));
//        p2.add(new JTextField("�����ı���",20));
//        p2.add(new JTextField("��֤���ı���",20));
//        cards.add(p1,"card1");    //��Ƭʽ���������������1
//        cards.add(p2,"card2");    //��Ƭʽ���������������2
//        CardLayout cl=(CardLayout)(cards.getLayout());
//        cl.show(cards,"card1");    //����show()������ʾ���2
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
