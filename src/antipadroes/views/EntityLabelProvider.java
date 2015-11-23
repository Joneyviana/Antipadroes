package antipadroes.views;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import Model.EntityModel;


public class EntityLabelProvider extends LabelProvider implements
ITableLabelProvider{

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		EntityModel entity = (EntityModel) element;
		String result = "";
		switch(columnIndex){
		case 0:
			result = entity.getName();
			break;
		case 1:
			result = String.valueOf(entity.numerodeMetodos());
			break;
		case 2:
			result = String.valueOf(entity.longlistParameter());
			break;
		case 3:
			result = entity.isDataClass() ;
			break;
		default:
			//should not reach here
			result = "";
		}
		return result;
	}


}
