package com.daofab.transactions.utils;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * A custom implementation of Spring Data's Pageable
 * interface that is used
 * to apply sorting only without pagination.
 */
public class SortOnlyPageable implements Pageable {

    private final Sort sort;

    /**
     * Constructs a SortOnlyPageable with the specified sorting criteria.
     *
     * @param sort The sorting criteria to be applied.
     */
    public SortOnlyPageable(Sort sort) {
        this.sort = sort;
    }

    @Override
    public int getPageNumber() {
        return 0; // Since there is no page number, always set to 0
    }

    @Override
    public int getPageSize() {
        return Integer.MAX_VALUE; // Set to a very large value to retrieve all data
    }

    @Override
    public long getOffset() {
        return 0; // No offset for the first page
    }

    @Override
    public Sort getSort() {
        return sort; // Return the provided sorting field
    }

    @Override
    public Pageable next() {
        return this; // No next page
    }

    @Override
    public Pageable previousOrFirst() {
        return first();
    }

    @Override
    public Pageable first() {
        return this; // Only one page
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return this;
    }

    @Override
    public boolean hasPrevious() {
        return false; // No previous page
    }
}
