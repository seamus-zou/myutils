package me.showi.myutils;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

/**
 * @author seamus
 * @date 2017年5月5日 上午11:17:42 
 * @description 
 */
public class FileListUtilTest extends TestCase {

	/**
	 * Test method for {@link me.showi.myutils.FileListUtil#delSpecificFile(java.lang.String, java.lang.String)}.
	 */
	public void testDelSpecificFile() {
		FileListUtil.delSpecificFile("E:\\Downloads", "nohup");
	}

	/**
	 * Test method for {@link me.showi.myutils.FileListUtil#getFileList(java.lang.String, java.lang.String)}.
	 */
	public void testGetFileList() {
		List<File> fileList = FileListUtil.getFileList("E:\\Downloads", ".log");
		System.out.println(fileList.size());
	}

}
