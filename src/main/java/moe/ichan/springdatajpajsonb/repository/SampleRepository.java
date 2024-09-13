package moe.ichan.springdatajpajsonb.repository;

import moe.ichan.springdatajpajsonb.entity.SampleDto;
import moe.ichan.springdatajpajsonb.entity.SampleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, String> {

    @Query(value = """
            SELECT sample_id, sample_name, child_jsons
            FROM ichan_schema.sample
            WHERE (:sampleName IS NULL OR sample_name ILIKE :sampleName)
            ORDER BY sample_id ASC
            """, nativeQuery = true)
    Page<SampleDto> getSample(
            @Param("sampleName") String sampleName,
            Pageable pageable
    );
}
