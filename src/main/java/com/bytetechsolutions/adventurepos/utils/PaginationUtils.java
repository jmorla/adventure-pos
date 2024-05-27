package com.bytetechsolutions.adventurepos.utils;

import com.bytetechsolutions.adventurepos.domain.PagedResponse;

public class PaginationUtils {
    
    public static String buildPageReport(PagedResponse<?> pageInfo) {
        var currentPage = pageInfo.getCurrentPage();
        var pageSize = pageInfo.getNumberOfElements();
        var totalRecords = pageInfo.getTotalElements();

        long startRecord = currentPage > 0 ? currentPage * pageSize : 1;
        long endRecord = Math.min(currentPage + 1 * pageSize, totalRecords);

        return startRecord + " - " + endRecord + " of " + totalRecords;
    }
}
