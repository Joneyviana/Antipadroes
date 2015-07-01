package antipadroes.views;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class Dialogsugest extends Dialog {

	private Label facade;

	protected Dialogsugest(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		facade  = new Label(area , SWT.NONE) ;
		facade.setText("E um padrão que cria uma fachada  que simplifica o acesso ");
		return parent;
		
	}

}
