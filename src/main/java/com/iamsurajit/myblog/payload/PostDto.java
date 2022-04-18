package com.iamsurajit.myblog.payload;
/*
 1.postDto will be useful to transfering data from controller to service
   and service to controller.
 2. Add validation for POST and PUT service.

 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;

    @NotEmpty
    @Size(min = 2,message = "Post title should have at least 2 character.")
    private String title;

    @NotEmpty
    @Size(min = 10,message = "Description should have at least 10 character")
    private String description;

    @NotEmpty
    @Size(min = 10,message = "Content should have at least 10 character")
    private String content;
}
