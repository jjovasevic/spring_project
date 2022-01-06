package com.esense.projekat_fpisv2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InsertObject {

    private FakturaInsert fakturaInsert;
    private List<StavkaFaktureInsert> stavkaFaktureInsert;
}
