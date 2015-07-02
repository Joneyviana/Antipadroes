package antipadroes.views;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import teste.classe;

public class AntipadroesLabelProvider extends LabelProvider implements
ITableLabelProvider{

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		classe cla = (classe) element;
		String result = "";
		switch(columnIndex){
		case 0:
			result = cla.getName();
			break;
		case 1:
			result = String.valueOf(cla.godclass());
			break;
		case 2:
			result = String.valueOf(cla.longlistParameter());
			break;
		case 3:
			result = cla.getName();
			break;
		default:
			//should not reach here
			result = "";
		}
		return result;
	}


}
