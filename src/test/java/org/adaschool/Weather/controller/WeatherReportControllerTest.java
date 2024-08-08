package org.adaschool.Weather.controller;

import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherReportControllerTest {
    @InjectMocks
    private WeatherReportController weatherReportController;

    @Mock
    private WeatherReportService weatherReportService;

    @Test
    public void testGetWeatherReport() {
        double latitude = 28.105;
        double longitude = -150.4678;

        WeatherReport mockReport = new WeatherReport();
        mockReport.setTemperature(50.0);
        mockReport.setHumidity(10.0);

        when(weatherReportService.getWeatherReport(latitude, longitude))
                .thenReturn(mockReport);

        WeatherReport report = weatherReportController.getWeatherReport(latitude, longitude);

        assertEquals(50.0, report.getTemperature(), 0.01);
        assertEquals(10.0, report.getHumidity(), 0.01);
    }

}