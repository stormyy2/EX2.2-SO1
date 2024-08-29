package view;
import controller.DistroController;
import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
		DistroController metodo = new DistroController();
		JOptionPane.showMessageDialog(null, "Verificação de informações Linux.");
		metodo.exibeDistro();
	}

}
