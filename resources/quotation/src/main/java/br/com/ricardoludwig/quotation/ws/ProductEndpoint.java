package br.com.ricardoludwig.quotation.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.ricardoludwig_quotation.web_service.GetProductRequest;
import br.com.ricardoludwig_quotation.web_service.GetProductResponse;

@Endpoint
public class ProductEndpoint {

	private static final String NAMESPACE_URI = "http://ricardoludwig-quotation.com.br/web-service";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
	@ResponsePayload
	public GetProductResponse getResponse(@RequestPayload GetProductRequest request) {
		GetProductResponse gpr = new GetProductResponse();
		gpr.setResponse("Orçamento recebido com sucesso");

		return gpr;
	}
}
