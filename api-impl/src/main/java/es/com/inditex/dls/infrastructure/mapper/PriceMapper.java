package es.com.inditex.dls.infrastructure.mapper;

import es.com.inditex.dls.infrastructure.adapter.db.model.PriceEntity;
import es.com.inditex.dls.domain.model.Price;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(target = "priceToApply", source = "priceList")
    @Mapping( target = "priceFinal", expression = "java(priceEntity.getPrice() + \" \" + priceEntity.getCurrency())")

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "brandId", source = "brand.id")
    Price toPrice(PriceEntity priceEntity);

}

