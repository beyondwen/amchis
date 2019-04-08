package com.amchis.common;

public class PrintSizeUtil {
	public static int getPrintSize(int size) {
		if (size < 1024) {
			return  size;
		} else {
			return size = size / 1024;
		}
	}
}
