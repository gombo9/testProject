package 강석호;

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
		super("프로그래밍언어활용평가");

		Box cbox = Box.createHorizontalBox();

		j1 = new JLabel("회원ID:");
		cbox.add(j1);
		jf1 = new JTextField(10);
		cbox.add(jf1);
		cbox.add(Box.createHorizontalStrut(10));
		j2 = new JLabel("회원이름:");
		cbox.add(j2);
		jf2 = new JTextField(10);
		cbox.add(jf2);
		cbox.add(Box.createHorizontalStrut(10));
		j3 = new JLabel("전화번호:");
		cbox.add(j3);
		jf3 = new JTextField(10);
		cbox.add(jf3);
		cbox.add(Box.createHorizontalStrut(10));
		j4 = new JLabel("성별 :");
		cbox.add(j4);
		cbox.add(Box.createHorizontalStrut(10));
		rg = new ButtonGroup();
		rg.add(r1 = new JRadioButton("남"));
		cbox.add(r1);
		cbox.add(Box.createHorizontalStrut(30));
		rg.add(r2 = new JRadioButton("여"));
		cbox.add(r2);

		Box fbox = Box.createHorizontalBox();
		jt = new JButton("회원등록");
		jt.addActionListener(this);
		fbox.add(jt);
		fbox.add(Box.createHorizontalStrut(20));
		jt1 = new JButton("회원삭제");
		jt1.addActionListener(this);
		fbox.add(jt1);
		fbox.add(Box.createHorizontalStrut(20));
		jt2 = new JButton("전체회원조회");
		jt2.addActionListener(this);
		fbox.add(jt2);

		Box gbox = Box.createVerticalBox();

		gbox.add(cbox);
		gbox.add(Box.createVerticalStrut(10));
		gbox.add(fbox);

		JPanel jp = new JPanel(new FlowLayout());
		jp.setBorder(new TitledBorder(new EtchedBorder(), "회원등록,삭제,조회"));
		jp.add(gbox);
		add(jp, BorderLayout.NORTH);

		Box abox = Box.createHorizontalBox();
		jt3 = new JButton("구구단보기");
		jt3.addActionListener(this);
		abox.add(jt3);

		JPanel jp1 = new JPanel(new FlowLayout());
		jp1.setBorder(new TitledBorder(new EtchedBorder(), "구구단"));
		jp1.add(abox);
		add(jp1, BorderLayout.CENTER);

		Box dbox = Box.createHorizontalBox();
		ta = new JTextArea(10, 85);
		ta.setEditable(true);
		Font font1 = new Font("고딕", Font.TYPE1_FONT, 10);
		ta.setFont(font1);
		dbox.add(ta);
		JPanel jp2 = new JPanel();
		jp2.setBorder(new TitledBorder(new EtchedBorder(), "결과"));
		jp2.add(dbox);
		add(jp2, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jt3) {
			String str = JOptionPane.showInputDialog("출력할 단을 입력하세요?");
			if (str.equals(str)) {
				ta.setText(str + "단 : " + "\n" + pt1.getGugudan(Integer.parseInt(str)));
			}

		}

		if (e.getSource() == jt) {// 등록

			String strGender = "";

			Enumeration<AbstractButton> enmus = rg.getElements();
			while (enmus.hasMoreElements()) {
				AbstractButton ab = enmus.nextElement();
				JRadioButton jb = (JRadioButton) ab;
				if (jb.isSelected())
					strGender = jb.getText();
			}

			int con = JOptionPane.showConfirmDialog(this, "회원을 등록하시겠습니까?", "회원등록", 2);
			if (con == JOptionPane.YES_OPTION) {
				pt2.mapListAdd(jf1.getText(), jf2.getText(), jf3.getText(), strGender);
				
			}
		}
		if (e.getSource() == jt1) {
			int con2 = JOptionPane.showConfirmDialog(this, "회원을 삭제하시겠습니까?", "회원삭제", 2);
			if (con2 == JOptionPane.YES_OPTION) {
				pt2.mapListRemove(jf1.getText());

			}
		}
		if (e.getSource() == jt2) {
			ta.setText("회원ID" + "\t" + "회원이름" + "\t" + "전화번호" + "\t" + "성별" + "\n");
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