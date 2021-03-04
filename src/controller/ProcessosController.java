package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;



public class ProcessosController {
	
	private String os;
	
	public ProcessosController() {
		super();
	}
	
	public String os () {
		this.os = System.getProperty("os.name");	
		return os;
	}
	
	public void listProcess(String si) {
		if(si.contains("Windows")) {
			String com = "TASKLIST /FO TABLE";
			
			try {
				Process p = Runtime.getRuntime().exec(com);
				InputStream fluxo = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				
				while(linha!=null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				fluxo.close();
				reader.close();
				buffer.close();
				
			} catch (Exception e) {
				e.getMessage();
			}
		} else {
			String command = "ps -ef";
			try {
				Process process = Runtime.getRuntime().exec(command);
				InputStream fluxo = process.getInputStream();
				InputStreamReader ler = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(ler);
				String linha = buffer.readLine();
				
				while (linha!=null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				fluxo.close();
				ler.close();
				buffer.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void killID(String param) {
		String si = os();
		if(si.contains("Windows")) {
			String cmdPid = "TASKKILL /PID";
			int pid = 0;
			StringBuffer sb = new StringBuffer();
			
			try {
				pid = Integer.parseInt(param);
				sb.append(cmdPid);
				sb.append(" ");
				sb.append(pid);
				
				Runtime.getRuntime().exec(sb.toString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Entrada Invalida! Escolha outra op��o para essa entrada.");
			}	
		} else {
			String cmdPid = "kill -9";
			int pid = 0;
			
			StringBuffer buffer = new StringBuffer();
			try {
				pid = Integer.parseInt(param);
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pid);
				
				Runtime.getRuntime().exec(buffer.toString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Entrada Inválida! Escolha outra opção.");
			}
		}
	}
	
	public void killName(String param) {
		String si = os();
		if(si.contains("Windows")) {
		String cmdName = "TASKKILL /IM";
		StringBuffer sb = new StringBuffer();
		sb.append(cmdName);
		sb.append(" ");
		sb.append(param);
		try {
			Runtime.getRuntime().exec(sb.toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Entrada invalida! Escolha outra opcao.");
		}
		} else {
			String cmdName = "pkill -f";
			StringBuffer buffer = new StringBuffer();
			buffer.append(cmdName);
			buffer.append(" ");
			buffer.append(param);
			
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Entrada Invalida! Escolha outra opcao.");
			}
		}
		
	}
	
	public void callProcess(String process) {
		try {
			Runtime.getRuntime().exec(process);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
