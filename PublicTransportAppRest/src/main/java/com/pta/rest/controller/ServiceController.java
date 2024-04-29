package com.pta.rest.controller;

import contract.ticket.api.ServiceApi;
import contract.ticket.model.CreateService;
import contract.ticket.model.Service;
import contract.ticket.model.ServiceSearch;
import contract.ticket.model.ServiceWithStations;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@SecurityRequirement(name = "Keycloak")
public class ServiceController implements ServiceApi {
    @Override
    public ResponseEntity<Void> addStationToService(UUID serviceId, UUID stationId) {
        return null;
    }

    @Override
    public ResponseEntity<Service> createNewService(CreateService createService) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteServiceById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<ServiceWithStations> getServiceById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> removeStationFromService(UUID serviceId, UUID stationId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Service>> searchService(Integer xPage, Integer xSize, ServiceSearch serviceSearch) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateService(Service service) {
        return null;
    }
}
