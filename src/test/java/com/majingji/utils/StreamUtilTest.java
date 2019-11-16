package com.majingji.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.majingji.utils.StreamUtil;

/** 
* @author 作者:majingji
* @version 创建时间：2019年11月8日 下午3:17:53 
* 类功能说明 
*/
public class StreamUtilTest {

	@Test
	public void testCloseAll() {
		
	}

	@Test
	public void testReadTextFileInputStream() throws FileNotFoundException, Exception {
		String file = StreamUtil.readTextFile(new FileInputStream("D:/Desktop/a.txt"));
		System.out.println(file);
	}

	@Test
	public void testReadTextFileFile() throws FileNotFoundException, Exception {
		String file = StreamUtil.readTextFile(new File("D:/Desktop/a.txt"));
		System.out.println(file);
	}
	
	@Test
	public void tesRreadLineTextFile() throws Exception {
		List<String> list = StreamUtil.readLineTextFile(new File("D:/Desktop/a.txt"));
		for (String string : list) {
			System.out.println(string);
		}
	}

}
