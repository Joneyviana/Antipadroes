package Model;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

public class OperationModel {

private Element element;
private Elements elements;
public EntityModel Entity;

public OperationModel(Element ele){
	element = ele ;
}
public int getparametros(){
	elements = element.select("ownedParameter");
	return elements.size();
}

public String getName() {
	return element.attr("name");
}
public boolean isLongparameter_long_list(int media){
	
return getparametros()>media ;
}

}