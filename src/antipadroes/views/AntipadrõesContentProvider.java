package antipadroes.views;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class AntipadrõesContentProvider implements IStructuredContentProvider {
	public Object[] getElements(Object inputElement) {
		ArrayList<Person>  w = (ArrayList) inputElement;
		return w.toArray();
	}
	public void dispose() {
	}
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	} 

	}
