/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Ly Nguyen
 */
@Configuration
public class CloudinaryConfigs {

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "dodo9rlbi",
                        "api_key", "499936591477531",
                        "api_secret", "RcbpgEb6mxsJWLAkkBWSqsqKgEA",
                        "secure", true));
        return cloudinary;
    }
}
