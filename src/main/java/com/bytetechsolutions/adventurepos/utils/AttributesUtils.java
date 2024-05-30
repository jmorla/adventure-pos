package com.bytetechsolutions.adventurepos.utils;

import org.springframework.ui.Model;

import com.bytetechsolutions.adventurepos.domain.PagedResponse;
import com.bytetechsolutions.adventurepos.domain.PagedSearchRequest;

import lombok.Builder;
import lombok.Getter;

public class AttributesUtils {
    
    public static String buildPageReport(PagedResponse<?> pageInfo) {
        var currentPage = pageInfo.getCurrentPage();
        var pageSize = pageInfo.getNumberOfElements();
        var totalRecords = pageInfo.getTotalElements();

        long startRecord = currentPage > 0 ? currentPage * pageSize : 1;
        long endRecord = Math.min(currentPage + 1 * pageSize, totalRecords);

        return startRecord + " - " + endRecord + " de " + totalRecords;
    }

    public static void setDefaultPaginationAttributes(Model model, PagedSearchRequest request, PagedResponse<?> response) {
        model.addAttribute("pageNumber", request.getPage());
        model.addAttribute("pageSize", request.getSize());
        model.addAttribute("pages", response.getTotalPages());
        model.addAttribute("currentPageReport", AttributesUtils.buildPageReport(response));
        model.addAttribute("query", request.getQuery());
    }

    public static void setGlobalMessage(Model model, MessageAttributes attributes) {
        model.addAttribute("message", attributes);
    }

    @Builder
    @Getter
    public static class MessageAttributes {
        private Severity severity;
        private String summary;
        private String details;
        private String icon;
        private boolean dismissible;

        public enum Severity {
            INFO, WARNING, DANGER, SUCCESS;
    
            @Override
            public String toString() {
                return this.name().toLowerCase();
            }
        }
    }
}
