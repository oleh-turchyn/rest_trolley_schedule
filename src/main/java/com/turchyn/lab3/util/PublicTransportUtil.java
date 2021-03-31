package com.turchyn.lab3.util;

import com.turchyn.lab3.model.PublicTransport;
import org.springframework.beans.factory.annotation.Autowired;

public class PublicTransportUtil {
    PublicTransport publicTransport;

    @Autowired
    public PublicTransportUtil(PublicTransport publicTransport) {
        this.publicTransport = publicTransport;
    }
}
