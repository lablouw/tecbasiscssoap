package techbasics.soapservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, disableSubMappingMethodsGeneration = true)
@SuppressWarnings("squid:S1214")
public interface PersonMapper {
	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

	@Mappings(@Mapping(target = "dateOfBirth", ignore = true))
	techbasics.common.domain.model.Person mapToDomain(techbasics.soapservice.api.v1.model.Person value);

	@Mappings(@Mapping(target = "age", ignore = true))
	techbasics.common.domain.model.Person mapToDomain(techbasics.soapservice.api.v2.model.Person value);
}
