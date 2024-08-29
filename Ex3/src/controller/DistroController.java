package controller;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class DistroController {
	public DistroController() {
        super();
    }
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void exibeDistro() {
		String os = os();
		String comando = "";
		
		if(os.contains("Windows")) {
            JOptionPane.showMessageDialog(null, "O programa deve ser executado no sistema operacional Linux, programa encerrado.");
            System.exit(0);
        }  else if (os.contains("Linux")) {
            comando = "cat /etc/os-release";
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
	
}
