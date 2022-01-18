package br.com.mentoria.mentoriajava.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TratativasErro {

    private String item;
    private String error;

}
