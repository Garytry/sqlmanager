package com.garytry.sqlmanager.core.line;

/**
 * @Description: A line in a SQL statement
 * @Author gengds
 * @Date 2019/9/13
 * @Version V1.0
 */
public class DefaultLine implements Line {
    //行号
    private final int lineNumber;
    //行号
    private final String line;

    public DefaultLine(int lineNumber, String line) {
        this.lineNumber = lineNumber;
        this.line = line;
    }

    @Override
    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String getLine() {
        return line;
    }

    @Override
    public String toString() {
        return lineNumber + ":" + line;
    }
}