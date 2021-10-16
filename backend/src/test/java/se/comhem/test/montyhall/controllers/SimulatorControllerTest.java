package se.comhem.test.montyhall.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import se.comhem.test.montyhall.services.SimulationService;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SimulatorController.class)
class SimulatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    SimulationService simulationService;

    @Test
    void ShouldReturnOk() throws Exception{
        when(simulationService.runSimulation(false, 1)).thenReturn(new ArrayList<>());

        this.mockMvc.perform(get("/simulate/change/false/times/1"))
                .andExpect(status().isOk());
    }

    @Test
    void ShouldReturnBadRequestWhenChangeDoorIsNotBoolValue() throws Exception{
        when(simulationService.runSimulation(false, 1)).thenReturn(new ArrayList<>());

        this.mockMvc.perform(get("/simulate/change/3/times/1"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void ShouldReturnBadRequestWhenNumberOfTimesIsNotIntegerValue() throws Exception{
        when(simulationService.runSimulation(false, 1)).thenReturn(new ArrayList<>());

        this.mockMvc.perform(get("/simulate/change/false/times/3.0"))
                .andExpect(status().isBadRequest());
    }
}