/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.common.engine.impl.eventregistry.payload;

import java.util.Map;

import org.flowable.common.engine.api.eventregistry.EventProcessingContext;
import org.flowable.common.engine.api.eventregistry.InboundEventPayloadExtractor;
import org.flowable.common.engine.impl.eventregistry.constant.EventProcessingConstants;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Joram Barrez
 */
public class JsonFieldToMapPayloadExtractor implements InboundEventPayloadExtractor {

    protected ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, Object> extractPayload(EventProcessingContext eventProcessingContext) {
        JsonNode jsonNode = eventProcessingContext.getProcessingData(EventProcessingConstants.DESERIALIZED_JSON_NODE, JsonNode.class);
        return objectMapper.convertValue(jsonNode, new TypeReference<Map<String, Object>>(){});
    }

}
