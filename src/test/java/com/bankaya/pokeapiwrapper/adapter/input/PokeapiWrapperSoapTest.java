package com.bankaya.pokeapiwrapper.adapter.input;

import com.bankaya.pokeapiwrapper.application.dto.AbilityDTO;
import com.bankaya.pokeapiwrapper.application.dto.AbilityDetailDTO;
import com.bankaya.pokeapiwrapper.application.dto.BaseExperienceResponse;
import com.bankaya.pokeapiwrapper.application.dto.ComplementDTO;
import com.bankaya.pokeapiwrapper.application.dto.HeldItem;
import com.bankaya.pokeapiwrapper.application.dto.HeldItemDTO;
import com.bankaya.pokeapiwrapper.application.dto.Item;
import com.bankaya.pokeapiwrapper.application.dto.NameRequest;
import com.bankaya.pokeapiwrapper.application.service.QueryPokemonService;
import com.bankaya.pokeapiwrapper.infraestructure.client.PokeapiWrapperClient;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.bind.JAXBException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PokeapiWrapperSoapTest {
	
	@InjectMocks
    private PokeapiWrapperSoap pokeapiWrapperSoap; 

    @Mock
    private HttpServletRequest request;

    @Mock
    private QueryPokemonService queryPokemonService; 
    
    @Mock
	private PokeapiWrapperClient pokerapiWrapperClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    void testAbilities() throws JAXBException {
        NameRequest nameRequest = new NameRequest();
        nameRequest.setName("pikachu");

        when(request.getRemoteAddr()).thenReturn("127.0.0.1");
        List<AbilityDTO> mockAbilities = Arrays.asList(
                new AbilityDTO(new AbilityDetailDTO("bulbasaur", "http://pokeapi.co"),  true, 1),
                new AbilityDTO(new AbilityDetailDTO("ivysaur", "http://pokeapi.co"),  true, 1)
        );
        when(queryPokemonService.getAbilities(any(ComplementDTO.class))).thenReturn(mockAbilities);
        List<AbilityDTO> response = pokeapiWrapperSoap.abilities(nameRequest);

        // Verificar resultados
        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals("bulbasaur", response.get(0).getAbility().getName());
        assertEquals("ivysaur", response.get(1).getAbility().getName());

        // Verificar interacciones con los mocks
        verify(request).getRemoteAddr();
        verify(queryPokemonService).getAbilities(any(ComplementDTO.class));
    }
    
    @Test
    void testAbilities_NOk() throws JAXBException {
        NameRequest nameRequest = new NameRequest();
        nameRequest.setName("bulbasaur");

        when(request.getRemoteAddr()).thenReturn("127.0.0.1");
        List<AbilityDTO> mockAbilities = Arrays.asList(
                new AbilityDTO(new AbilityDetailDTO("bulbasaur", "http://"),  true, 1),
                new AbilityDTO(new AbilityDetailDTO("ivysaur", "http://"),  true, 1)
        );
        when(queryPokemonService.getAbilities(any(ComplementDTO.class))).thenReturn(mockAbilities);
        List<AbilityDTO> response = pokeapiWrapperSoap.abilities(nameRequest);

        // Verificar resultados
        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals("bulbasaur", response.get(0).getAbility().getName());
        assertEquals("ivysaur", response.get(1).getAbility().getName());

        // Verificar interacciones con los mocks
        verify(request).getRemoteAddr();
        verify(queryPokemonService).getAbilities(any(ComplementDTO.class));
    }
    
    @Test
    void testBaseExperience() throws JAXBException {
        // Entrada simulada
    	NameRequest nameRequest = new NameRequest();
        nameRequest.setName("bulbasaur");
        int mockBaseExperience = 112;

        // Configuración del mock
        when(queryPokemonService.getBaseExperience(any(ComplementDTO.class))).thenReturn(mockBaseExperience);

        // Llamar al método bajo prueba
        BaseExperienceResponse response = pokeapiWrapperSoap.base_experience(nameRequest);

        // Verificar que la respuesta no sea nula y contenga los datos correctos
        assertNotNull(response);
        assertEquals(mockBaseExperience, response.getBase_experience());

        // Verificar que se llamó al método del servicio con el parámetro correcto
        verify(queryPokemonService).getBaseExperience(any(ComplementDTO.class));
    }
    
    @Test
    void testHeldItems() throws JAXBException {
    	// Entrada simulada
    	NameRequest nameRequest = new NameRequest();
        nameRequest.setName("bulbasaur");

        Item item = new Item();
        item.setName("charcoal");
        item.setUrl("http://url");
        HeldItem heldItem = new HeldItem();
        heldItem.setItem(item);
        List<HeldItem> listItems = new ArrayList<>();
        listItems.add(heldItem);
        // Datos simulados para la respuesta
        List<HeldItemDTO> mockHeldItems = Arrays.asList(
                new HeldItemDTO(listItems)
        );

        // Configuración del comportamiento del mock
        when(queryPokemonService.getHeldItems(any(ComplementDTO.class))).thenReturn(mockHeldItems);

        // Llamar al método bajo prueba
        List<HeldItemDTO> response = pokeapiWrapperSoap.held_items(nameRequest);

        // Verificar que la respuesta no sea nula y contenga los elementos esperados
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals("charcoal", response.get(0).getHeldItems().get(0).getItem().getName());

        // Verificar que el servicio fue llamado con el parámetro correcto
        verify(queryPokemonService).getHeldItems(any(ComplementDTO.class));
    }
    
    @Test
    void testId() throws JAXBException {
        // Entrada simulada
    	NameRequest nameRequest = new NameRequest();
        nameRequest.setName("bulbasaur");
        

        // Salida simulada del servicio
        int mockId = 1;

        // Configuración del mock
        when(queryPokemonService.getId(any(ComplementDTO.class))).thenReturn(mockId);

        // Llamar al método bajo prueba
        int response = pokeapiWrapperSoap.id(nameRequest);

        // Verificar la respuesta
        assertEquals(mockId, response);

        // Verificar que el servicio fue llamado con el parámetro correcto
        verify(queryPokemonService).getId(any(ComplementDTO.class));
    }
    
    @Test
    void testGetNameSuccess() throws JAXBException {
    	// Entrada simulada
    	NameRequest nameRequest = new NameRequest();
        nameRequest.setName("bulbasaur");
        // Configuración del mock para simular éxito
        when(queryPokemonService.getName(any(ComplementDTO.class))).thenReturn(nameRequest.getName());

        // Llamar al método bajo prueba
        String response = pokeapiWrapperSoap.name(nameRequest);

        // Verificar que el resultado sea igual al nombre ingresado
        assertEquals(nameRequest.getName(), response);

        // Verificar que se llamó al cliente Feign con el parámetro correcto
        verify(queryPokemonService).getName(any(ComplementDTO.class));
    }

   
    
}


