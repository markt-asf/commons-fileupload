/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.fileupload.utils.mime;

import static org.junit.Assert.assertEquals;

import org.apache.commons.fileupload.util.mime.MimeUtility;
import org.junit.Test;

/**
 * @since 1.3
 */
public final class MimeUtilityTestCase {

    @Test
    public void testEncodeText() throws Exception {
        assertEncoded("abc", "abc");

        assertEncoded(" h�! ���u !!!", "=?UTF-8?Q?_h=C3=A9!_=C3=A0=C3=A8=C3=B4u_!!!?=");

        assertEncoded(" h�! ���u !!!", "=?UTF-8?B?IGjDqSEgw6DDqMO0dSAhISE=?=");
    }

    private static void assertEncoded(String expected, String encoded) throws Exception {
        assertEquals(expected, MimeUtility.decodeText(encoded));
    }

}