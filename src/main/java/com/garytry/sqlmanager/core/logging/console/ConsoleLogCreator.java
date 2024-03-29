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
package com.garytry.sqlmanager.core.logging.console;

import com.garytry.sqlmanager.core.logging.Log;
import com.garytry.sqlmanager.core.logging.LogCreator;
import com.garytry.sqlmanager.core.logging.console.ConsoleLog.Level;

/**
 * Log Creator for the Command-Line console.
 */
public class ConsoleLogCreator implements LogCreator {
    private final Level level;

    /**
     * Creates a new Console Log Creator.
     *
     * @param level The minimum level to log at.
     */
    public ConsoleLogCreator(Level level) {
        this.level = level;
    }

    public Log createLogger(Class<?> clazz) {
        return new ConsoleLog(level);
    }
}