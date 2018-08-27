package com.mcs.model;

public class term {
    private Long termId;

    private String name;

    private String slug;

    private Long termGroup;

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug == null ? null : slug.trim();
    }

    public Long getTermGroup() {
        return termGroup;
    }

    public void setTermGroup(Long termGroup) {
        this.termGroup = termGroup;
    }
}