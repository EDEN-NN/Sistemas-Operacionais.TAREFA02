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
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void killID(String param) {
		String si = os();
		if(si.contains("Windows")) {
			String cmdPid = "TASKKILL /PID";
			String cmdName = "TASKKILL /IM";
			int pid = 0;
			StringBuffer sb = new StringBuffer();
			
			try {
				pid = Integer.parseInt(param);
				sb.append(cmdPid);
				sb.append(" ");
				sb.append(pid);
				
				Runtime.getRuntime().exec(sb.toString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Entrada Invalida! Escolha outra opção para essa entrada.");
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
			JOptionPane.showMessageDialog(null, "Entrada invalida! Escolha outra opção para essa entrada");
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
