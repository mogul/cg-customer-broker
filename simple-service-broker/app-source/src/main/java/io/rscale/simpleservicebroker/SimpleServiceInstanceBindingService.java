package io.rscale.simpleservicebroker;

import org.springframework.cloud.servicebroker.model.binding.CreateServiceInstanceAppBindingResponse;
import org.springframework.cloud.servicebroker.model.binding.CreateServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.binding.CreateServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.binding.DeleteServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.binding.DeleteServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.binding.GetServiceInstanceAppBindingResponse;
import org.springframework.cloud.servicebroker.model.binding.GetServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.binding.GetServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Service;

@Service
public class SimpleServiceInstanceBindingService implements ServiceInstanceBindingService {

	@Override
	public CreateServiceInstanceBindingResponse createServiceInstanceBinding(CreateServiceInstanceBindingRequest request) {
		String serviceInstanceId = request.getServiceInstanceId();
		String bindingId = request.getBindingId();

		//
		// create credentials and store for later retrieval
		//

		String url = new String("http://service-instance-endpoint.example.com");
		String bindingUsername = new String("a-username");
		String bindingPassword = new String("a-password");

		return CreateServiceInstanceAppBindingResponse.builder()
				.credentials("url", url)
				.credentials("username", bindingUsername)
				.credentials("password", bindingPassword)
				.bindingExisted(false)
				.async(true)
				.build();
	}

	@Override
	public DeleteServiceInstanceBindingResponse deleteServiceInstanceBinding(DeleteServiceInstanceBindingRequest request) {
		String serviceInstanceId = request.getServiceInstanceId();
		String bindingId = request.getBindingId();

		//
		// delete any binding-specific credentials
		//

		return DeleteServiceInstanceBindingResponse.builder()
				.async(true)
				.build();
	}

	@Override
	public GetServiceInstanceBindingResponse getServiceInstanceBinding(GetServiceInstanceBindingRequest request) {
		String serviceInstanceId = request.getServiceInstanceId();
		String bindingId = request.getBindingId();

		//
		// retrieve the details of the specified service binding
		//

		String url = new String("http://service-instance-endpoint.example.com");
		String bindingUsername = new String("a-username");
		String bindingPassword = new String("a-password");

		return GetServiceInstanceAppBindingResponse.builder()
				.credentials("username", bindingUsername)
				.credentials("password", bindingPassword)
				.credentials("url", url)
				.build();
	}
}
