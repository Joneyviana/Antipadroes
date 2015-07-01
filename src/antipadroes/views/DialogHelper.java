package antipadroes.views;

import org.eclipse.jface.dialogs.Dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class DialogHelper extends Dialog {

	private Label label;

	protected DialogHelper(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	  protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		label = new Label(area , SWT.NONE);
		 label.setText("Abaixo é mostrado a simple estrutura que exibe a quantidade de métodos da classe, \n e  a quantidade de de parametro desses métodos \n\n classe (qtde de methods) ......\n\t method (Qtdo de parametros)...........\n.\n.\n.\n.\n.");
		
		return area;
		
	}


}
