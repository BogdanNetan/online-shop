package org.fasttrackit.onlineshop.transfer.product;

public class GetProductsRequest {
    private String partialName;
    private Integer minQuatity;

    public String getPartialName() {
        return partialName;
    }

    public void setPartiaName(String partiaName) {
        this.partialName = partiaName;
    }

    public Integer getMinQuatity() {
        return minQuatity;
    }

    public void setMinQuatity(Integer minQuatity) {
        this.minQuatity = minQuatity;
    }

    @Override
    public String toString() {
        return "GetProductsRequest{" +
                "partiaName='" + partialName + '\'' +
                ", minQuatity=" + minQuatity +
                '}';
    }
}
