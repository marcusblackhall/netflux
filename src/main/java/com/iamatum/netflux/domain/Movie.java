package com.iamatum.netflux.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Movie {

    private String id;

    @NonNull
    private String title;
}
