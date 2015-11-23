package teste;

import java.util.List;

public class Helper_test {

public boolean assertListString(List<String> expected , List<String> real){
	if (expected.size() != real.size()){
		return false ;
	}
	for(int index =0 ; index <expected.size(); index++){
		if (expected.get(index).equals(real.get(index))==false){
			return false ;
		}
	}
  return true ;
}
public void inicializar_lista(List<String> lista , String [] conteudo){
	for(int index =0 ; index <conteudo.length; index++){
		 lista.add(conteudo[index]);
	}
}

}
