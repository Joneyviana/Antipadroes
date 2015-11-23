package antipadroes.views;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import Model.EntityModel;
import Model.OperationModel;

public class OperationLabelProvider  extends LabelProvider implements
ITableLabelProvider{

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		OperationModel operation = (OperationModel) element;
		String result = "";
		
		switch(columnIndex){
		case 0:
			result = operation.getName();
			break;
		case 1:
			result = String.valueOf(operation.getparametros());
			break;
		case 2:
			result = operation.Entity.getName();
			break;
		
		default:
			//should not reach here
			result = "";
		}
		return result;
	
		
	}

}
