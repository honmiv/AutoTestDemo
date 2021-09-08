package dto;

import lombok.Value;

/**
 * модель ответа сервиса
 */

@Value
public class ResponseDto {
    String clientId;
    Sexes sex;
}
