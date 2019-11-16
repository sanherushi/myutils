package com.majingji.utils;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.majingji.utils.FileUtil;

/** 
* @author 作者:majingji
* @version 创建时间：2019年11月8日 下午2:36:10 
* 类功能说明 
*/
public class FileUtilTest {

	@Test
	public void testGetExtendName() {
		String name = FileUtil.getExtendName("name.doc");
		System.out.println(name);
	}

	@Test
	public void testGetTempDirectory() {
		File file = FileUtil.getTempDirectory();
		System.out.println(file);
	}

	@Test
	public void testGetUserDirectory() {
		File file = FileUtil.getUserDirectory();
		System.out.println(file);
	}

}
