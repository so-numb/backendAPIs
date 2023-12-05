package com.fms.feedback.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
    private String itemId;
    private String itemName;
    private float unit;
    private float pricePerUnit;
}
