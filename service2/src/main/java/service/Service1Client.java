package service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("SERVICE1")
public interface Service1Client {

    @RequestMapping(method = RequestMethod.GET, path= "/service1/service1")
    String getSvr1Test();

    @RequestMapping(method = RequestMethod.GET, path= "/service0/service0")
    String getSvr0Test();

    @RequestMapping(method = RequestMethod.GET, path= "/common")
    String common();
}
