package br.com.thiagomelo.rest.security;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;

@NameBinding
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface JWTRequired {
}