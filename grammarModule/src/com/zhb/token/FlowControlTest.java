package com.zhb.token;

/**
 * @author zhb
 * @create 2022-01-31 1:31
 */

import java.util.Scanner;

/*
* switch-case 只有 switch(exp){ case constexp : ...} 没有 switch {case(exp):...}
* break,continue，return
* */
/*
break 可用于代码块， continue 只能用于循环内。
continue 也能用label指明跳向哪
label1:{
label2:     {
label3:         {
                    break label2;
                }
            }

        }
*/

public class FlowControlTest {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        int negativeNumber=0;
        int positiveNumber = 0;
        for(;;){
            int i = numScanner.nextInt();
            if(i>0){
                positiveNumber++;
            }
            else if (i<0) {
                negativeNumber++;
            }
            else if (i == 0) {
                break;
            }
        }
        System.out.println(positiveNumber);
        System.out.println(negativeNumber);

    }
}
