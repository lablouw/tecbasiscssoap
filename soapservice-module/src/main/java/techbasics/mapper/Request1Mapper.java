package techbasics.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
		disableSubMappingMethodsGeneration = true)
@SuppressWarnings("squid:S1214")
public interface Request1Mapper {
	Request1Mapper INSTANCE = Mappers.getMapper(Request1Mapper.class);

	techbasics.domain.model.Request1 mapToDomain(techbasics.api.soapservice.v1.model.Request1 value);
}
