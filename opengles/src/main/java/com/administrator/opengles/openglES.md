详情参考：http://www.guidebee.info/wordpress/%E6%95%99%E7%A8%8B/android-opengl-es-%E5%BC%80%E5%8F%91%E6%95%99%E7%A8%8B

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

## 3D坐标变换
gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT); //清理内存及界面
gl.glLoadIdentity(); //初始化矩阵
gl.glPushMatrix(); //Matrix进栈
gl.glRotatef(-angle, 0, 0, 1); //旋转
gl.glTranslatef(2, 0, 0); //平移
gl.glScalef(.5f, .5f, .5f); //缩放
square.draw(gl); //绘制
gl.glPopMatrix(); //Matrix出栈

## 添加颜色
OpenGL ES使用颜色是我们熟知的RGBA模式（红，绿，蓝，透明度）
0为0，1相当于255（0xFF)

## 3D模型

## 三维坐标系
Object Coordinate System: 也称作Local coordinate System，用来定义一个模型本身的坐标系。
World Coordinate System: 3d 虚拟世界中的绝对坐标系，定义好这个坐标系的原点就可以用来描述模型的实现的位置，Camera 的位置，光源的位置。
View Coordinate System: 一般使用用来计算光照效果。
Clip Coordinate System:  对3D场景使用投影变换裁剪视锥。
Normalized device coordinate System (NDC): 规范后坐标系。
Windows Coordinate System: 最后屏幕显示的2D坐标系统，一般原点定义在屏幕左上角。

## 矩阵变换指令
将当前矩阵设为单位矩阵的指令 为glLoadIdentity().
矩阵相乘的指令glMultMatrix*() 允许指定任意矩阵和当前矩阵相乘。
选择当前矩阵种类glMatrixMode().  OpenGL ES 可以运行指定GL_PROJECTION，GL_MODELVIEW等坐标系，后续的矩阵操作将针对选定的坐标。
将当前矩阵设置成任意指定矩阵glLoadMatrix*()
在栈中保存当前矩阵和从栈中恢复所存矩阵，可以使用glPushMatrix()和glPopMatrix()
特定的矩阵变换平移glTranslatef(),旋转glRotatef() 和缩放glScalef()

## 投影变换
gl.glMatrixMode(GL_PROJECTION);
gl.glLoadIdentity();
openglES 定义的函数为锥形投影：glFrustum()
android中的调用更加简单：
public static void gluPerspective(GL10 gl, float fovy, float aspect, float zNear, float zFar)
fovy: 定义视锥的view angle.
aspect:  定义视锥的宽高比。
zNear: 定义裁剪面的近距离。
zFar: 定义创建面的远距离。
正侧投影：glOrthof()

## viewport变换
glViewport(int x, int y, int width, int height)
相当于设置相框的大小，而gluPerspective相当于照片大小，不合适可能会被拉伸

## Depth Buffer
下面给出了OpenGL ES中与Depth Buffer相关的几个方法：
gl.Clear(GL10.GL_DEPTH_BUFFER_BIT) 清空Depth Buffer (赋值为1.0)通常清空Depth Buffer和Color Buffer同时进行。
gl.glClearDepthf(float depth) 指定清空Depth Buffer是使用的值，缺省为1.0，通常无需改变这个值，
gl.glEnable(GL10.GL_DEPTH_TEST) 打开depth Test
gl.glDisable(GL10.GL_DEPTH_TEST) 关闭depth Test

## 光照模型
OpenGL 光照模型中定义的光源可以分别控制，打开或关闭，OpenGL ES支持最多八个光源。
OpenGL 光照模型中最终的光照效果可以分为四个组成部分：Emitted(光源）, ambient(环境光）,diffuse(漫射光）和specular（镜面反射光），最终结果由这四种光叠加而成。
