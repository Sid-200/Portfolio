package portfolio.example.demo.helper;

import io.micrometer.common.lang.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record Response<T>(boolean isFailed, @Nullable String errorMessage, @Nullable T body) {

    public static <T> ResponseEntity<Response<T>> failed(HttpStatus httpStatus, String errorMessage) {
        Response<T> response = new Response<>(true, errorMessage, null);
        return new ResponseEntity<>(response, httpStatus);
    }

    public static <T> ResponseEntity<Response<T>> success(HttpStatus httpStatus, T body) {
        Response<T> response = new Response<>(false, null, body);
        return new ResponseEntity<>(response, httpStatus);
    }
}
