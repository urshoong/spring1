package org.zerock.spring1.dto;

import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class TodoAddDTO {

    @NotEmpty
    private String title;

    @Size(min = 10, max = 1000)
    private String memo;

    @NotEmpty
    private String writer;

    @FutureOrPresent
    private LocalDate dueDate;

}
