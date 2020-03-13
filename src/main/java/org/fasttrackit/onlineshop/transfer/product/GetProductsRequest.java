package org.fasttrackit.onlineshop.transfer.product;

public class GetProductsRequest {
    private String partiaName;
    private Integer minQuatity;

    public String getPartialName() {
        return partiaName;
    }

    public void setPartiaName(String partiaName) {
        this.partiaName = partiaName;
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
                "partiaName='" + partiaName + '\'' +
                ", minQuatity=" + minQuatity +
                '}';
    }
}
