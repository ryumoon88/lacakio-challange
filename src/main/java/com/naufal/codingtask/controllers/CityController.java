package com.naufal.codingtask.controllers;

import com.naufal.codingtask.dto.CityDTO;
import com.naufal.codingtask.dto.SuggestionsWrapper;
import com.naufal.codingtask.service.CityService;
import com.naufal.codingtask.utils.WrapWithKey;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "City", description = "The City API")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/suggestions", produces = {"application/json", "application/xml"})
    @Operation(
        summary = "Query a list of closest location from the provided latitude and longitude.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                content = {
                    @Content(schema = @Schema(implementation = SuggestionsWrapper.class))
                }
            )
        }
    )
    @WrapWithKey("suggestions")
    public List<CityDTO> suggestions(
            @RequestParam String q,
            @RequestParam(required = false) Double latitude,
            @RequestParam(required = false) Double longitude
    ) {
        return cityService.getSuggestions(q, latitude, longitude);
    }
}
