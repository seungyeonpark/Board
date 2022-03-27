package com.project.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class SearchTypeCodeValue {

    private String code;
    private String value;

    public static List<SearchTypeCodeValue> getSearchTypeCodeValueList() {

        List<SearchTypeCodeValue> searchTypeCodeValueList = new ArrayList<>();

        searchTypeCodeValueList.add(new SearchTypeCodeValue("t", "Title"));
        searchTypeCodeValueList.add(new SearchTypeCodeValue("c", "Content"));
        searchTypeCodeValueList.add(new SearchTypeCodeValue("w", "Writer"));

        return searchTypeCodeValueList;
    }
}
