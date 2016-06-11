package utils;

import android.app.Application;
import android.graphics.Bitmap;

import com.example.bizhidemo.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by Schuman on 2016/6/11.
 */
public class MyApp extends Application {
    private ImageLoader loader;

    //当程序运行时，第一个运行的方法，程序的入口
    @Override
    public void onCreate() {
        super.onCreate();
        loader = ImageLoader.getInstance();

        //loader对象的手动配置
        //初始化ImageConfiguration类对象
       ImageLoaderConfiguration config = initConfiguration();
        loader.init(config);
    }

    private ImageLoaderConfiguration initConfiguration() {
        //File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        File file = getCacheDir();//获取默认缓存文件夹，位于data/data/包名/cache
        if(!file.exists()){
            file.mkdirs();

        }
        DisplayImageOptions options = initDisplayOptions();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())

                .threadPoolSize(3) //最多可以同时下载多少张图片
                .memoryCacheSizePercentage(30)//设置最大的内容大小，占用可用内存的百分比
                .memoryCache(new WeakMemoryCache())//设置缓存策略
                .diskCacheSize(10*1024*1024)
                .diskCache(new UnlimitedDiskCache(file))//设置磁盘缓存策略
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())//设置文件的命名方式
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())//设置图片显示时的配置信息
                .build();

        return  config;
    }

    private DisplayImageOptions initDisplayOptions() {

        return  new DisplayImageOptions.Builder()
                .cacheInMemory(true)//图片下载后是否缓存到内存中
                .cacheOnDisk(true)//图片下载后是否缓存到本地
                .showImageOnLoading(R.mipmap.ic_launcher)//设置下载过程中 控件上显示的图片
                .showImageOnFail(R.mipmap.ic_launcher)//下载失败时 显示的图片
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

    }

    public ImageLoader getLoader() {
        return loader;
    }
}
