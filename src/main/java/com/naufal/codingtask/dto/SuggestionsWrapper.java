package com.naufal.codingtask.dto;

import java.util.List;

public class SuggestionsWrapper {
    private List<CityDTO> suggestions;

    public SuggestionsWrapper(List<CityDTO> suggestions) {
        this.suggestions = suggestions;
    }

    public List<CityDTO> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<CityDTO> suggestions) {
        this.suggestions = suggestions;
    }
}
