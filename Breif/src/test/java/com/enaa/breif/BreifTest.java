package com.enaa.breif;

import com.enaa.breif.Dto.BreifDto;
import com.enaa.breif.Mappers.BreifMap;
import com.enaa.breif.Model.Breif;
import com.enaa.breif.Repository.BreifRepository;
import com.enaa.breif.Service.BreifService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

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
        savedBreif.setId(1L);
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
}
