package antipadroes.views;
		

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;

import java.io.File;
import java.io.IOException;
import java.net.URI;
























import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.*;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GCData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import teste.classe;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;




/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class SampleView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "umlmaster2.views.SampleView";
	ListViewer viewer;
    private URI arquivo_uml ;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;
	private IWorkspaceRoot root;
    private Color color;
    private Color color1 ;
    private Device device;
	private Composite parent ;

	private StyledText container;
    /*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	private StyleRange range;
	private GridData gd;
	private Color cinza_escuro;

	 
	//class ViewContentProvider implements IStructuredContentProvider {
		//public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		//}
		//public void dispose() {
		//}
		//public Object[] getElements(Object parent) {
		//ArrayList metric = new ArrayList<Metrics>();
		//Metrics CBO = new Metrics();
		//CBO.setMetrics("CBO 3");
		//metric.add(CBO);
		//return metric;
		//}
	//}
	




	
	public void init(IViewSite site) {
        try {
			super.init(site);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(final Composite parent1) {
	          
		      parent = parent1;
		      RowLayout rowlayout = new RowLayout();
		     
		      
		      GridLayout layoutparent = new GridLayout();
		      
		      layoutparent.numColumns = 2 ;
		       
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
				
				cinza_escuro = new Color(device, 100,100,100); 
		      //final ScrolledComposite comp = new ScrolledComposite(parent, SWT.V_SCROLL|SWT.BORDER) ;
				 
				
		     // parent.setSize(1000, parent.getSize().y);
		     
		     
		     
		      
		     
		    
		      
		      
		     
        IWorkspace work = ResourcesPlugin.getWorkspace();
        IResourceChangeListener listener = new IResourceChangeListener() {
        	 

			

			private IResource resource;
			private StyleRange range1;
			private StyleRange range;
			private StyleRange corname;
			private StyleRange range2;
			private Color cinza_escuro;
			private int parametros = 0;

			public void resourceChanged(IResourceChangeEvent event) {
        	    
				root = ResourcesPlugin.getWorkspace().getRoot();
        		IResourceDelta[]  recurso  = event.getDelta().getAffectedChildren();

				
				 color = new Color(device, 80, 180, 80);
				 color1 = new Color(device, 230, 40, 40);
				 cinza_escuro = new Color(device, 100,100,100);
				 Color  prata = new Color(device, 200, 200, 200);
				 make_path(recurso);
        	
        		try {
        		File input = new File(arquivo_uml);
        		
        		Document doc = Jsoup.parse(input , "UTF-8");
				
				Elements classes = doc.select("packagedElement[xsi:type=\"uml:Class\"]");
				System.out.println("tamanho!" + classes.size());
				int methods = (doc.select("ownedOperation").size());
				int  countx = 50 ;
				int county = 20;
				float mediamethods = methods/classes.size();
				if (methods >=1){
				parametros  = doc.select("ownedParameter").size()/methods;
				}
				System.out.println("A media de métodos  por classe é "+ mediamethods );
				System.out.println("A media de parametros por função é "+parametros );
				System.out.println("O modelo tem " +classes.size() +" classes");
				for (Element classe  : classes) {
					classe cla = new classe(classe); 
					MiniCircle frescura = new MiniCircle(parent, SWT.NONE);
				    System.out.print("sdfsdfhjsdfjsdf: "+county);  
					frescura.definir_ponto(0,0, String.valueOf(cla.getmethodsCount()));
				     
					Label label = new Label(parent, SWT.NONE);
					 label.setText( cla.getName());
				      label.setForeground(prata);
				      label.setSize(20,20);
				      System.out.println("Essa é alocação: "+label.getLocation());
				      System.out.println("quero ver isso: "+label.getLayoutData());
				      label.setBackground(cinza_escuro);
				      county+= 25;
				  
				int lastchar = 0;
				} }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
					
        		  
        		parent.pack();	
					
        		
        	
        	
        		
				
			
        		
        		
        	 }

			private void  make_path(IResourceDelta[]  recurso) {
				IResourceDelta[]  recurso1  = recurso[0].getAffectedChildren();
				if (recurso1[0].getFullPath().getFileExtension().equals("uml")){
					resource = root.findMember(new Path("/"));
        		    IContainer contain = (IContainer) resource;
					IFile file = contain.getFile(new Path(recurso1[0].getFullPath().toString()));
			        arquivo_uml =  file.getLocationURI();
				   System.out.println(file.getLocationURI());
				}
				else {
				if (recurso1.length!=0){
					 make_path(recurso1);
			   }
			
				}
				}

			
                 
		
           };
           
        work.addResourceChangeListener(listener);
        parent.setLayout(layoutparent);
        //comp.setLayout(rowlayout);
        
        parent.getParent().setBackground(cinza_escuro); 
        
     
	      
	    
	    
	     
			
			
  		
	
		
	}      
        
	    
       
        
	






	

	protected void Decision_color( int valor  , String string) {
		//if (valor>=label_and_text.getvalor_referencia(string)) 
    		//setcolorRangeLine(color1 ,"\t  "+string +": "+ valor);
    	     
    		//else 
    			//setcolorRangeLine(color ,"\t  "+string +": "+ valor);
		
	}
	protected void setcolorRangeLine(Color color2, String line) {
		int lastchar = container.getCharCount();
		container.append(line);
		range = new StyleRange(lastchar, container.getCharCount()-lastchar, color2,null);
		container.setStyleRange(range);
		
	}
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		
	}
}