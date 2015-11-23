package Controller;

import java.util.ArrayList;



import Model.EntityModel;
import Model.OperationModel;

public class operationController {

public ArrayList<Object> operations;

public operationController(ArrayList<EntityModel> entitys){
	operations = new ArrayList<>();
	for(EntityModel entity :entitys){
	   for(int index =0 ; index< entity.numerodeMetodos() ;index++){
		   OperationModel operation = entity.getMethod(index);
		   operation.Entity = entity ;
		   operations.add(operation);
	   }
	}
}


}
