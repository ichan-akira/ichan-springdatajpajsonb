package moe.ichan.springdatajpajsonb.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleRequest {

    private String sampleId;

    private String sampleName;

    private List<String> childJsons;
}
