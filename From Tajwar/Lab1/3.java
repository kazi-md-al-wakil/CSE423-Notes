import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.lang.Math;
import java.util.Random;
import javax.swing.JFrame;

class ThirdGLEventListener implements GLEventListener {
/**
 * Interface to the GLU library.
 */
private GLU glu;

/**
 * Take care of initialization here.
 */
public void init(GLAutoDrawable gld) {
    GL2 gl = gld.getGL().getGL2();
    glu = new GLU();

    gl.glClearColor(10.0f, 10.0f, 0.0f, 1.0f);
    gl.glViewport(-250, -150, 250, 150);
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();
    glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
}

/**
 * Take care of drawing here.
 */
public void display(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2();

    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    /*
     * put your code here
     */
    
    
    gl.glPointSize(10.0f);
    gl.glColor3d(0.1f, 0.0f, 0.1f);
    
DDA(gl,-50,30,50,30) ;
DDA(gl,0,-50,0,30) ;   

}

  public static void DDA(GL2 gl,float x1,float y1,float x2,float y2){
   gl.glPointSize(2.0f);
   gl.glColor3d(0, 0, 1); 
   gl.glBegin(GL2.GL_POINTS);
      
  float x=x1;float y=y1;
  float m=(y2-y1)/(x2-x1);
  if(m<=-1||m>=1){
      
      
      
  for(float j=y;j<=y2;j++){
     float i=x;
      int x3 = Math.round(i);
      int y3 = Math.round(j);     
  gl.glVertex2d(x3,y3);
  
  i=i+(1/m);
  
    }
      
      
  
    }
  else{
      
      
        for(float i=x;i<=x2;i++){
            float j=y;
      int x3 = Math.round(i);
      int y3 = Math.round(j);     
  gl.glVertex2d(x3,y3);
  
  j=j+m;
    }
 
  }
  gl.glEnd();
  }

public void reshape(GLAutoDrawable drawable, int x, int y, int width,
        int height) {
}

public void displayChanged(GLAutoDrawable drawable,
        boolean modeChanged, boolean deviceChanged) {
}

public void dispose(GLAutoDrawable arg0)
{
 
}
}
public class 19301186_Fahim
       
{
public static void main(String args[])
{
 //getting the capabilities object of GL2 profile
 final GLProfile profile=GLProfile.get(GLProfile.GL2);
 GLCapabilities capabilities=new GLCapabilities(profile);
 // The canvas
 final GLCanvas glcanvas=new GLCanvas(capabilities);
 ThirdGLEventListener b=new ThirdGLEventListener();
 glcanvas.addGLEventListener(b);
 glcanvas.setSize(800,800);
 //creating frame
 final JFrame frame=new JFrame("Task3");
 //adding canvas to frame
 frame.add(glcanvas);
 frame.setSize(1000,1000);
 frame.setVisible(true);
}
}

