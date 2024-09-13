package moe.ichan.springdatajpajsonb.service;

import moe.ichan.springdatajpajsonb.dto.request.SampleRequest;
import moe.ichan.springdatajpajsonb.dto.response.SampleResponse;
import org.springframework.data.web.PagedModel;

public interface CrudService {

    SampleResponse createSample(SampleRequest sampleRequest);

    PagedModel<SampleResponse> getSample(String sampleName, Integer page, Integer size);
}
