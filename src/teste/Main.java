package teste;


import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File input = new File("/home/joney/Documentos/teste.uml");

		Document doc = Jsoup.parse(input , "UTF-8");
		
		Elements classes = doc.select("packagedElement[xsi:type=\"uml:Class\"]");
		int methods = (doc.select("ownedOperation").size());
		float mediamethods = methods/classes.size();
		float parametros = doc.select("ownedParameter").size()/methods;
		System.out.println("A media de métodos  por classe é "+ mediamethods );
		System.out.println("A media de parametros por função é "+parametros );
		System.out.println("O modelo tem " +classes.size() +" classes");
		for (Element classe  : classes) {
		classe cla = new classe(classe); 
		int methodsCount = cla.getmethodsCount();
		
		System.out.println("A Classe tem  "+ methodsCount +" metodos");
		for (int index = 0 ; index<methodsCount; index++) {
		 System.out.println("O metodo tem " +cla.getMethod(index).getparametros()+" parametros");
		}} 
		
		System.out.println(" Worked");
	}

}        
