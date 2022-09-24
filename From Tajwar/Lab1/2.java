import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

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

       gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
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
       // roof - triangle
       gl.glBegin(GL2.GL_TRIANGLES);
       gl.glVertex2f(-75,0);
       gl.glVertex2f(75,0);
       gl.glVertex2f(0,100);
       gl.glEnd();
       // left wall
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(-75,0);
       gl.glVertex2f(-75,-125);
       gl.glEnd();
       // right wall
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(75,0);
       gl.glVertex2f(75,-125);
       gl.glEnd();
       // bottom floor
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(-75,-125);
       gl.glVertex2f(75,-125);
       gl.glEnd();
      
       // door
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(-20,-125);
       gl.glVertex2f(-20,-75);
       gl.glEnd();
      
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(20,-125);
       gl.glVertex2f(20,-75);
       gl.glEnd();
      
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(20,-75);
       gl.glVertex2f(-20,-75);
       gl.glEnd();
       // lock on the door
       gl.glBegin(GL2.GL_POINTS);
       gl.glVertex2f(15,-100);
       gl.glEnd();
      
       // left window
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(-65,-15);
       gl.glVertex2f(-25,-15);
       gl.glEnd();
      
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(-25,-15);
       gl.glVertex2f(-25,-45);
       gl.glEnd();
      
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(-25,-45);
       gl.glVertex2f(-65,-45);
       gl.glEnd();
      
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(-65,-45);
       gl.glVertex2f(-65,-15);
       gl.glEnd();
      
       // right window
      
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(65,-15);
       gl.glVertex2f(25,-15);
       gl.glEnd();
      
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(25,-15);
       gl.glVertex2f(25,-45);
       gl.glEnd();
      
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(25,-45);
       gl.glVertex2f(65,-45);
       gl.glEnd();
      
       gl.glBegin(GL2.GL_LINES);
       gl.glVertex2f(65,-45);
       gl.glVertex2f(65,-15);
       gl.glEnd();
      
   }

   public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
   }

   public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
   }

   public void dispose(GLAutoDrawable arg0) {

   }
}

public class 19301186_Fahim {
   public static void main(String args[]) {
//getting the capabilities object of GL2 profile
       final GLProfile profile = GLProfile.get(GLProfile.GL2);
       GLCapabilities capabilities = new GLCapabilities(profile);
// The canvas
       final GLCanvas glcanvas = new GLCanvas(capabilities);
       ThirdGLEventListener b = new ThirdGLEventListener();
       glcanvas.addGLEventListener(b);
       glcanvas.setSize(400, 400);
//creating frame
       final JFrame frame = new JFrame("task2");
//adding canvas to frame
       frame.add(glcanvas);
       frame.setSize(640, 480);
       frame.setVisible(true);
   }
}