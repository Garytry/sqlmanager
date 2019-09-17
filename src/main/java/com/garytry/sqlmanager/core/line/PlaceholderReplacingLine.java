package com.garytry.sqlmanager.core.line;


import com.garytry.sqlmanager.core.placeholder.PlaceholderReplacer;

/**
 * @Description:
 * @Author gengds
 * @Date 2019/9/13
 * @Version V1.0
 */
public class PlaceholderReplacingLine implements Line {
    //行信息
    private final String line;
    //行号
    private final int lineNumber;

    /**
     * @return
     * @Description:
     * @Author gengds
     * @Date 2019/9/13
     * @Param line 行号 placeholderReplacer分隔符
     */
    public PlaceholderReplacingLine(Line line, PlaceholderReplacer placeholderReplacer) {
        this.line = placeholderReplacer.replacePlaceholders(line.getLine());
        this.lineNumber = line.getLineNumber();
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
        return getLine();
    }
}