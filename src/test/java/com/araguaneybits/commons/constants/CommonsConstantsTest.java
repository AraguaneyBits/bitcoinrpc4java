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
package com.araguaneybits.commons.constants;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * The Class CommonsConstantsTest.
 * 
 * @author jestevez
 */
public class CommonsConstantsTest {

    /**
     * Test constants.
     */
    @Test
    public void testConstants() {
        assertNotNull("Is not null", CommonsConstants.HTTP_NON_PROXY_HOST);

        assertNotNull("Is not null", CommonsConstants.TRUE);
        assertNotNull("Is not null", CommonsConstants.FALSE);
        assertNotNull("Is not null", CommonsConstants.EMPTY_STRING);
        assertNotNull("Is not null", CommonsConstants.NONE);
    }
}
