package controllers;

import lombok.Data;

@Data
class BaseResponse<T>{

    private String status;

    private T data;

    BaseResponse(T result){

        if (result != null) {
            this.status = Resources.SUCCESS_STATUS;
            this.data = result;
        } else {
            this.status = Resources.UNSUCCESS_STATUS;
        }
    }

    BaseResponse(Boolean result){

        if (result != null && result) {
            this.status = Resources.SUCCESS_STATUS;
        } else {
            this.status = Resources.UNSUCCESS_STATUS;
        }
    }
}