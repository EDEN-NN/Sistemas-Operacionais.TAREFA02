package view;

import javax.swing.JOptionPane;

import controller.ProcessosController;

public class Principal {
	public static void main(String[] args) {
	ProcessosController pc = new ProcessosController();
		String os = pc.os();
		//pc.listProcess(os);
		
		String in = "";
		JOptionPane.showMessageDialog(null, "Digite o comando");
		
	    in = JOptionPane.showInputDialog(in);
	//	pc.kill(in);
		
	pc.callProcess(in);
	

		

	}
}
