package com.springapp.web.mvc.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Maxime on 2/17/2015.
 */
@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class NotFoundException extends RuntimeException {
    
}
