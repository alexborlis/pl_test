package net.smartrss.gateway.service.google;

import net.smartrss.gateway.model.google.web.GoogleSearchRequest;
import net.smartrss.gateway.model.google.web.GoogleSearchResponse;
import org.springframework.stereotype.Service;

/**
 * Created by Alexander on 03.02.2016.
 */
@Service
public class GoogleWebSearchService implements GoogleGatewayService<GoogleSearchRequest, GoogleSearchResponse> {

    @Override
    public GoogleSearchResponse proceed(GoogleSearchRequest request) {
        return null;
    }
}
