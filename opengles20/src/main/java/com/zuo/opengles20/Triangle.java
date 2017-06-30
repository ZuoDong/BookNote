package com.zuo.opengles20;

import android.content.Context;
import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * 作者：zuo
 * 时间：2017/6/28:13:31
 */

public class Triangle {

    private static final int POSITION_COMPONENT_COUNT = 3;
    private Context context;

    public static final int BYTES_PER_FLOAT = 4;

    public static final String A_POSITION = "a_Position";
    public static final String U_COLOR = "u_Color";



    private FloatBuffer vertexBuffer;

    static float[] vertexsCooder = {-0.5f,-0.5f,0.5f,-0.5f,0f,0.5f};
    private int program;
    private final int colorLocation;
    private final int positionLocation;

    public Triangle(Context context) {
        this.context = context;

        vertexBuffer  = ByteBuffer.allocateDirect(vertexsCooder.length * BYTES_PER_FLOAT)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vertexBuffer.put(vertexsCooder);
        vertexBuffer.position(0);
        getProgram();

        colorLocation = GLES20.glGetUniformLocation(program, U_COLOR);
        positionLocation = GLES20.glGetAttribLocation(program, A_POSITION);

        GLES20.glVertexAttribPointer(positionLocation,2,GLES20.GL_FLOAT,false,0,vertexBuffer);
        GLES20.glEnableVertexAttribArray(positionLocation);
    }

    private void getProgram() {
        String vertexShaderSource = TextResourceReader.readTextFileFromResource(context, R.raw.simple_vertex_shader);
        String fragmentShaderSource = TextResourceReader.readTextFileFromResource(context, R.raw.simple_fragment_shader);
        program = ShaderHelper.buildProgram(vertexShaderSource, fragmentShaderSource);
        GLES20.glUseProgram(program);
    }

    public void draw(){
        GLES20.glUniform4f(colorLocation,0f,0f,1.0f,1.0f);
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, POSITION_COMPONENT_COUNT);
    }
}
