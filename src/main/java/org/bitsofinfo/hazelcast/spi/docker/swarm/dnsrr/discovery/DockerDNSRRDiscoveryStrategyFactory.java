/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bitsofinfo.hazelcast.spi.docker.swarm.dnsrr.discovery;

import com.hazelcast.config.properties.PropertyDefinition;
import com.hazelcast.logging.ILogger;
import com.hazelcast.spi.discovery.DiscoveryNode;
import com.hazelcast.spi.discovery.DiscoveryStrategy;
import com.hazelcast.spi.discovery.DiscoveryStrategyFactory;

import java.util.Collection;
import java.util.Map;

/**
 * Factory to produce <code>DockerDNSRRDiscoveryStrategy</code>
 *
 * @author Cardds
 */
public class DockerDNSRRDiscoveryStrategyFactory
        implements DiscoveryStrategyFactory {
    @Override
    public Class<? extends DiscoveryStrategy> getDiscoveryStrategyType() {
        return DockerDNSRRDiscoveryStrategy.class;
    }

    @Override
    public DiscoveryStrategy newDiscoveryStrategy(
            DiscoveryNode discoveryNode,
            ILogger logger,
            //Implementing DiscoveryStrategyFactory method with a raw type
            @SuppressWarnings("rawtypes") Map<String, Comparable> properties
    ) {
        return
                new DockerDNSRRDiscoveryStrategy(
                        logger,
                        properties
                );
    }

    @Override
    public Collection<PropertyDefinition> getConfigurationProperties() {
        return DockerDNSRRDiscoveryConfiguration.PROPERTIES;
    }
}
