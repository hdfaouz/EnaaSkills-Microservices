package com.enaa.rendu.Mappers;


import com.enaa.rendu.dto.Rendudto;
import com.enaa.rendu.Model.Rendu;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface RenduMap {

    Rendu toEntity (Rendudto renduDto);
    Rendudto toDto (Rendu rendu);
    List<Rendudto> toDtos(List<Rendu> renduList);

}
