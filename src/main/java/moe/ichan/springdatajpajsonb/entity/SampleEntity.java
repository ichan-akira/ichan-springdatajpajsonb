package moe.ichan.springdatajpajsonb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sample", schema = "ichan_schema")
public class SampleEntity {

    @Id
    private String sampleId;

    private String sampleName;

    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> childJsons;
}
