package Model;

import java.util.HashMap;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

import Model.OperationModel;


public class EntityModel {

private static HashMap<Element,EntityModel> elementos_classe = new HashMap<>();
public static int media ;
private Element element ;
private Elements elements; 
public Element getElement() {
	return element;
}

public EntityModel(Element ele) {
	   element = ele ; 
	   elements = element.select("ownedOperation");
	   elementos_classe.put(element, this);
		// TODO Auto-generated constructor stub
	}

public static EntityModel getInstanceNotEqualOther(Element ele){
	if (elementos_classe.containsKey(ele)){
	    return elementos_classe.get(ele); 
	}
	else   
	    return new EntityModel(ele);
	
}
public int numerodeMetodos(){
   
    return elements.size();
}
public String getName() {
	return element.attr("name");
}
public String getId() {
	return element.attr("xsi:id") ;
}

public OperationModel getMethod(int index){
	return new OperationModel(elements.get(index));
}

public String isDataClass(){
	for(int x = 0 ;x<elements.size();x++){
		String metodo = getMethod(x).getName();
		if( metodo.startsWith("get")|| metodo.startsWith("set"))	{
			
		}
		else {
			return "No";
		}
			
	}
	return "Yes";
	
}
public int longlistParameter(){
    int  longlist =0; 
	for(int x = 0 ;x<elements.size();x++){
		
			longlist += getMethod(x).getparametros();
		
	 
	}
	if (numerodeMetodos()>0){
	return longlist/numerodeMetodos();
}
	else {
		return 0 ;
	}

}
}


