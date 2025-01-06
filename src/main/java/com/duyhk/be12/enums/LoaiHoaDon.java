package com.duyhk.be12.enums;

import lombok.Getter;

public enum LoaiHoaDon {
    TAI_QUAY(1),
    ONLINE(2);

    @Getter
    private int value;

    LoaiHoaDon(int value) {
        this.value = value;
    }
}
