package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public KillController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listaProcessos() {
		String os = os();
		String comando = "";
		
		if(os.contains("Windows")) {
			comando = "TASKLIST /FO TABLE";
		} else if(os.contains("Linux")) {
			comando = "ps -ef";
		}
		String comandoArray[] = comando.split(" "); 
		
		try {
			Process prc = Runtime.getRuntime().exec(comandoArray);
			InputStream fluxo = prc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch(Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
		}
	}
	
	public void mataNome(String processo) {
		String os = os();
		String comando = "";
		
		if(os.contains("Windows")) {
			comando = "TASKKILL /IM " + processo;
		}else if(os.contains("Linux")) {
			comando = "pkill -f " + processo;
		}
		
		String comandoArray[] = comando.split(" ");
		
		try {
			Runtime.getRuntime().exec(comandoArray);
		}
		catch(Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
		}
	}
	
	
	
	public void mataPID(String processo) {
		String os = os();
		String comando = "";
		
		if(os.contains("Windows")) {
			comando = "TASKKILL /PID " + processo;
		}else if(os.contains("Linux")) {
			comando = "kill -9 " + processo;
		}
		
		String comandoArray[] = comando.split("");
		
		try {
			Runtime.getRuntime().exec(comandoArray);
		}
		catch(Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
		}
	}
	
	
}
