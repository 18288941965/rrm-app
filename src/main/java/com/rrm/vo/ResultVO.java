package com.rrm.vo;

import lombok.Data;

/**
 * 返回类
 * @param <T>
 */
@Data
public class ResultVO<T> {
    private int code;
    private String message;
    private T data;

    // Constructors
    public ResultVO() {}

    public ResultVO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVO(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Static factory methods for common responses
    public static <T> ResultVO<T> success() {
        return new ResultVO<>(200, "OK");
    }

    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(200, "OK", data);
    }

    public static <T> ResultVO<T> created(T data) {
        return new ResultVO<>(201, "Created", data);
    }

    public static <T> ResultVO<T> accepted(T data) {
        return new ResultVO<>(202, "Accepted", data);
    }

    public static <T> ResultVO<T> noContent() {
        return new ResultVO<>(204, "No Content");
    }

    public static <T> ResultVO<T> badRequest(String message) {
        return new ResultVO<>(400, message);
    }

    public static <T> ResultVO<T> unauthorized(String message) {
        return new ResultVO<>(401, message);
    }

    public static <T> ResultVO<T> forbidden(String message) {
        return new ResultVO<>(403, message);
    }

    public static <T> ResultVO<T> notFound(String message) {
        return new ResultVO<>(404, message);
    }

    public static <T> ResultVO<T> methodNotAllowed(String message) {
        return new ResultVO<>(405, message);
    }

    public static <T> ResultVO<T> conflict(String message) {
        return new ResultVO<>(409, message);
    }

    public static <T> ResultVO<T> internalServerError(String message) {
        return new ResultVO<>(500, message);
    }

    public static <T> ResultVO<T> notImplemented(String message) {
        return new ResultVO<>(501, message);
    }

    public static <T> ResultVO<T> badGateway(String message) {
        return new ResultVO<>(502, message);
    }

    public static <T> ResultVO<T> serviceUnavailable(String message) {
        return new ResultVO<>(503, message);
    }
}
