package com.enaa.breif;

import com.enaa.breif.dto.BreifDto;
import com.enaa.breif.mappers.BreifMap;
import com.enaa.breif.model.Breif;
import com.enaa.breif.repository.BreifRepository;
import com.enaa.breif.service.BreifService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BreifTest {
    @Mock
    private BreifRepository breifRepository;

    @Mock
    private BreifMap breifMap;

    @InjectMocks
    private BreifService breifService;

    @Test
    void testAjouterBreif() {
        // Arrange
        BreifDto breifDto = new BreifDto();
        breifDto.setTitre("Test Brief");
        breifDto.setDateDepart(new Date());
        breifDto.setDateFin(new Date());

        Breif breif = new Breif();
        breif.setTitre("Test Brief");
        breif.setDateDepart(new Date());
        breif.setDateFin(new Date());

        Breif savedBreif = new Breif();
//        savedBreif.setId(1L);
        savedBreif.setTitre("Test Brief");
        savedBreif.setDateDepart(new Date());
        savedBreif.setDateFin(new Date());

        BreifDto expectedDto = new BreifDto();
        expectedDto.setTitre("Test Brief");
        expectedDto.setDateDepart(new Date());
        expectedDto.setDateFin(new Date());

        when(breifMap.toEntity(breifDto)).thenReturn(breif);
        when(breifRepository.save(breif)).thenReturn(savedBreif);
        when(breifMap.toDto(savedBreif)).thenReturn(expectedDto);

        // Act
        BreifDto result = breifService.ajouterBreif(breifDto);

        // Assert
        assertNotNull(result);
        assertEquals(expectedDto.getTitre(), result.getTitre());

    }

    @Test
    void GetAllBreifs() {
        // Arrange
        Breif breif1 = new Breif();
//        breif1.setId(1L);
        breif1.setTitre("Brief 1");
        breif1.setDateDepart(new Date());
        breif1.setDateFin(new Date());

        Breif breif2 = new Breif();
//        breif2.setId(2L);
        breif2.setTitre("Brief 2");
        breif2.setDateDepart(new Date());
        breif2.setDateFin(new Date());

        List<Breif> breifs = Arrays.asList(breif1, breif2);

        BreifDto breifDto1 = new BreifDto();
        breifDto1.setTitre("Brief 1");
        breifDto1.setDateDepart(new Date());
        breifDto1.setDateFin(new Date());

        BreifDto breifDto2 = new BreifDto();
        breifDto2.setTitre("Brief 2");
        breifDto2.setDateDepart(new Date());
        breifDto2.setDateFin(new Date());

        List<BreifDto> expectedDtos = Arrays.asList(breifDto1, breifDto2);

        when(breifRepository.findAll()).thenReturn(breifs);
        when(breifMap.toDtos(breifs)).thenReturn(expectedDtos);

        // Act
        List<BreifDto> result = breifService.getAllBreifs();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Brief 1", result.get(0).getTitre());
        assertEquals("Brief 2", result.get(1).getTitre());

    }

}
