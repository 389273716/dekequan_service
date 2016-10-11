package com.dekequan.library.utils;

import java.math.BigDecimal;

/**
 * 
 * <p>
 * 介绍:随机数生成规则工具
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月11日 下午10:25:48
 * @version 1.0
 */
public class RandomHelper {

	/**
	 * 6位数随机数生成
	 * @return
	 */
    public static String fetchSexRandom() {
        StringBuffer partCountStr = new StringBuffer();
        int partInt = 10;		
        int partBits = 6;
        for (int x = 1; x <= partBits; x++) {
            double partDouble = Math.random() * partInt;
            BigDecimal partBigDecimal = new BigDecimal(partDouble);
            partCountStr.append(partBigDecimal.intValue());
        }

        return partCountStr.toString();
    }
	
}
