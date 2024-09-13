package moe.ichan.springdatajpajsonb.controller.impl;

import lombok.RequiredArgsConstructor;
import moe.ichan.springdatajpajsonb.controller.CrudController;
import moe.ichan.springdatajpajsonb.dto.request.SampleRequest;
import moe.ichan.springdatajpajsonb.dto.response.SampleResponse;
import moe.ichan.springdatajpajsonb.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CrudControllerImpl implements CrudController {

    private final CrudService crudService;

    @Override
    public ResponseEntity<SampleResponse> createSample(SampleRequest request) {
        return ResponseEntity.ok(crudService.createSample(request));
    }

    @Override
    public ResponseEntity<PagedModel<SampleResponse>> getSample(String sampleName, Integer page, Integer size) {
        return ResponseEntity.ok(crudService.getSample(sampleName, page, size));
    }
}
