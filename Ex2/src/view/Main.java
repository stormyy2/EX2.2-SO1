package view;
import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController metodo = new KillController();
		int opc = 0;
		String processo = "";
		
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1- Listar processos ativos \n 2- Matar processo por nome \n 3- Matar processo por PID \n 9- Encerrar programa"));
			switch(opc) {
			case 1:
				metodo.listaProcessos();
				break;
			case 2:
				processo = JOptionPane.showInputDialog("Digite o nome do processo: ");
				metodo.mataNome(processo);
				break;
			case 3:
				processo = JOptionPane.showInputDialog("Digite o PID do processo: ");
				metodo.mataPID(processo);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Programa encerrado.");
				break;
			}
		}
	}

}
