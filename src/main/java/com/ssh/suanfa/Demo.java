package com.ssh.suanfa;

import java.util.Random;

/**
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/5/24 0024 11:03
 */
public class Demo {
    public static void main(String[] args) {
        int i=0;
        while (i<50){
            String test = getQuestion();
            if (test==null){
                continue;
            }
            System.out.println(test);
            i++;
        }
    }
    public static String getQuestion(){
        //随机1-19
        int a = getRandom();
        int b = getRandom();
        int c = getRandom();
        //随机空位置(0,1,2,3)
        int index = getRandom(4);
        //随机符号(0:+;1:-)
        int first = getRandom(2);
        int second = getRandom(2);
        //结果
        String result=null;
        if (index==3){
            //1*1*1=() 代表加
            if (first==0){
                if (second==0&&a+b>0&&a+b<20&&a+b+c>0&&a+b+c<20){
                    //a+b+c=()
                    result=a+"+"+b+"+"+c+"="+"()";
                }else if (second==1&&a+b>0&&a+b<20&&a-c>0&&a-c<20&&a+b-c>0&&a+b-c<20){
                    //a+b-c=()
                    result=a+"+"+b+"-"+c+"="+"()";
                }
                return result;
            } else if (first==1){
                if (second==0&&a-b>0&&a-b<20&&a+c>0&&a+c<20&&a-b+c>0&&a-b+c<20){
                    //a-b+c=()
                    result=a+"-"+b+"+"+c+"="+"()";
                }else if (second==1&&a-b>0&&a-b<20&&a-b-c>0&&a-b-c<20){
                    //a-b-c=()
                    result=a+"-"+b+"-"+c+"="+"()";
                }
                return result;
            }

        }
        else if (index==2){
            //a*b*()=c
            if (first==0){
                if (second==0&&a+b>0&&a+b<20&&c-a>0&&c-a<20&&c-b>0&&c-b<20&&c-a-b>0&&c-a-b<20){
                    //a+b+()=c
                    result=a+"+"+b+"+"+"()"+"="+c;
                }
                else if (second==1&&a+b>0&&a+b<20&&a-c>0&&a-c<20&&b-c>0&&b-c<20&&a+b-c>0&&a+b-c<20){
                    //a+b-()=c
                    result=a+"+"+b+"-"+"()"+"="+c;
                }
                return result;

            } else if (first==1){
                if (second==0&&a-b>0&&a-b<20&&c-a>0&&c-a<20&&c+b>0&&c+b<20&&c-a+b>0&&c-a+b<20){
                    //a-b+()=c
                    result=a+"-"+b+"+"+"()"+"="+c;
                } else if (second==1&&a-b>0&&a-b<20&&a-c>0&a-c<20&&a-b-c>0&&a-b-c<20){
                    //a-b-()=c
                    result=a+"-"+b+"-"+"()"+"="+c;
                }
                return result;
            }
        }else if (index==1){
            //a*()*b=c
            if (first==0){
                if (second==0&&a+b>0&&a+b<20&&c-a>0&&c-a<20&&c-b>0&&c-b<20&&c-a-b>0&&c-a-b<20){
                    //a+()+b=c
                    result=a+"+"+"()"+"+"+b+"="+c;

                }else if (second==1&&a-b>0&&a-b<20&&c-a>0&&c-a<20&&c+b>0&&c+b<20&&c+b-a>0&&c+b-a<20){
                    //a+()-b=c
                    result=a+"+"+"()"+"-"+b+"="+c;
                }
                return result;

            }else if (first==1){
                //a*()*b=c
                if (second==0&&a+b>0&&a+b<20&&a-c>0&&a-c<20&&c-b>0&&c-b<20&&a+b-c>0&&a+b-c<20){
                    //a-()+b=c
                    result=a+"-"+"()"+"+"+b+"="+c;
                }else if (second==1&&a-c>0&&a-c<20&&a-b>0&&a-b<20&&c+b>0&&c+b<20&&a-b-c>0&&a-b-c<20){
                    //a-()-b=c
                    result=a+"-"+"()"+"-"+b+"="+c;
                }
                return result;
            }
        }else if (index==0){
            //()*a*b=c
            if (first==0){
                if (second==0&&c-a>0&&c-a<20&&c-b>0&&c-b<20&&a+b>0&&a+b<20&&c-a-b>0&&c-a-b<20){
                    //()+a+b=c
                    result="()"+"+"+a+"+"+b+"="+c;
                }else if (second==1&&b+c>0&&b+c<20&&c-a>0&&c-a<20&&c+b-a>0&&c+b-a<20){
                    //()+a-b=c
                    result="()"+"+"+a+"-"+b+"="+c;
                }
                return result;
            }else if (first==1){
                if (second==0&&c-b>0&&c-b<20&&c+a>0&&c+a<20&&b-a>0&&b-a<20&&c-b+a>0&&c-b+a<20){
                    //()-a+b=c
                    result="()"+"-"+a+"+"+b+"="+c;
                }else if (second==1&&c+a>0&&c+a<20&&c+b>0&&c+b<20&&a+b>0&&a+b<20&&c+b+a>0&&c+b+a<20){
                    //()-a-b=c
                    result="()"+"-"+a+"-"+b+"="+c;
                }
                return result;
            }
        }
        return result;
    }
    //得到随机位置
    private static int getRandom(Integer integer){
        return new Random().nextInt(integer);
    }

    //得到随机数
    private static int getRandom(){
        return (int)(Math.random()*19)+1;
    }

}
