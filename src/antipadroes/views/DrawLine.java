package antipadroes.views;





import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;

import org.eclipse.swt.graphics.GCData;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.widgets.Composite;







public class DrawLine extends Composite implements PaintListener{




		private int x;
		private int y;
		private int height=5;
		private int width;
		private Device device;
		private int x_initial;
		private int x_final;



		public DrawLine(Composite parent, int style) {
		
			super(parent, style);
	       
		   
		}

		
		
		public void definir_ponto(int inicial_x , int y ,int final_x){
			x_initial = inicial_x  ; 
			x_final = final_x ;  
			this.y = y ;
			 
			 
			   
			  
			  if (x_initial > x_final){
				 width = x_initial - x_final ;  
			     x = x_final;
			  }
			  else { 
				  width = x_final - x_initial ;
			     x = x_initial;
			  }
			  
			   setSize(width, height);
			   setLocation(x, y);
			   setFocus();	  
		       setVisible(true);
		       
		   
		       this.addPaintListener(this);
		}


			
			
		public void checkSubclass(){
			
		}

		@Override
		public void paintControl(PaintEvent arg0) {
			
		    
		    
		    device = new Device() {
				
				@Override
				public long internal_new_GC(GCData arg0) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public void internal_dispose_GC(long arg0, GCData arg1) {
					// TODO Auto-generated method stub
					
				}
			};
			 
			Color  prata = new Color(device, 220, 220, 220);
			
		    arg0.gc.setForeground(prata);
		    arg0.gc.setBackground(prata);
		    arg0.gc.setLineAttributes(new LineAttributes(2));
		    arg0.gc.drawLine(0, 1, width, 1);
		    setSize(width, height);
			   setLocation(x, y);
		     
			 
			 
		 
		}
	}