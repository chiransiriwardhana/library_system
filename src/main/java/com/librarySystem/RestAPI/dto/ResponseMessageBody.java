package com.librarySystem.RestAPI.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.librarySystem.RestAPI.model.Book;
//import com.librarySystem.RestAPI.model.User;
import com.librarySystem.RestAPI.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessageBody {


    public ResponseMessageBody(String message) {
        this.message = message;

    }

    public ResponseMessageBody(User user){
        this.user = user;
    }

    public ResponseMessageBody(Book book){
        this.book = book;
    }
    @JsonProperty("message")
    private String message;

    @JsonProperty("user")
    private User user;

    @JsonProperty("book")
    private Book book;


}
