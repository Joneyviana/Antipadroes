package antipadroes.views;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GCData;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;






public class MiniCircle extends Composite implements PaintListener{




		private int x;
		private int y;
		private int height = 40;
		private int width = 20;
		private Device device;



		public MiniCircle(Composite parent, int style) {
		
			super(parent, style);
	        System.out.println("O vida triste");
		   
		}

		
		
		public void definir_ponto(int x , int y ){
			this.x = x ;
			  this.y = y ;
			
			 
			   
			  
			 
			   
			   setBounds(x, y, x+130, y+110);
			   setFocus();	  
		       setVisible(true);
		       
		   
		       this.addPaintListener(this);
		}


			
			
		public void checkSubclass(){
			
		}

		@Override
		public void paintControl(PaintEvent arg0) {
			
		    
		    System.out.println("fortalece ai po");
		    arg0.gc.setForeground(arg0.display.getSystemColor(SWT.COLOR_BLACK));
			arg0.gc.setLineAttributes(new LineAttributes(1));
		     this.setBackground(new Color(arg0.display,230,230,230 ));
			 
		     
			 
			 
		 
		}
	}