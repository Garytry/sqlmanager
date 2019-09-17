package com.garytry.sqlmanager.core.line;

/**
 * @Description: A line in a SQL statement
 * @Author gengds
 * @Date 2019/9/13
 * @Version V1.0
 */
public interface Line {
   /**
    * @Description: 获取行号
    * @Author gengds
    * @Date  2019/9/13 
    * @Param 
    * @return 行号
    */
    int getLineNumber();

   /**
    * @Description: 获取行信息
    * @Author gengds
    * @Date  2019/9/13
    * @Param
    * @return 行信息
    */
    String getLine();
}
