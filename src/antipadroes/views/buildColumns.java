package antipadroes.views;



import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
public class buildColumns {

public void CreateColums(String [] lista , Table tabela){
	for(int i = 0; i<lista.length; i++){
	
	TableColumn column = new TableColumn(tabela, SWT.NONE);
	
	column.setText(lista[i]);
	int x = lista[i].length()*10 ;
	if (x< 200){
		x =150 ;
	}
	column.setWidth(x);
	}
}

}
