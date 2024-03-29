/*
 * Copyright 2010-2018 Boxfuse GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.garytry.sqlmanager.core.resource;

import com.garytry.sqlmanager.core.line.DefaultLineReader;
import com.garytry.sqlmanager.core.line.LineReader;

import java.io.StringReader;

public class StringResource extends AbstractLoadableResource {
    private final String str;

    public StringResource(String str) {
        this.str = str;
    }

    @Override
    public LineReader loadAsString() {
        return new DefaultLineReader(new StringReader(str));
    }

    @Override
    public byte[] loadAsBytes() {
        return new byte[0];
    }

    @Override
    public String getAbsolutePath() {
        return "";
    }

    @Override
    public String getAbsolutePathOnDisk() {
        return "";
    }

    @Override
    public String getFilename() {
        return "";
    }

    @Override
    public String getRelativePath() {
        return "";
    }
}