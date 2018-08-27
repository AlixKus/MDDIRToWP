package com.mcs.model;

public class termRelationship {
    private Long objectId;

    private Long termTaxonomyId;

    private Integer termOrder;

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Long getTermTaxonomyId() {
        return termTaxonomyId;
    }

    public void setTermTaxonomyId(Long termTaxonomyId) {
        this.termTaxonomyId = termTaxonomyId;
    }

    public Integer getTermOrder() {
        return termOrder;
    }

    public void setTermOrder(Integer termOrder) {
        this.termOrder = termOrder;
    }
}