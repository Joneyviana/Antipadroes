package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.swt.finder.SWTBot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import antipadroes.views.DialogtableAntipadroes;

public class TestTabelaAntipadroes {

	

	private SWTBot bot;
	private Helper_test H_Test;

	@Before
	public void setUp() throws Exception {
		
	  

        Display display = new Display();
        Shell shell = new Shell(display, SWT.SHELL_TRIM);
         H_Test   =  new Helper_test()  ;
        DialogtableAntipadroes dialog = new DialogtableAntipadroes(shell);
        dialog.create();
        bot = new SWTBot(dialog.area);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
   assertEquals(4 , bot.table().columnCount() );
    List<String> lista = new ArrayList<>();
    String [] conteudo =  {"class" ,"Número de  método" , "média de parametros por método" , "apenas métodos get e set"};	
	H_Test.inicializar_lista(lista,conteudo);	
	
   assertTrue(H_Test.assertListString(lista , bot.table().columns()));
	}
	

  
}
