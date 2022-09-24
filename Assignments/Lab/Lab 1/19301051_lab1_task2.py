from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *
import random

def draw_points(x, y):
    glPointSize(3) #pixel size. by default 1 thake
    glBegin(GL_POINTS)
    glVertex2f(x,y) #jekhane show korbe pixel
    glEnd()

def drawLines(x1,y1,x2,y2):
    glBegin(GL_LINES)
    glVertex2f(x1, y1)
    glVertex2f(x2, y2)
    glEnd()

def drawTriangle(x1,x2,x3):
    glBegin(GL_TRIANGLES)
    glVertex2f(x1, x2)
    glVertex2f(x2, x2)
    glVertex2f(x2, x3)
    glEnd()

def drawQuads(x1,x2, x3):
    glBegin(GL_QUADS)
    glVertex2f(x1, x2)
    glVertex2f(x2, x2)
    glVertex2f(x2, x3)
    glVertex2f(x1, x3)
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

    #upper part of house
    drawTriangle(200, 250, 300)
    drawTriangle(300, 250, 300)

    #structure of house
    drawLines(200,250,200,150)
    drawLines(300, 250,300,150)
    drawLines(200, 150, 300, 150)

    #door
    drawLines(235,200,265,200)
    drawLines(235,200,235,150)
    drawLines(265,200,265,150)

    # Window 1
    drawLines(210,235,230,235)
    drawLines(210,215,230,215)
    drawLines(210, 235, 210, 215)
    drawLines(230, 235, 230, 215)

    # Window 2
    drawLines(270, 235, 290, 235)
    drawLines(270, 215, 290, 215)
    drawLines(270, 235, 270, 215)
    drawLines(290, 235, 290, 215)

    #Door Nob
    draw_points(260,180)


    #Window Style
    draw_points(215,230)
    draw_points(225,220)
    draw_points(275, 220)
    draw_points(285, 230)

    #bottom of the house
    drawLines(193, 149, 307, 149)
    drawLines(193, 147, 307, 147)
    drawLines(193, 145, 307, 145)
    drawLines(193, 143, 307, 143)

    glutSwapBuffers()


glutInit()
glutInitDisplayMode(GLUT_RGBA)
glutInitWindowSize(500, 500) #window size
glutInitWindowPosition(0, 0)
wind = glutCreateWindow(b"Task:2 Output Image") #window name
glutDisplayFunc(showScreen)

glutMainLoop()