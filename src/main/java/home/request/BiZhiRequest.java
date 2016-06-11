package home.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Created by Schuman on 2016/6/10.
 * 功能：自定义适配器
 */
public class BiZhiRequest<T> extends Request<T> {

    private Response.Listener<T> listener;
    private Class<T> clazz;

    public BiZhiRequest(Class<T> clazz,String url, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(clazz,Method.GET, url,listener,errorListener);
    }



    public BiZhiRequest(Class<T> clazz,int method, String url,Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = listener;
        this.clazz = clazz;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        String parse;
        try {
            parse = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            parse = new String(response.data);
        }
        T tBean = new Gson().fromJson(parse, clazz);


        return Response.success(tBean, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(T response) {
        if(listener!=null){
            listener.onResponse(response);
        }

    }

    @Override
    protected void onFinish() {
        super.onFinish();
        listener = null;
    }
}
