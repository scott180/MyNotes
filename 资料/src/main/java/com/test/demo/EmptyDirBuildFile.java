package com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
空文件下建立README.txt文件
*/

public class EmptyDirBuildFile {

	static String dir = "D:\\test";

	public static void main(String[] args) {
		// write(dir);
		File file = new File(dir);
		if (!file.exists() || file.isFile()) {
			System.out.println(dir + "  不存在或者是文件");
		} else {
			recursion(file);
		}
	}

	private static void recursion(File file) {
		File[] children = file.listFiles();
		if (children.length == 0) {
			write(file);
		}
		for (File f : children) {
			if (f.isDirectory()) {
				recursion(f);
			}
		}
	}

	private static void write(File dir) {
		// TODO Auto-generated method stub
		File file = new File(dir.getAbsolutePath() + "\\README.txt");
		OutputStreamWriter fw = null;
		try {
			if (file.exists()) {
				return;
			}
			System.out.println(file.getAbsolutePath());
			fw = new OutputStreamWriter(new FileOutputStream(file, true),
					"UTF-8");
			fw.write("README");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
