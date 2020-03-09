package techbasics.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import techbasics.domain.model.Response1;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        disableSubMappingMethodsGeneration = true)
public interface Response1Mapper {
    Response1Mapper INSTANCE = Mappers.getMapper(Response1Mapper.class);

    techbasics.api.soapservice.v1.model.Response1 toApi(Response1 value);
}
