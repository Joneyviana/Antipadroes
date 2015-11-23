package antipadroes.views;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.Dialog;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;


import Controller.operationController;
import Model.EntityModel;



public class DialogtableAntipadroes extends Dialog {


	
	private ArrayList<EntityModel> entity;

	public Composite area;

	private Browser browser;

	public DialogtableAntipadroes(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	protected Control createDialogArea(Composite parent) {
		
		

		
		
		
		//parent = new Composite(parent.getShell(), SWT.BORDER);
		
        
        
		area = (Composite) super.createDialogArea(parent);
		

	    browser = new Browser(area, SWT.NONE);
	    GridData layoutData = new GridData(GridData.FILL_BOTH);
	    layoutData.horizontalSpan = 2;
	    layoutData.verticalSpan = 2;
	    browser.setLayoutData(layoutData);
	    browser.setUrl("http://www.slashdot.org");
		
	    
	    TableViewer EntityView = new TableViewer(area, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL ); 
		TableViewer OperationView = new TableViewer(area, SWT.MULTI | SWT.H_SCROLL );
		final Table upTable = EntityView .getTable();
		final Table downTable = OperationView.getTable();
		
		
		
		//configurar tabela de cima 
		upTable.setHeaderVisible(true);
		//GridData table2Data = new GridData(SWT.Resize, SWT.LEFT, true, true, 1, 2);
		//upTable.setLayoutData(table2Data);
		upTable.getVerticalBar().setEnabled(true); 
		upTable.getVerticalBar().setVisible(true); 
		upTable.setLinesVisible(true);
		
		//configurar tabela de baixo
		downTable.setHeaderVisible(true);
		downTable.getVerticalBar().setEnabled(true); 
		GridData downtabledata = new GridData(SWT.Resize, SWT.LEFT, true, true, 1, 2);
		downTable.setLayoutData(downtabledata);
		downTable.getVerticalBar().setVisible(true); 
		downTable.setLinesVisible(true);
		
		//conteudo tabela de cima
		EntityView.setContentProvider(new AntipadrõesContentProvider());
		EntityView .setLabelProvider(new EntityLabelProvider());
		 
		//conteudo tabela de baixo
		OperationView.setContentProvider(new AntipadrõesContentProvider());
		OperationView.setLabelProvider(new OperationLabelProvider());
		 
		String [] entity_columns =  {"class" ,"Número de  método" , "média de parametros por método" , "apenas métodos get e set"};
		 new buildColumns().CreateColums(entity_columns, upTable);
		 
		 EntityView.setInput(entity);
		 
		
		 String [] operations_columns =  {"métodos" ,"Número de parametros" , "classe" };
		 new buildColumns().CreateColums(operations_columns, downTable);
		  
		 OperationView.setInput(new operationController(entity).operations);
		 
		 // Make selection the same in both tables
	    
		 
		 area.setVisible(true);
		return area.getShell();
		
	}

	public void setEntity(ArrayList<EntityModel> lista_de_classes) {
		entity = lista_de_classes ;
		
	}

	protected boolean isResizable() {
	    return true;
	}

}
