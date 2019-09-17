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
package com.garytry.sqlmanager.core.scanner;

import com.garytry.sqlmanager.core.clazz.ClassProvider;
import com.garytry.sqlmanager.core.logging.Log;
import com.garytry.sqlmanager.core.logging.LogFactory;
import com.garytry.sqlmanager.core.resource.LoadableResource;
import com.garytry.sqlmanager.core.resource.ResourceProvider;
import com.garytry.sqlmanager.core.scanner.filesystem.FileSystemScanner;
import com.garytry.sqlmanager.util.StringUtils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Scanner for Resources and Classes.
 */
public class Scanner implements ResourceProvider, ClassProvider {
    private static final Log LOG = LogFactory.getLog(Scanner.class);

    private final List<LoadableResource> resources = new ArrayList<>();
    private final List<Class<?>> classes = new ArrayList<Class<?>>();

    public Scanner(Collection<Location> locations, ClassLoader classLoader, Charset encoding


    ) {
        FileSystemScanner fileSystemScanner = new FileSystemScanner(encoding

        );


        for (Location location : locations) {
            if (location.isFileSystem()) {
                resources.addAll(fileSystemScanner.scanForResources(location));
            } else {
                LOG.error("not find location");
            }
        }
    }

    @Override
    public LoadableResource getResource(String name) {
        for (LoadableResource resource : resources) {
            String fileName = resource.getFilename();
            if (fileName.equals(name)) {
                return resource;
            }
        }
        return null;
    }

    /**
     * Scans this location for resources, starting with the specified prefix and ending with the specified suffix.
     *
     * @param prefix   The prefix of the resource names to match.
     * @param suffixes The suffixes of the resource names to match.
     * @return The resources that were found.
     */
    public Collection<LoadableResource> getResources(String prefix, String... suffixes) {
        List<LoadableResource> result = new ArrayList<>();
        for (LoadableResource resource : resources) {
            String fileName = resource.getFilename();
            if (StringUtils.startsAndEndsWith(fileName, prefix, suffixes)) {
                result.add(resource);
            } else {
                LOG.debug("Filtering out resource: " + resource.getAbsolutePath() + " (filename: " + fileName + ")");
            }
        }
        return result;
    }

    /**
     * Scans the classpath for concrete classes under the specified package implementing this interface.
     * Non-instantiable abstract classes are filtered out.
     *
     * @param implementedInterface The interface the matching classes should implement.
     * @return The non-abstract classes that were found.
     */
    public <I> Collection<Class<? extends I>> getClasses(Class<I> implementedInterface) {
        List<Class<? extends I>> result = new ArrayList<Class<? extends I>>();
        for (Class<?> clazz : classes) {
            if (!implementedInterface.isAssignableFrom(clazz)) {
                continue;
            }

            //noinspection unchecked
            result.add((Class<? extends I>) clazz);
        }
        return result;
    }
}