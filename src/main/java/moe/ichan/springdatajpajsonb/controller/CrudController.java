package moe.ichan.springdatajpajsonb.controller;

import jakarta.validation.Valid;
import moe.ichan.springdatajpajsonb.dto.request.SampleRequest;
import moe.ichan.springdatajpajsonb.dto.response.SampleResponse;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CrudController {

    @PostMapping(value = "/api/v1/crud/sample")
    ResponseEntity<SampleResponse> createSample(
            @RequestBody
            SampleRequest request
    );

    @GetMapping(value = "/api/v1/crud/sample")
    ResponseEntity<PagedModel<SampleResponse>> getSample(
            @Valid @RequestParam(value = "sample_name", required = false) String sampleName,
            @Valid @RequestParam(value = "page") Integer page,
            @Valid @RequestParam(value = "size") Integer size
    );
}
