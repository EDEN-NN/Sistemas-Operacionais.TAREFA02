package view;

import javax.swing.JOptionPane;

import controller.ProcessosController;

public class Principal {
	public static void main(String[] args) {
	ProcessosController pc = new ProcessosController();
		String os = pc.os();
		int opc = 22;
		opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Listar Processos \n"
				+ "2 - Matar por PID \n"
				+ "3 - Matar por Nome \n"
				+ "0 - Sair"));
		do {
		if(opc == 1) {  
			pc.listProcess(os);
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Listar Processos \n"
					+ "2 - Matar por PID \n"
					+ "3 - Matar por Nome \n"
					+ "0 - Sair"));
		} else if (opc == 2) { 
			pc.killID(JOptionPane.showInputDialog("Digite o ID do processo"));
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Listar Processos \n"
					+ "2 - Matar por PID \n"
					+ "3 - Matar por Nome \n"
					+ "0 - Sair"));
		} else if (opc == 3) {
			pc.killName(JOptionPane.showInputDialog("Digite o nome do processo"));	
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Listar Processos \n"
					+ "2 - Matar por PID \n"
					+ "3 - Matar por Nome \n"
					+ "0 - Sair"));
			}
		} while (opc!=0);
	}
}
