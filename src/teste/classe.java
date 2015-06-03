package teste;


import java.util.HashMap;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class classe {
private String id ;
private String Name;
private  int DIT = -1;
private int NOC = -1  ;
private int CBO = -1 ;
private static HashMap<Element,classe> elementos_classe = new HashMap<>();
private Element element ;
private Elements elements; 
public Element getElement() {
	return element;
}

public classe(Element ele) {
	   element = ele ; 
	   elementos_classe.put(element, this);
		// TODO Auto-generated constructor stub
	}

public static classe getInstanceNotEqualOther(Element ele){
	if (elementos_classe.containsKey(ele)){
	    return elementos_classe.get(ele);
	}
	else   
	    return new classe(ele);
	
}
public int getmethodsCount(){
    elements = element.select("ownedOperation");
    return elements.size();
}
public String getName() {
	return element.attr("name");
}
public String getId() {
	return element.attr("xmi:id") ;
}

public method getMethod(int index){
	return new method(elements.get(index));
}

}


