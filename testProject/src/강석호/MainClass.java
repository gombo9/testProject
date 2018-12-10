package ����ȣ;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class MainClass extends JFrame implements ActionListener {
	ProgTest1 pt1 = new ProgTest1();
	ProgTest2 pt2 = new ProgTest2();

	JLabel j1, j2, j3, j4;
	JRadioButton r1, r2;
	JTextField jf, jf1, jf2, jf3;
	JButton jt, jt1, jt2, jt3;
	ButtonGroup rg;
	JTextArea ta;

	public MainClass() {
		super("���α׷��־��Ȱ����");

		Box cbox = Box.createHorizontalBox();

		j1 = new JLabel("ȸ��ID:");
		cbox.add(j1);
		jf1 = new JTextField(10);
		cbox.add(jf1);
		cbox.add(Box.createHorizontalStrut(10));
		j2 = new JLabel("ȸ���̸�:");
		cbox.add(j2);
		jf2 = new JTextField(10);
		cbox.add(jf2);
		cbox.add(Box.createHorizontalStrut(10));
		j3 = new JLabel("��ȭ��ȣ:");
		cbox.add(j3);
		jf3 = new JTextField(10);
		cbox.add(jf3);
		cbox.add(Box.createHorizontalStrut(10));
		j4 = new JLabel("���� :");
		cbox.add(j4);
		cbox.add(Box.createHorizontalStrut(10));
		rg = new ButtonGroup();
		rg.add(r1 = new JRadioButton("��"));
		cbox.add(r1);
		cbox.add(Box.createHorizontalStrut(30));
		rg.add(r2 = new JRadioButton("��"));
		cbox.add(r2);

		Box fbox = Box.createHorizontalBox();
		jt = new JButton("ȸ�����");
		jt.addActionListener(this);
		fbox.add(jt);
		fbox.add(Box.createHorizontalStrut(20));
		jt1 = new JButton("ȸ������");
		jt1.addActionListener(this);
		fbox.add(jt1);
		fbox.add(Box.createHorizontalStrut(20));
		jt2 = new JButton("��üȸ����ȸ");
		jt2.addActionListener(this);
		fbox.add(jt2);

		Box gbox = Box.createVerticalBox();

		gbox.add(cbox);
		gbox.add(Box.createVerticalStrut(10));
		gbox.add(fbox);

		JPanel jp = new JPanel(new FlowLayout());
		jp.setBorder(new TitledBorder(new EtchedBorder(), "ȸ�����,����,��ȸ"));
		jp.add(gbox);
		add(jp, BorderLayout.NORTH);

		Box abox = Box.createHorizontalBox();
		jt3 = new JButton("�����ܺ���");
		jt3.addActionListener(this);
		abox.add(jt3);

		JPanel jp1 = new JPanel(new FlowLayout());
		jp1.setBorder(new TitledBorder(new EtchedBorder(), "������"));
		jp1.add(abox);
		add(jp1, BorderLayout.CENTER);

		Box dbox = Box.createHorizontalBox();
		ta = new JTextArea(10, 85);
		ta.setEditable(true);
		Font font1 = new Font("���", Font.TYPE1_FONT, 10);
		ta.setFont(font1);
		dbox.add(ta);
		JPanel jp2 = new JPanel();
		jp2.setBorder(new TitledBorder(new EtchedBorder(), "���"));
		jp2.add(dbox);
		add(jp2, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jt3) {
			String str = JOptionPane.showInputDialog("����� ���� �Է��ϼ���?");
			if (str.equals(str)) {
				ta.setText(str + "�� : " + "\n" + pt1.getGugudan(Integer.parseInt(str)));
			}

		}

		if (e.getSource() == jt) {// ���

			String strGender = "";

			Enumeration<AbstractButton> enmus = rg.getElements();
			while (enmus.hasMoreElements()) {
				AbstractButton ab = enmus.nextElement();
				JRadioButton jb = (JRadioButton) ab;
				if (jb.isSelected())
					strGender = jb.getText();
			}

			int con = JOptionPane.showConfirmDialog(this, "ȸ���� ����Ͻðڽ��ϱ�?", "ȸ�����", 2);
			if (con == JOptionPane.YES_OPTION) {
				pt2.mapListAdd(jf1.getText(), jf2.getText(), jf3.getText(), strGender);
				
			}
		}
		if (e.getSource() == jt1) {
			int con2 = JOptionPane.showConfirmDialog(this, "ȸ���� �����Ͻðڽ��ϱ�?", "ȸ������", 2);
			if (con2 == JOptionPane.YES_OPTION) {
				pt2.mapListRemove(jf1.getText());

			}
		}
		if (e.getSource() == jt2) {
			ta.setText("ȸ��ID" + "\t" + "ȸ���̸�" + "\t" + "��ȭ��ȣ" + "\t" + "����" + "\n");
			for (int i = 0; i < pt2.getMapList().size(); i++) {
				ta.append(pt2.getMapList().get(i).getMemberID() + "\t" + pt2.getMapList().get(i).getName() + "\t"
						+ pt2.getMapList().get(i).getTel() + "\t" + pt2.getMapList().get(i).getGender() + "\n");
			}
		}
	}

	public static void main(String[] args) {
		MainClass iet = new MainClass();
		iet.setDefaultCloseOperation(EXIT_ON_CLOSE);
		iet.setSize(800, 400);
		iet.setVisible(true);

	}
}