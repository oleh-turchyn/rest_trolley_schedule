package com.turchyn.lab3.service;

import com.turchyn.lab3.model.PublicTransport;

import java.util.List;

public interface PublicTransportService extends AbstractDomainObjectService<PublicTransport>{
    List<PublicTransport> searchByType(String type);
    List<PublicTransport> findPublicTransportByType(String type);
}
