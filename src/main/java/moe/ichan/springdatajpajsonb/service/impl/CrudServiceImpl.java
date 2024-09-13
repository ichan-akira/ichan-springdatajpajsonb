package moe.ichan.springdatajpajsonb.service.impl;

import lombok.RequiredArgsConstructor;
import moe.ichan.springdatajpajsonb.dto.request.SampleRequest;
import moe.ichan.springdatajpajsonb.dto.response.SampleResponse;
import moe.ichan.springdatajpajsonb.entity.SampleEntity;
import moe.ichan.springdatajpajsonb.repository.SampleRepository;
import moe.ichan.springdatajpajsonb.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CrudServiceImpl implements CrudService {

    private final SampleRepository sampleRepository;

    @Override
    public SampleResponse createSample(SampleRequest sampleRequest) {
        var sample = SampleEntity
                .builder()
                .sampleId(sampleRequest.getSampleId())
                .sampleName(sampleRequest.getSampleName())
                .childJsons(sampleRequest.getChildJsons())
                .build();
        sample = sampleRepository.save(sample);
        return SampleResponse
                .builder()
                .sampleId(sample.getSampleId())
                .sampleName(sample.getSampleName())
                .childJsons(sample.getChildJsons())
                .build();
    }

    @Override
    public PagedModel<SampleResponse> getSample(String sampleName, Integer page, Integer size) {
        var pageRequest = PageRequest.of(page, size);
        var samplePage = sampleRepository.getSample(sampleName, pageRequest);
        var samples = samplePage.stream()
                .map(sample -> SampleResponse
                        .builder()
                        .sampleId(sample.getSampleId())
                        .sampleName(sample.getSampleName())
                        .childJsons(sample.getChildJsons())
                        .build()).toList();
        return new PagedModel<>(new PageImpl<>(samples, pageRequest, samplePage.getTotalElements()));
    }
}
