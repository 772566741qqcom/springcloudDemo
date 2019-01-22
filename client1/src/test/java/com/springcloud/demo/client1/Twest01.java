package com.springcloud.demo.client1;

import static java.lang.System.out;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class Twest01 {

	@Test
	public void test01() {
		String url = "http://bling-dev.api.percent.cn/tweet/picture/1134f1f1-6145-4b3e-81c5-606145b45f5c_compressed.jpg";
		String[] split = url.split("\\/");
		String key = split[split.length - 2] + "/" + split[split.length - 1];

		out.println(key);
	}


}
