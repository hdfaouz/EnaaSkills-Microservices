package com.enaa.apprenant;

import com.enaa.apprenant.Dto.ApprenantDto;
import com.enaa.apprenant.Mappers.ApprenantMap;
import com.enaa.apprenant.Model.Apprenant;
import com.enaa.apprenant.Repositories.ApprenantRepository;
import com.enaa.apprenant.Service.ApprenantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApprenantTest {
    @Mock
    private ApprenantRepository apprenantRepository;

    @Mock
    private ApprenantMap apprenantMap;

    @InjectMocks
    private ApprenantService apprenantService;

    @Test
    void ajouterApprenant() {
        // Données de test
        ApprenantDto apprenantDto = new ApprenantDto();
        apprenantDto.setNom("Dupont");
        apprenantDto.setPrenom("Jean");
        apprenantDto.setEmail("jean.dupont@email.com");

        Apprenant apprenant = new Apprenant();
        apprenant.setNom("Dupont");
        apprenant.setPrenom("Jean");
        apprenant.setEmail("jean.dupont@email.com");

        Apprenant savedApprenant = new Apprenant();
        savedApprenant.setId(1L);
        savedApprenant.setNom("Dupont");
        savedApprenant.setPrenom("Jean");
        savedApprenant.setEmail("jean.dupont@email.com");

        ApprenantDto expectedDto = new ApprenantDto();

        expectedDto.setNom("Dupont");
        expectedDto.setPrenom("Jean");
        expectedDto.setEmail("jean.dupont@email.com");

        // Configuration des mocks
        when(apprenantMap.toEntity(apprenantDto)).thenReturn(apprenant);
        when(apprenantRepository.save(apprenant)).thenReturn(savedApprenant);
        when(apprenantMap.toDto(savedApprenant)).thenReturn(expectedDto);

        // Exécution
        ApprenantDto result = apprenantService.ajouterApprenant(apprenantDto);

        // Vérifications
        assertNotNull(result);
        assertEquals("Dupont", result.getNom());
        assertEquals("Jean", result.getPrenom());
        assertEquals("jean.dupont@email.com", result.getEmail());
    }
}
