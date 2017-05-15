## OpenglES的helloword
1.OpenGL ES应用的起始点是从类GLSurfaceView开始，设置GLSurfaceView只需调用一个方法来设置OpenGLView用到的GLSurfaceView.Renderer.
## 3D图形基本概念
public abstract void glDrawArrays(int mode, int first, int count)   使用VetexBuffer 来绘制，顶点的顺序由vertexBuffer中的顺序指定。
public abstract void glDrawElements(int mode, int count, int type, Buffer indices)  ，可以重新定义顶点的顺序，顶点的顺序由indices Buffer 指定。
GL_POINTS 绘制独立的点。
GL_LINE_STRIP 绘制一系列线段。
GL_LINE_LOOP 类同上，但是首尾相连，构成一个封闭曲线。
GL_LINES 顶点两两连接，为多条线段构成。
GL_TRIANGLES 每隔三个顶点构成一个三角形，为多个三角形组成。
GL_TRIANGLE_STRIP 每相邻三个顶点组成一个三角形，为一系列相接三角形构成。
GL_TRIANGLE_FAN 以一个点为三角形公共顶点，组成一系列相邻的三角形。