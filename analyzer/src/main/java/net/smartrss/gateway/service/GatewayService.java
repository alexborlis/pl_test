package net.smartrss.gateway.service;

import net.smartrss.gateway.model.ModelRequest;
import net.smartrss.gateway.model.ModelResponse;

/**
 * Created by Alexander on 03.02.2016.
 */
public interface GatewayService<REQ extends ModelRequest, RES extends ModelResponse> {

    RES proceed(REQ request);

}
