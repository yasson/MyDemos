package com.ys.ts;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 213
 * Created by ys on 2015/1/28.
 */
public class He {

    /**
     * 获取系统垃圾（for 一键清理）
     * a)SD卡根目录下/DCIM/.thumbnails/目录中的以png、jpg和.thumdata为后缀名的文件
     * b)/Android/data/cache/iconCache下的文件
     * c)/Android/data/cache/popCache下的文件
     * d)/Android/data/cache/downloadCache下的文件
     * @param context context
     * @return 系统垃圾大小
     */
    public static long getSystemGarbageForOnkeyCheck(Context context){
        mGarbagePathsForHC.clear();
//        List<String> roots = TwoSdcardUtils.getExternalStorageDirectory(context);
//        for (String root : roots){
        String root= Environment.getExternalStorageDirectory().getPath();
        String root1= Environment.getExternalStorageDirectory().getAbsolutePath();
        if (root.endsWith("/")){
            root=root.substring(0,root.length()-1);
        }
            List<String> sysGbPath=new ArrayList<String>();
            String p1=root+"/Android/data/cache/iconCache";
            String p2=root+"/Android/data/cache/popCache";
            String p3=root+"/Android/data/cache/downloadCache";
            sysGbPath.add(p1);
            sysGbPath.add(p2);
            sysGbPath.add(p3);
            for (String gbPath:sysGbPath){
                File gf=new File(gbPath);
                if (gf.exists()){
                    Log.i("ys","size: "+gf.length()+"|"+gbPath);
                    mGarbagePathsForHC.add(gbPath);
                    mGarbageSizeForHC+=getDirSize(gf);
                }
            }
            String ThumbPath=root+"/DCIM/.thumbnails";
            getFileFromPath(ThumbPath);
//        }
        return mGarbageSizeForHC;
    }

    /**
     * 清理系统垃圾（for 一键清理）
     * @param context context
     */
    public static void clearSystemGarbageForOnkeyCheck(Context context){
        if (mGarbagePathsForHC!=null){
            for (String s : mGarbagePathsForHC){
                deleteFileFromPathOrDirs(s);
            }
        }

    }
    public static long getDirSize(File file) {
        //判断文件是否存在
        if (file.exists()) {
            //如果是目录则递归计算其内容的总大小
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                if (children==null)return 0;
                long size = 0;
                for (File f : children)
                    size += getDirSize(f);
                return size;
            } else {//如果是文件则直接返回其大小,以“兆”为单位
                return file.length();
            }
        } else {
            System.out.println("文件或者文件夹不存在，请检查路径是否正确！");
            return 0;
        }
    }
    public static long mGarbageSizeForHC=0l;
    public static List<String> mGarbagePathsForHC=new ArrayList<String>();

    public static void getFileFromPath(String thumPath){
        ArrayList<String> paths = new ArrayList<String>();
        paths.add(thumPath);

        while(paths.size()>0){
            String p = paths.get(0);
            paths.remove(0);

            File file = new File(p);

            if (file.isFile()) {
                String fileName=file.getName();
                Log.i("ys", "size: " + file.length() + "|" + file.getAbsolutePath());
                if(fileName.endsWith(".png")|| fileName.endsWith(".jpg") || fileName.startsWith(".thumbdata")){
                    mGarbageSizeForHC+=file.length();
                    mGarbagePathsForHC.add(file.getAbsolutePath());
                }
            } else {
                try {
                    String[] files = file.list();

                    if (files == null||files.length==0)
                        continue;

                    for (String s : files) {
                        File f = new File(p+"/"+s);
                        if(f.isFile()){
                            String fileName=f.getName();
                            Log.i("ys", "size: " + f.length() + "|" + f.getAbsolutePath());
                            if(fileName.endsWith(".png")|| fileName.endsWith(".jpg") || fileName.startsWith(".thumbdata")){
                                mGarbageSizeForHC+=f.length();
                                mGarbagePathsForHC.add(f.getAbsolutePath());
                            }
                        }else{
                            paths.add(p+"/"+s);
                        }
                        f = null;
                    }

                    files = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            file = null;
            p = null;
        }

        paths.clear();
        paths = null;

    }
    public static void deleteFileFromPathOrDirs(String s){
        File file=new File(s);
        deleteFile(file);
    }
    public static void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files == null) return;
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i]);
                }
            }
        } else {
            Log.d("yangsen", "删除目录不存在" + file.getAbsolutePath());
        }
    }
}
