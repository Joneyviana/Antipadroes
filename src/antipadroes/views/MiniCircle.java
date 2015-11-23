package antipadroes.views;



import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GCData;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;







public class MiniCircle extends Composite implements PaintListener{




		private int x;
		private int y;
		private int height = 20;
		private int width = 20;
		private Device device;
		private String str;
		private RGB rgb;



		public MiniCircle(Composite parent, int style) {
		
			super(parent, style);
	        System.out.println("O vida triste");
		   
		}

		
		
		public void definir_ponto(int x , int y , String str  , RGB rgb){
			this.x = x ;
			  this.y = y ;
			  this.str = str ;
			 
			   this.rgb = rgb ;
			  
			 
			   
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
			
		    
		    System.out.println("fortalece ai po");
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
			 
			 Color cor = new Color(device, rgb);
		    arg0.gc.setBackground(cor);
		    arg0.gc.setForeground(arg0.display.getSystemColor(SWT.COLOR_WHITE));
		    arg0.gc.fillOval(0, 0, width-5, height-5);
		    FontData fo = new FontData("helvetica", 6, SWT.BOLD); 
			
		    arg0.gc.setFont(new Font(new Device() {
	    		
	    		@Override
	    		public long internal_new_GC(GCData arg0) {
	    			
	    			return 0;
	    		}
	    		
	    		@Override
	    		public void internal_dispose_GC(long arg0, GCData arg1) {
	    			// TODO Auto-generated method stub
	    			
	    		}
	    	},fo ));
		    arg0.gc.drawText(str, 6, 2)   ;
		    setSize(width, height);
			   setLocation(x, y);
		     
			 
			 
		 
		}
	}