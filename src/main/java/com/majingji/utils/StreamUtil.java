package com.majingji.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者:majingji
 * @version 创建时间：2019年11月8日 下午2:50:03 类功能说明
 */
public class StreamUtil {
	/*
	 * 方法1：批量关闭流，参数能传无限个。(3分) 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭。
	 */
	public static void closeAll(AutoCloseable... autoCloseables) throws Exception {
		if (autoCloseables != null && autoCloseables.length > 0) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				autoCloseable.close();
			}
		}
		// TODO 实现代码
	}

	/*
	 * 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(3分)，要求方法内部调用上面第1个方法关闭流(3分)
	 */
	public static String readTextFile(InputStream src) throws Exception {
		// 定义一个长度为1024的字节数组
		byte[] arr = new byte[1024];
		int len = 0;
		String str = "";
		try {
			while ((len = src.read(arr)) != -1) {
				str += new String(arr, 0, len, "UTF-8");// 把字节数组的一部分转成字符串
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(src);
		}
		return null;
		// TODO 实现代码
	}

	/*
	 * 方法3：传入文本文件对象，返回该文件内容(3分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	 */
	public static String readTextFile(File txtFile) throws FileNotFoundException, Exception {
		String str = readTextFile(new FileInputStream(txtFile));
		return str;
		// TODO 实现代码
	}

	/**
	 * 方法4:一行行读取文件的内容
	 * 
	 * @param txtFile
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	public static List<String> readLineTextFile(File txtFile) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(txtFile)));
		List<String> list = new ArrayList<String>();
		String str = "";
		try {
			while ((str = reader.readLine()) != null) {
				list.add(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeAll(reader);
		}
		return list;
	}

}
