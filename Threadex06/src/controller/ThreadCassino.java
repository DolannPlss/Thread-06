package controller;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ThreadCassino extends Thread{
	private JTextField tfNumero1;
	private JTextField tfNumero2;
	private JTextField tfNumero3;
	private int ale;
	private int sorte;
	private String conv;
	private int op;
	private JButton btnjogar;
	private static int btnv=0;
	
	public ThreadCassino(JTextField tfNumero1, JTextField tfNumero2, JTextField tfNumero3,int op, JButton btnjogar){
		this.tfNumero1=tfNumero1;
		this.tfNumero2=tfNumero2;
		this.tfNumero3=tfNumero3;
		this.op=op;
		this.btnjogar=btnjogar;
	}
	
	public void run() {
		ale=(int) (Math.random()*(150 - 1) + 1);
		for (int i = 0; i < ale; i++) {
			sorte=(int) (Math.random()*(8 - 1) + 1);
			String conv=String.valueOf(sorte);
			if (op==0) {
				tfNumero1.setText(conv);
			} else if (op==1) {
				tfNumero2.setText(conv);
			} else if (op==2) {
				tfNumero3.setText(conv);
			}
			try {
				sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		btnv++;
		if (btnv==3) {
			btnjogar.setVisible(true);
			btnv=0;
		}
	}
}
	
