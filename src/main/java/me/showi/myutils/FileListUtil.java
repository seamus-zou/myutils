package me.showi.myutils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author seamus
 * @date 2017年5月5日 上午10:48:52
 * @description 遍历所有的文件
 */
public class FileListUtil {
	
	 public static List<File> filelist = new ArrayList<File>();
	 
	/**
	 * 删除文件名中包含指定字符串的文件
	 * 
	 * @param path
	 * @param rex
	 */
	public static void delSpecificFile(String path, String rex) {

		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				System.out.println("文件夹是空的!");
				return;
			} else {
				for (File subFile : files) {
					if (subFile.isDirectory()) {
						System.out.println("文件夹:" + subFile.getAbsolutePath());
						delSpecificFile(subFile.getAbsolutePath(), rex);
					} else {
						if (subFile.getName().contains(rex)) {
							System.out.println("===============删除文件:" + subFile.getAbsolutePath());
							subFile.delete();
						}
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
	}
	
	/**
	 * 
	 * @param strPath
	 * @param rex
	 * @return
	 */
	public static List<File> getFileList(String strPath, String rex) {
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
       
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath(),rex); // 获取文件绝对路径
                } else if (fileName.endsWith(rex)) { // 判断文件名是否以.rex结尾
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println("---" + strFileName);
                    filelist.add(files[i]);
                } else {
                    continue;
                }
            }

        }
        return filelist;
    }
}
