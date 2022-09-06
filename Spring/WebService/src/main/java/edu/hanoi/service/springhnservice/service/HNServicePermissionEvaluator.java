package edu.hanoi.service.springhnservice.service;

import edu.hanoi.service.springhnservice.controller.UserRestServiceController;
import edu.hanoi.service.springhnservice.model.User;
import org.apache.log4j.Logger;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class HNServicePermissionEvaluator implements PermissionEvaluator {

    private static final Logger LOGGER = Logger.getLogger(HNServicePermissionEvaluator.class);

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
//        if (targetDomainObject instanceof User){
//            User user = (User) targetDomainObject;
//            return user.getAge() > 50;
//        }
        LOGGER.info("-----------------> " + targetDomainObject + " : " + permission);
        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        LOGGER.info("-----> " + targetType + " : " + permission);
        return true;
    }


}
