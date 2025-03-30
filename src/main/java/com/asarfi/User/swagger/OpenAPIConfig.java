package com.asarfi.User.swagger;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(name = "Asarfi",email = "asarfi@gmail.com",url = "www.asarfi.com"),
                description = "This is the API made for learning ",
                title = "Users API documentation",
                version = "1.0"
        ),
        servers = {
                @Server(description = "Local Environment",url = "http://localhost:8080"),
                @Server(description = "Production Enivironment",url = "https://prod:1234")
        }
        //for security like JWT step:2

//        security = {@SecurityRequirement(name = "bearerAuth")}

)
//It is for security like JWT,etc

//@SecurityScheme(
//        name = "bearerAuth",
//        description = "JWT Auth description",
//        scheme = "bearer",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        in = SecuritySchemeIn.HEADER
//)


public class OpenAPIConfig {
}
