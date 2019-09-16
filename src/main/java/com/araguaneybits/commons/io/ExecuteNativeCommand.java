/*
 * Copyright 2019 AraguaneyBits.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.araguaneybits.commons.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ExecuteNativeCommand.
 * 
 * @author jestevez
 */
public final class ExecuteNativeCommand {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExecuteNativeCommand.class);

    /**
     * Instantiates a new execute native command.
     */
    private ExecuteNativeCommand() {
        super();
    }

    /**
     * Execute runtime command.
     *
     * @param cmd the cmd
     * @return the list
     */
    public static List<String> executeRuntimeCommand(String cmd) {

        try {
            List<String> lines = new ArrayList<>();

            Process p = Runtime.getRuntime().exec(cmd);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String s = null;
            // read the output from the command
            LOGGER.info("Here is the standard output of the command:");
            while ((s = stdInput.readLine()) != null) {
                LOGGER.info(s);
                lines.add(s);
            }

            // read any errors from the attempted command
            LOGGER.info("Here is the standard error of the command (if any):");
            while ((s = stdError.readLine()) != null) {
                LOGGER.info(s);
                lines.add(s);
            }
            return lines;
        } catch (IOException e) {
            LOGGER.error("exception happened - here's what I know: ", e);
            throw new RuntimeException("Invalid command " + cmd);
        }

    }

}
