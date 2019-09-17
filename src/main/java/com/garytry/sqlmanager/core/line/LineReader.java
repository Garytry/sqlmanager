package com.garytry.sqlmanager.core.line;

import java.io.Closeable;

/**
 * @Description: 读行
 * @Author gengds
 * @Date 2019/9/13
 * @Version V1.0
 */
public interface LineReader extends Closeable {
    Line readLine();
}
