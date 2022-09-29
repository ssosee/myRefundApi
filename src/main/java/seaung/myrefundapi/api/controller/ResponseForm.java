package seaung.myrefundapi.api.controller;

import lombok.Data;

@Data
public class ResponseForm {
    private int status;
    private String message = "";
    private Object data;
    private String error = "";
}
