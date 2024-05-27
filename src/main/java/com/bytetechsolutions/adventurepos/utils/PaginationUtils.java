package com.bytetechsolutions.adventurepos.utils;

import org.springframework.ui.Model;

import com.bytetechsolutions.adventurepos.domain.PagedResponse;
import com.bytetechsolutions.adventurepos.domain.PagedSearchRequest;

public class PaginationUtils {
    
    public static String buildPageReport(PagedResponse<?> pageInfo) {
        var currentPage = pageInfo.getCurrentPage();
        var pageSize = pageInfo.getNumberOfElements();
        var totalRecords = pageInfo.getTotalElements();

        long startRecord = currentPage > 0 ? currentPage * pageSize : 1;
        long endRecord = Math.min(currentPage + 1 * pageSize, totalRecords);

        return startRecord + " - " + endRecord + " de " + totalRecords;
    }

    public static void setDefaultPaginationAttributes(Model model, PagedSearchRequest request, PagedResponse<?> response) {
        model.addAttribute("products", response.getContent());
        model.addAttribute("pageNumber", request.getPage());
        model.addAttribute("pageSize", request.getSize());
        model.addAttribute("pages", response.getTotalPages());
        model.addAttribute("currentPageReport", PaginationUtils.buildPageReport(response));
        model.addAttribute("query", request.getQuery());
    }
}
