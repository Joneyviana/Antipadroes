package antipadroes.views;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import teste.classe;

public class Dialogsugest extends Dialog {

	private Label facade;
	private ArrayList<Person> persons;
	private ArrayList<classe> model;

	protected Dialogsugest(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	protected Control createDialogArea(Composite parent) {
		
		int rowCount = 3;
		int columnCount = 3;

		
		
		
		//parent = new Composite(parent.getShell(), SWT.BORDER);
		persons = new ArrayList<>();
        Person person  = new Person();
        persons.add(person);
		Composite area = (Composite) super.createDialogArea(parent);
		
		TableViewer tableViewer = new TableViewer(area, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION); 
		
		final Table rightTable = tableViewer.getTable();
		rightTable.setHeaderVisible(true);
		GridData table2Data = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
		rightTable.setLayoutData(table2Data);
		 rightTable.setLinesVisible(true);
         tableViewer.setContentProvider(new AntipadrõesContentProvider());
		 tableViewer.setLabelProvider(new AntipadroesLabelProvider());
		 for (int i = 0; i < columnCount; i++) {
				TableColumn column = new TableColumn(rightTable, SWT.NONE);
				
				column.setText("Value "+i);
				column.setWidth(200);
			}
		 
		 tableViewer.setInput(model);
		
		
		// Create rows
		
		// Make selection the same in both tables
	
		return area;
		
	}

	public void setmodel(ArrayList<classe> lista_de_classes) {
		model = lista_de_classes ;
		
	}

}
