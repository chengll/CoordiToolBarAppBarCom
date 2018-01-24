package test.dmdfchina.com.glesdemo;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by mkt on 2018/1/23.
 */

public class MyGLSurfaceView extends GLSurfaceView {
    private MyGLRenderer renderer;

    public MyGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        renderer=new MyGLRenderer();
        setRenderer(renderer);
    }
}
