package com.lenservice.bjmspqqmf;

import java.io.File;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

public class QFApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		initImageLoader(this, null);
	}
	/**
	 * 初始化图片加载器
	 * 
	 * @param mContext
	 * @param defaultOptions
	 */
	public static void initImageLoader(Context mContext,
			DisplayImageOptions defaultOptions) {

		if (defaultOptions == null)
			defaultOptions = buildImageOptions(mContext);

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				mContext)
		.threadPoolSize(5)
		.defaultDisplayImageOptions(defaultOptions)
		.threadPriority(Thread.NORM_PRIORITY - 2)
		.denyCacheImageMultipleSizesInMemory()
		.discCacheFileNameGenerator(new Md5FileNameGenerator())
		.tasksProcessingOrder(QueueProcessingType.LIFO)
		.memoryCache(new WeakMemoryCache())
		.memoryCacheSize(3* 1024 * 1024)
		.discCacheSize(6*1024*1024)
		.discCacheFileCount(100) //缓存的文件数量 
		//.discCache(new UnlimitedDiscCache(new File(getCachePath())))
		/*.writeDebugLogs()*/.build();

		ImageLoader.getInstance().init(config);
	}
	public static String getCachePath() {
		String sdDir = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
		if (sdCardExist) {
			sdDir = Environment.getExternalStorageDirectory().getPath()+"/"+"catch";// 获取跟目录
		} else {
			sdDir = "data/data/files/";
		}
		return sdDir;
	}
	/**
	 * 创建图片参数
	 * 
	 * @param mContext
	 * @return
	 */
	private static DisplayImageOptions buildImageOptions(Context mContext) {
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
		.considerExifParams(true).cacheInMemory(false).cacheOnDisc(true)
//		.bitmapConfig(android.graphics.Bitmap.Config.RGB_565)
//		.displayer(new RoundedBitmapDisplayer(1)) 
		.build();

		return defaultOptions;
	}
}
