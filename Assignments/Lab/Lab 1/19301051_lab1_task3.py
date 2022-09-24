from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *
import random

def draw_points(x, y):
    glPointSize(3) #pixel size. by default 1 thake
    glBegin(GL_POINTS)
    glVertex2f(x,y) #jekhane show korbe pixel
    glEnd()

def drawDDAdash(x1,y1,x2,y2):

  x,y = x1,y1

  length = (x2-x1) if (x2-x1) > (y2-y1) else (y2-y1)

  dx = (x2-x1)/length

  dy = (y2-y1)/length

  draw_points(round(x),round(y))
  i=0
  m=0
  while(i < length):
      if(m<10):
          x += dx
          y += dy
          m += 1
      else:
          x += dx
          y += dy
          draw_points(round(x),round(y))
          m=0
      i += 1


def drawDDA(x1,y1,x2,y2):

  x,y = x1,y1


  length = (x2-x1) if (x2-x1) > (y2-y1) else (y2-y1)

  dx = (x2-x1)/length

  dy = (y2-y1)/length

  #print ('x = %s, y = %s' % (((ROUND(x),ROUND(y)))))

  for i in range(length):

    x += dx

    y += dy

    draw_points(round(x),round(y))


def iterate():
    glViewport(0, 0, 500, 500)
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(0.0, 500, 0.0, 500, 0.0, 1.0)
    glMatrixMode (GL_MODELVIEW)
    glLoadIdentity()

def showScreen():
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glLoadIdentity()
    iterate()
    glColor3f(1.0, 1.0, 0.0) #konokichur color set (RGB)
    #call the draw methods here
    drawDDA(200,150,200,250)
    drawDDA(300, 150, 300, 250)
    drawDDAdash(200,200,300,200)
    glutSwapBuffers()



glutInit()
glutInitDisplayMode(GLUT_RGBA)
glutInitWindowSize(500, 500) #window size
glutInitWindowPosition(0, 0)
wind = glutCreateWindow(b"Task:3 Output Image") #window name
glutDisplayFunc(showScreen)

glutMainLoop()