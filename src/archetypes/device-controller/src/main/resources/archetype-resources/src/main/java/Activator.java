/*
 * Copyright 2016-2018 Universitat Politècnica de València
 * Copyright 2016-2018 Università della Calabria
 * Copyright 2016-2018 Prodevelop, SL
 * Copyright 2016-2018 Technische Universiteit Eindhoven
 * Copyright 2016-2018 Fundación de la Comunidad Valenciana para la
 * Investigación, Promoción y Estudios Comerciales de Valenciaport
 * Copyright 2016-2018 Rinicom Ltd
 * Copyright 2016-2018 Association pour le développement de la formation
 * professionnelle dans le transport
 * Copyright 2016-2018 Noatum Ports Valenciana, S.A.U.
 * Copyright 2016-2018 XLAB razvoj programske opreme in svetovanje d.o.o.
 * Copyright 2016-2018 Systems Research Institute Polish Academy of Sciences
 * Copyright 2016-2018 Azienda Sanitaria Locale TO5
 * Copyright 2016-2018 Alessandro Bassi Consulting SARL
 * Copyright 2016-2018 Neways Technologies B.V.
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package \${package};

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import eu.interiot.gateway.commons.api.configuration.ConfigurationService;
import eu.interiot.gateway.commons.physical.api.dmanager.DeviceControllerFactory;

public class Activator implements BundleActivator{
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		/******************************************
		 * Get configuration key-value properties *
		 * from the gateway configuration file    *
		 * (if needed)                            *
		 ******************************************/
		
		ConfigurationService configuration = context.getService(context.getServiceReference(ConfigurationService.class));
		
		@SuppressWarnings("unused")
		int examplePort = configuration.getInt("port", 5678); // default value if not exists
		
		/**************************************
		 * Instantiate the controller factory *
		 * service and register it with a     *
		 * controller key                     *
		 **************************************/
		
		DeviceControllerFactory exampleDeviceControllerFactory = DeviceControllerFactory.generic(ExampleDeviceController.class);
		Hashtable<String, String> serviceProperties = new Hashtable<>();
		serviceProperties.put("controller-key", "\${artifactId}");
		context.registerService(DeviceControllerFactory.class, exampleDeviceControllerFactory, serviceProperties);
	}
	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
