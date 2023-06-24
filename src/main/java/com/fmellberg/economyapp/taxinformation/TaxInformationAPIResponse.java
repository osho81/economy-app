package com.fmellberg.economyapp.taxinformation;


import java.util.List;

public class TaxInformationAPIResponse {

//    private String next;
//    private int resultCount;
//    private int offset;
//    private int limit;
//    private int queryTime;
    private List<TaxInformationDTOResponse> results;

    public TaxInformationAPIResponse() {
    }

//    public String getNext() {
//        return next;
//    }
//
//    public void setNext(String next) {
//        this.next = next;
//    }
//
//    public int getResultCount() {
//        return resultCount;
//    }
//
//    public void setResultCount(int resultCount) {
//        this.resultCount = resultCount;
//    }
//
//    public int getOffset() {
//        return offset;
//    }
//
//    public void setOffset(int offset) {
//        this.offset = offset;
//    }
//
//    public int getLimit() {
//        return limit;
//    }
//
//    public void setLimit(int limit) {
//        this.limit = limit;
//    }
//
//    public int getQueryTime() {
//        return queryTime;
//    }
//
//    public void setQueryTime(int queryTime) {
//        this.queryTime = queryTime;
//    }

    public List<TaxInformationDTOResponse> getResults() {
        return results;
    }

    public void setResults(List<TaxInformationDTOResponse> results) {
        this.results = results;
    }
}
