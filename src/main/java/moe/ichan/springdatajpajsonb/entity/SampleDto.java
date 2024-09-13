package moe.ichan.springdatajpajsonb.entity;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface SampleDto {

    @Value("#{target.sample_id}")
    String getSampleId();

    @Value("#{target.sample_name}")
    String getSampleName();

    @Value("#{T(moe.ichan.springdatajpajsonb.util.JsonUtils).parseJsonOrDefault(target.child_jsons, T(java.util.List), null)}")
    List<String> getChildJsons();
}
