package portfolio.example.demo.helper;

import io.micrometer.common.lang.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


    public record Response<T>(boolean failed, @Nullable String message, @Nullable T body) {

        public static <T> ResponseEntity<Response<T>> failed(String message, T body) {
            Response<T> response = new Response<>(true, message, body);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        public static <T> ResponseEntity<Response<T>> success(String message, T body) {
            Response<T> response = new Response<>(false, message, body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

