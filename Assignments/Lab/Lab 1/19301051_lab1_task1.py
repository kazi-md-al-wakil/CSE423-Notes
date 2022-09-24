from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *
import random

def draw_points(x, y):
    glPointSize(5) #pixel size. by default 1 thake
    glBegin(GL_POINTS)
    glVertex2f(x,y) #jekhane show korbe pixel
    glEnd()

def drawLines():
    glBegin(GL_LINES)
    glVertex2f(200, 250)
    glVertex2f(250, 250)
    glEnd()

def drawTriangle():
    glBegin(GL_TRIANGLES)
    glVertex2f(200, 250)
    glVertex2f(250, 250)
    glVertex2f(250, 300)
    glEnd()

def drawQuads():
    glBegin(GL_QUADS)
    glVertex2f(200, 250)
    glVertex2f(250, 250)
    glVertex2f(250, 300)
    glVertex2f(200, 300)
    glEnd()

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
    i = 0
    while (i<50):
        p = randomNumberGen()
        g = randomNumberGen()
        draw_points(p, g)
        i+=1
    glutSwapBuffers()

def randomNumberGen():
    n = random.randint(50,500)
    return n

glutInit()
glutInitDisplayMode(GLUT_RGBA)
glutInitWindowSize(700, 700) #window size
glutInitWindowPosition(0, 0)
wind = glutCreateWindow(b"Task:1 Output Image") #window name
glutDisplayFunc(showScreen)

glutMainLoop()