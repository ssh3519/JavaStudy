package com.ssh.suanfa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 三种方法：
 *        1.通过String的indexOf方法
 *        2. 通过正则表达式
 *        3. 通过String的split方法
 *        其中第一种方法只能用于精确匹配，第二三种则可以模糊匹配（方法3的参数为正则表达式）。例如：若将child改为“.my.”，第一种方法失效。
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/1 0001 22:02
 */
public class ZiFuChuanPiPeiZiChuan {
    public static void main(String[] args) {
        String str = "You may be out of my sight, but never out of my mind";
//        int my = str.indexOf("my",20);
        matchStringByIndexOf(str, "my");
        matchStringByRegularExpression(str, "my");
//        System.out.println(my);
    }
    //方法1、通过String的indexOf(String str, int fromIndex)方法
    private static void matchStringByIndexOf(String parent, String child) {
        int count = 0;
        int index = 0;
        while ((index = parent.indexOf(child, index)) != -1) {
            index = index + child.length();
            count++;
        }
        System.out.println("匹配个数为" + count);
    }
    //方法2、通过正则表达式
    private static void matchStringByRegularExpression(String parent, String child) {
        int count = 0;
        Pattern p = Pattern.compile(child);
        Matcher m = p.matcher(parent);
        while (m.find()){
            count++;
            System.out.println( "匹配项" + count+"：" + m.group() ); //group方法返回由以前匹配操作所匹配的输入子序列。
        }
        System.out.println( "匹配个数为"+count );
    }
    //方法3、通过split方法
    private static void matchStringBySplit( String parent,String child )
    {
        String[] array = parent.split(child);
        System.out.println( "匹配个数为" + (array.length-1) );
    }
}
