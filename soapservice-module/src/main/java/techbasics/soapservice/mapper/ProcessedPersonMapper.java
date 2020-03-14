package techbasics.soapservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, disableSubMappingMethodsGeneration = true)
@SuppressWarnings("squid:S1214")
public interface ProcessedPersonMapper {
	ProcessedPersonMapper INSTANCE = Mappers.getMapper(ProcessedPersonMapper.class);

	techbasics.soapservice.api.v1.model.ProcessedPerson mapToV1(techbasics.common.domain.model.ProcessedPerson value);

	techbasics.soapservice.api.v2.model.ProcessedPerson mapToV2(techbasics.common.domain.model.ProcessedPerson value);
}
