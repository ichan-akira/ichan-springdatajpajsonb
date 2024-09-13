package moe.ichan.springdatajpajsonb.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleResponse {

    private String sampleId;

    private String sampleName;

    private List<String> childJsons;
}
