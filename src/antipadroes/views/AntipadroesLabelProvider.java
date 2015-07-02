package antipadroes.views;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class AntipadroesLabelProvider extends LabelProvider implements
ITableLabelProvider{

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		Person p = (Person) element;
		String result = "";
		switch(columnIndex){
		case 0:
			result = p.getFirst();
			break;
		case 1:
			result = p.getLast();
			break;
		case 2:
			result = p.getTitle();
			break;
		case 3:
			result = p.getEmail();
			break;
		default:
			//should not reach here
			result = "";
		}
		return result;
	}


}
