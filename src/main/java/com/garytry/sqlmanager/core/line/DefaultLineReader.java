package com.garytry.sqlmanager.core.line;

import com.garytry.sqlmanager.core.exception.sqlManagerException;

import java.io.IOException;
import java.io.Reader;

/**
 * @Description:
 * @Author gengds
 * @Date 2019/9/13
 * @Version V1.0
 */
public class DefaultLineReader implements LineReader {
    private final Reader reader;

    private int lineNumber;

    public DefaultLineReader(Reader reader) {
        this.reader = new BufferedCharReader(reader);
    }

    @Override
    public Line readLine() {
        lineNumber++;
        try {
            StringBuilder line = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                line.append(ch);
                if (ch == '\n') {
                    break;
                }
            }
            if (line.length() == 0) {
                return null;
            }
            return new DefaultLine(lineNumber, line.toString());
        } catch (IOException e) {
            throw new sqlManagerException("Unable to read line " + lineNumber + ": " + e.getMessage(), e);
        }
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

    private static class BufferedCharReader extends Reader {
        private final Reader r;
        private final char[] buffer = new char[16384];
        private boolean end;
        private int max = 0;
        private int pos = 0;

        private BufferedCharReader(Reader r) {
            this.r = r;
        }

        @Override
        public int read() throws IOException {
            if (pos < max) {
                return buffer[pos++];
            }
            if (end) {
                return -1;
            }
            max = r.read(buffer);
            if (max <= 0) {
                end = true;
                return -1;
            }
            pos = 0;
            return buffer[pos++];
        }

        @Override
        public int read(char[] cbuf, int off, int len) throws IOException {
            return r.read(cbuf, off, len);
        }

        @Override
        public void close() throws IOException {
            r.close();
        }
    }
}
