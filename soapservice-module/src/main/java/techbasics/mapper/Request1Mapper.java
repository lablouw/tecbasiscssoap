package techbasics.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import techbasics.domain.model.Request1;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        disableSubMappingMethodsGeneration = true)
public interface Request1Mapper {
    Request1Mapper INSTANCE = Mappers.getMapper(Request1Mapper.class);

    Request1 toDomain(techbasics.api.soapservice.v1.model.Request1 value);
}
