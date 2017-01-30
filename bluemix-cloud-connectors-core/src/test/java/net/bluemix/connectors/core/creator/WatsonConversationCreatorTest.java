/*
 * Copyright IBM Corp. 2017
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
package net.bluemix.connectors.core.creator;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import static org.junit.Assert.assertTrue;
import net.bluemix.connectors.core.info.WatsonConversationServiceInfo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cloud.service.ServiceConnectorConfig;

public class WatsonConversationCreatorTest {

    private WatsonConversationCreator creator;

    @Before
    public void setUp() throws Exception {
        creator = new WatsonConversationCreator();
    }

    @After
    public void tearDown() throws Exception {
        creator = null;
    }

    @Test
    public void testCreate() {
        final String test1_uri = "example.com";
        final String test1_username = "username";
        final String test1_password = "password";

        final WatsonConversationServiceInfo serviceInfo
                = new WatsonConversationServiceInfo("id", test1_username, test1_password, test1_uri);

        assertTrue(creator.create(serviceInfo, new ServiceConnectorConfig() {
        }) instanceof ConversationService);
    }

}
