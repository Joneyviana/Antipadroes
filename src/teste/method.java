package teste;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class method {

private Element element;
private Elements elements;

public method(Element ele){
	element = ele ;
}
public int getparametros(){
	elements = element.select("ownedParameter");
	return elements.size();
}
}
