package cn.len.spring.cloud.earth.bean;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author len
 * 2019-07-03
 */
@Data
public class UserDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
    @Min(1)
    @Max(150)
    private Integer age;
}
