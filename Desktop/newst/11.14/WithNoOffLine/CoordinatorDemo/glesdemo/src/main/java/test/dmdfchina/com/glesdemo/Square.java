package test.dmdfchina.com.glesdemo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * Created by mkt on 2018/1/23.
 */

public class Square {
    private FloatBuffer floatBuffer;
    private ShortBuffer shortBuffer;

    /*定义画矩形的四个顶点*/
    static final int COORDS_PER_VERTEX = 3;
    static float squareCoords[]={
            -0.5f,0.5f,0.0f,
            -0.5f,-0.5f,0.0f,
            0.5f,-0.5f,0.0f,
            0.5f,0.5f,0.0f
    };

    /*定义画正方形顶点的顺序*/
    private short drawOrder[]={0,1,2,0,2,3};

    public Square(){
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(squareCoords.length*4);
        byteBuffer.order(ByteOrder.nativeOrder());
        floatBuffer=byteBuffer.asFloatBuffer();
        floatBuffer.put(squareCoords);
        floatBuffer.position(0);

        // initialize byte buffer for the draw list
        ByteBuffer dlb = ByteBuffer.allocateDirect(
                // (# of coordinate values * 2 bytes per short)
                drawOrder.length * 2);
        dlb.order(ByteOrder.nativeOrder());
        shortBuffer = dlb.asShortBuffer();
        shortBuffer.put(drawOrder);
        shortBuffer.position(0);
    }
}
